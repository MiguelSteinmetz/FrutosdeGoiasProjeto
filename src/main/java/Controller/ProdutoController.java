package Controller;

import model.Produto;
import model.Usuario;
import model.Producao;
import repository.ProducaoRepository;
import service.LogService;
import service.ProdutoService;

import java.util.List;


public class ProdutoController {

    //
    // Dependências
    //
    private final ProdutoService produtoService;
    private final ProducaoRepository producaoRepository;
    private final LogService logService;

    //
    // Construtor
    //

    public ProdutoController() {
        this.produtoService      = new ProdutoService();
        this.producaoRepository  = new ProducaoRepository();
        this.logService          = new LogService();
    }

    public List<Produto> listarProdutos() {
        return produtoService.listaProdutos();
    }


    public Produto buscarPorId(int id) {
        return produtoService.buscarPorId(id);
    }


    public List<Producao> listarProducoes() {
        return producaoRepository.buscarTodos();
    }

    //
    // CADASTRAR PRODUTO
    //


    public ResultadoOperacao cadastrarProduto(String nome, double preco,
                                              double custo, int estoque,
                                              Usuario usuarioLogado) {
        // 1. Validações
        ResultadoOperacao validacao = validarCamposProduto(nome, preco, custo, estoque);
        if (!validacao.isSucesso()) return validacao;

        // 2. Cria e salva o produto
        Produto novoProduto = new Produto(nome.trim(), preco, estoque, custo);
        produtoService.salvarProduto(novoProduto);

        // 3. Registra log
        logService.registrar(
                usuarioLogado.getNome(),
                "Cadastrou produto: " + novoProduto.getNome()
        );

        return ResultadoOperacao.sucesso("Produto \"" + novoProduto.getNome() + "\" cadastrado com sucesso!");
    }

    //
    // EDITAR PRODUTO
    //


    public ResultadoOperacao editarProduto(int produtoId, String novoNome,
                                           double novoPreco, double novoCusto,
                                           int novoEstoque, Usuario usuarioLogado) {
        // 1. Busca o produto
        Produto produto = produtoService.buscarPorId(produtoId);
        if (produto == null) {
            return ResultadoOperacao.erro("Produto não encontrado.");
        }

        // 2. Valida os novos dados
        ResultadoOperacao validacao = validarCamposProduto(novoNome, novoPreco, novoCusto, novoEstoque);
        if (!validacao.isSucesso()) return validacao;

        // 3. Aplica as alterações
        produto.setNome(novoNome.trim());
        produto.setPreco(novoPreco);
        produto.setCusto(novoCusto);
        produto.setEstoque(novoEstoque);

        produtoService.atualizar(produto);

        // 4. Registra log
        logService.registrar(
                usuarioLogado.getNome(),
                "Editou produto: " + produto.getNome() + " (ID " + produtoId + ")"
        );

        return ResultadoOperacao.sucesso("Produto \"" + produto.getNome() + "\" atualizado com sucesso!");
    }

    //
    // DELETAR PRODUTO
    //

    public ResultadoOperacao deletarProduto(int produtoId, Usuario usuarioLogado) {

        // 1. Busca o produto
        Produto produto = produtoService.buscarPorId(produtoId);
        if (produto == null) {
            return ResultadoOperacao.erro("Produto não encontrado.");
        }

        String nomeProduto = produto.getNome();

        // 2. Deleta via service
        produtoService.deletar(produto);

        // 3. Registra log
        logService.registrar(
                usuarioLogado.getNome(),
                "Deletou produto: " + nomeProduto + " (ID " + produtoId + ")"
        );

        return ResultadoOperacao.sucesso("Produto \"" + nomeProduto + "\" removido com sucesso.");
    }

    //
    // REGISTRAR PRODUÇÃO
    //


    public ResultadoOperacao registrarProducao(int produtoId, double quantidadeProduzida,
                                               Usuario usuarioLogado) {
        //  Validacoes
        if (quantidadeProduzida <= 0) {
            return ResultadoOperacao.erro("A quantidade produzida deve ser maior que zero.");
        }

        Produto produto = produtoService.buscarPorId(produtoId);
        if (produto == null) {
            return ResultadoOperacao.erro("Produto não encontrado.");
        }

        //  Cria e salva o registro de produção
        Producao producao = new Producao(produto, quantidadeProduzida);
        producaoRepository.salvar(producao);

        //  Atualiza estoque no banco
        produto.adicionarEstoque(quantidadeProduzida);
        produtoService.atualizar(produto);

        //  Registra log
        logService.registrar(
                usuarioLogado.getNome(),
                "Registrou produção de " + quantidadeProduzida + " unidades de \"" + produto.getNome() + "\""
        );

        return ResultadoOperacao.sucesso(
                String.format("Produção registrada! Estoque de \"%s\" atualizado para %d unidades.",
                        produto.getNome(), produto.getEstoque())
        );
    }

    //
    // VALIDACAO PRIVADA — reutilizada por cadastrar e editar
    //

    private ResultadoOperacao validarCamposProduto(String nome, double preco,
                                                   double custo, int estoque) {
        if (nome == null || nome.trim().isEmpty()) {
            return ResultadoOperacao.erro("O nome do produto não pode ser vazio.");
        }
        if (preco <= 0) {
            return ResultadoOperacao.erro("O preço deve ser maior que zero.");
        }
        if (custo < 0) {
            return ResultadoOperacao.erro("O custo não pode ser negativo.");
        }
        if (custo >= preco) {
            return ResultadoOperacao.erro("O custo não pode ser maior ou igual ao preço de venda.");
        }
        if (estoque < 0) {
            return ResultadoOperacao.erro("O estoque não pode ser negativo.");
        }
        return ResultadoOperacao.sucesso("ok");
    }

    //
    // CLASSE AUXILIAR — mesmo padrão do VendaController
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