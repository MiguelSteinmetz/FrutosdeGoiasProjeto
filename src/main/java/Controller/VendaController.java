package controller;

import model.ItemCarrinho;
import model.Produto;
import model.Usuario;
import model.Venda;
import pagamento.Pagamento;
import pagamento.PagamentoCartao;
import pagamento.PagamentoDinheiro;
import pagamento.TipoCartao;
import service.LogService;
import service.ProdutoService;
import service.VendaService;

import java.util.ArrayList;
import java.util.List;


public class VendaController {

    //
    // Dependencias (injetadas pelo construtor)
    //
    private final VendaService vendaService;
    private final ProdutoService produtoService;
    private final LogService logService;

    // Carrinho mantido em memória durante a sessão de venda
    private final List<ItemCarrinho> carrinho;

    //
    // Construtor
    //
    public VendaController() {
        this.vendaService   = new VendaService();
        this.produtoService = new ProdutoService();
        this.logService     = new LogService();
        this.carrinho       = new ArrayList<>();
    }

    //
    // CARRINHO
    //


    public ResultadoOperacao adicionarAoCarrinho(long produtoId, double quantidade) {

        //    Validação de entrada
        if (quantidade <= 0) {
            return ResultadoOperacao.erro("A quantidade deve ser maior que zero.");
        }

        //    Busca o produto via Service
        Produto produto = produtoService.buscarPorId((int) produtoId);
        if (produto == null) {
            return ResultadoOperacao.erro("Produto não encontrado.");
        }

        //    Verifica estoque
        if (quantidade > produto.getEstoque()) {
            return ResultadoOperacao.erro(
                    "Estoque insuficiente. Disponível: " + produto.getEstoque()
            );
        }

        //    Adiciona ao carrinho
        carrinho.add(new ItemCarrinho(produto, quantidade));
        return ResultadoOperacao.sucesso(
                "\"" + produto.getNome() + "\" adicionado ao carrinho."
        );
    }


    public ResultadoOperacao removerDoCarrinho(int indice) {
        if (indice < 0 || indice >= carrinho.size()) {
            return ResultadoOperacao.erro("Item inválido.");
        }
        String nome = carrinho.get(indice).getProduto().getNome();
        carrinho.remove(indice);
        return ResultadoOperacao.sucesso("\"" + nome + "\" removido do carrinho.");
    }


    public List<ItemCarrinho> getCarrinho() {
        return new ArrayList<>(carrinho);
    }


    public double calcularTotal() {
        return carrinho.stream()
                .mapToDouble(ItemCarrinho::getSubtotal)
                .sum();
    }


    public void limparCarrinho() {
        carrinho.clear();
    }

    //
    // FINALIZAR VENDA
    //


    public ResultadoOperacao finalizarVendaDinheiro(Usuario usuarioLogado) {
        Pagamento forma = new PagamentoDinheiro();
        return processarVenda(usuarioLogado, forma);
    }


    public ResultadoOperacao finalizarVendaDebito(Usuario usuarioLogado) {
        Pagamento forma = new PagamentoCartao(TipoCartao.DEBITO);
        return processarVenda(usuarioLogado, forma);
    }


    public ResultadoOperacao finalizarVendaCredito(Usuario usuarioLogado) {
        Pagamento forma = new PagamentoCartao(TipoCartao.CREDITO);
        return processarVenda(usuarioLogado, forma);
    }

    //
    // RELATORIOS (chamados pela View de relatorios)
    //


    public List<Venda> listarTodasVendas() {
        return vendaService.listarVendas();
    }


    public long totalVendidoPorProduto(int produtoId) {
        return vendaService.totalVendidoPorProduto(produtoId);
    }


    public List<Object[]> topProdutosVendidos() {
        return vendaService.topProdutosVendidos();
    }

    //
    // METODO PRIVADO — logica central de venda
    //


    private ResultadoOperacao processarVenda(Usuario usuarioLogado, Pagamento forma) {

        // 1. Validações
        if (usuarioLogado == null) {
            return ResultadoOperacao.erro("Nenhum usuário logado.");
        }
        if (carrinho.isEmpty()) {
            return ResultadoOperacao.erro("O carrinho está vazio.");
        }

        //    Calcula total bruto
        double totalBruto = calcularTotal();

        //    Persiste cada item como uma Venda no banco
        for (ItemCarrinho item : carrinho) {

            Venda novaVenda = new Venda(
                    usuarioLogado,
                    item.getProduto(),
                    (int) item.getQuantidade(),
                    item.getSubtotal(),
                    forma.getNome()
            );

            vendaService.salvarVenda(novaVenda);

            //    Baixa estoque E persiste a alteração no banco
            item.getProduto().baixarEstoque(item.getQuantidade());
            produtoService.atualizar(item.getProduto());
        }

        //    Registra log da venda
        logService.registrar(
                usuarioLogado.getNome(),
                "Realizou venda de " + carrinho.size() + " item(ns) — Total: R$ " +
                        String.format("%.2f", totalBruto)
        );

        //    Calcula valor final com forma de pagamento (ex: +5% credito)
        double valorFinal = forma.calcularValorFinal(totalBruto);

        //    Limpa o carrinho para a proxima venda
        limparCarrinho();

        return ResultadoOperacao.sucesso(
                String.format("Venda concluída! Valor cobrado: R$ %.2f (%s)",
                        valorFinal, forma.getNome())
        );
    }

    //
    // CLASSE AUXILIAR — encapsula o retorno para a View
    //


    public static class ResultadoOperacao {

        private final boolean sucesso;
        private final String mensagem;

        private ResultadoOperacao(boolean sucesso, String mensagem) {
            this.sucesso  = sucesso;
            this.mensagem = mensagem;
        }

        public static ResultadoOperacao sucesso(String mensagem) {
            return new ResultadoOperacao(true, mensagem);
        }

        public static ResultadoOperacao erro(String mensagem) {
            return new ResultadoOperacao(false, mensagem);
        }

        public boolean isSucesso() { return sucesso; }
        public String getMensagem() { return mensagem; }

        @Override
        public String toString() {
            return (sucesso ? "[OK] " : "[ERRO] ") + mensagem;
        }
    }
}