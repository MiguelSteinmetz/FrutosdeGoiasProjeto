

package main;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;
import pagamento.Pagamento;
import pagamento.PagamentoCartao;
import pagamento.PagamentoDinheiro;
import pagamento.TipoCartao;
import repository.ProducaoRepository;
import service.LogService;
import service.ProdutoService;
import service.UsuarioService;
import service.VendaService;


public class Sistema {


    private Scanner sc;
    private UsuarioService usuario;
    private ProdutoService produtos;
    private VendaService sistemavendas;
    private Usuario logado;
    private ProducaoRepository producaoRepo;
    private VendaService vendaService = new VendaService();
    private LogService logService = new LogService();


    public Sistema() {

        this.sc = new Scanner(System.in);
        this.usuario = new UsuarioService();
        this.produtos = new ProdutoService();
        this.sistemavendas = new VendaService();
        this.logado = null;
        this.producaoRepo = new ProducaoRepository();

    }

    public void iniciar() {
        this.inicializarDados();

        while(true) {
            while(this.logado != null) {
                this.exibirMenuPrincipal();
            }

            this.exibirLogin();
        }
    }

    private void exibirLogin() {
        System.out.println("\n---      FRUTOS DE GOIÀS     ---");
        System.out.println("\n--- LOGIN SISTEMA SORVETERIA ---");
        System.out.print("Login: ");
        String login = this.sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

       boolean logado = usuario.autenticar(login, senha);

        if (!logado) {
            System.out.println(" Usuario ou senha incorreto");
        } else {
            System.out.println("Login realizado com sucesso!!!");
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n---      FRUTOS DE GOIÀS     ---");
        System.out.println("\n=== MENU PRINCIPAL (" + logado.getTipo() + ") ===");
        System.out.println("---- Opcoes de Venda ----");
        System.out.println("1. Realizar Venda");
        System.out.println("2. Ver Cardápio");

        if (logado.getTipo().equals("Gerente")) {
            System.out.println("3. Relatorios");
            System.out.println("4. Opçoes Produto");
            System.out.println("5. Opçoes funcionario");
        }

        System.out.println("0. Logout");
        System.out.print("Escolha: ");
        int op = this.lerInteiro();
        switch (op) {
            case 0:
                this.logado = null;
                break;
            case 1:
                this.realizarVenda();
                break;
            case 2:
                this.listarProdutos();
                break;

            case 3:
                if (logado.getTipo().equals("Gerente")) {
                    System.out.println("\n====Relatorios====\n");
                    System.out.println("1. Relatório de Vendas");
                    System.out.println("2. Top Produtos Vendidos");
                    System.out.println("3. Reletario Financeiro");
                    System.out.println("4. Total Vendidos por Produto");
                    System.out.println("5. Ver Produzidos");
                    System.out.println("6. Ver Logs");
                    System.out.print("Escolha: ");
                    int opc = lerInteiro();
                    switch (opc) {
                        case 1:
                            this.exibirRelatorio();
                            break;
                        case 2:
                            this.topProdutosVendidos();
                            break;
                        case 3:
                            this.relatorioFinanceiro();
                            ;
                            break;
                        case 4:
                            this.totalVendidoPorProduto();
                            break;
                        case 5:
                            listarProducao();
                            break;
                        case 6:
                            listarLogs();
                            break;
                        default:
                            System.out.println("Opção inválida!");

                    }
                } else {
                    this.acessoNegado();
                }
                break;
            case 4:
                if (logado.getTipo().equals("Gerente")) {
                    System.out.println("\n===Opçoes Produtos===\n");
                    System.out.println("1. Deletar Produto");
                    System.out.println("2. Editar Produto");
                    System.out.println("3. Cadastrar Produto");
                    System.out.println("4. Registrar Producao");
                    System.out.print("Escolha: ");
                    int opc = lerInteiro();
                    switch (opc) {
                        case 1:
                            this.deletarProduto();
                            break;
                        case 2:
                            this.editarProduto();
                            break;
                        case 3:
                            this.cadastrarProduto();
                            break;
                        case 4:
                            this.registrarProducao();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } else {
                    this.acessoNegado();
                }
                break;
            case 5:
                if (logado.getTipo().equals("Gerente")) {
                    System.out.println("\n==Opçoes Funcionarios==\n");
                    System.out.println("1. Cadastrar Funcionário");
                    System.out.println("2. Listar Funcionarios");
                    System.out.print("Escolha: ");
                    int opc = lerInteiro();
                    switch (opc) {
                        case 1:
                            cadastrarFuncionario();
                            break;
                        case 2:
                            listarUsuarios();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                }else {
                    acessoNegado();
                }
            default:
                System.out.println("Opção inválida!");
        }

    }
    private void listarUsuarios(){

        if (produtos.listaProdutos().isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
        } else {
            System.out.println("\nID | NOME | CARGO\n");

            for(Usuario u : usuario.listaUsuarios()){

                System.out.printf(
                        "%d | %s | %s \n",
                        u.getId(),
                        u.getNome(),
                        u.getTipo()
                );
            }
        }
    }

    private void realizarVenda() {
        List<ItemCarrinho> carrinho = new ArrayList<>();

        while(true) {
           listarProdutos();
            System.out.print("ID do produto (0 para finalizar compra): ");
            int id = lerInteiro();

            //Caso Digite 0
            if (id == 0) {
                if (carrinho.isEmpty()) {
                    return;
                } else {
                    double total = 0.0F;

                    for(ItemCarrinho item : carrinho) {
                        total += item.getSubtotal();
                    }
                    System.out.printf("\nTOTAL: R$ %.2f\n", total);
                    System.out.println("1 - Cartão | 2 - Dinheiro");
                    int opc = lerInteiro();

                    Pagamento forma;

                    if (opc == 1) {
                        System.out.println("1 - 🏧 Débito | 2 - 💳 Crédito");
                        int tipo = lerInteiro();

                        if (tipo == 1) {
                            forma = new PagamentoCartao(TipoCartao.DEBITO);
                        } else {
                            forma = new PagamentoCartao(TipoCartao.CREDITO);
                        }

                    } else {
                        forma = new PagamentoDinheiro();
                    }

                    for (ItemCarrinho item : carrinho) {

                        Venda novaVenda = new Venda(
                                logado,
                                item.getProduto(),
                                (int) item.getQuantidade(),
                                item.getSubtotal(),
                                forma.getNome()
                        );
                        sistemavendas.salvarVenda(novaVenda);
                        //log venda
                        logService.registrar(
                                logado.getNome(),
                                "Registrou venda"
                        );
                    }

                    double finalValor = forma.calcularValorFinal(total);

                    for(ItemCarrinho item : carrinho) {
                        item.getProduto().baixarEstoque(item.getQuantidade());
                    }

                    System.out.printf("Venda concluída: R$ %.2f\n", finalValor);
                    return;

                }
            }

            //Caso o Usuario, nao digite 0
            Produto p = produtos.buscarPorId(id);
            if (p != null) {
                System.out.print("Quantidade: ");
                double qtd = lerDouble();
                if (qtd <= (double)p.getEstoque()) {
                    carrinho.add(new ItemCarrinho(p, qtd));
                    System.out.println("Adicionado!");
                } else {
                    System.out.println("Estoque insuficiente!");
                }
            }
        }


    }

    private void listarProdutos() {

        if (produtos.listaProdutos().isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
        } else {
            System.out.println("\nID | NOME | PREÇO | ESTOQUE\n");

            for(Produto p : produtos.listaProdutos()) {

                System.out.printf(
                        "%d | %s | R$ %.2f | %d \n",
                        p.getId(),
                        p.getNome(),
                        p.getPreco(),
                        p.getEstoque()
                );
            }

        }
    }

    private void listagemCompleta(){

            if (produtos.listaProdutos().isEmpty()) {
                System.out.println("\nNenhum produto cadastrado.");
            } else {
                System.out.println("\nID | NOME | PREÇO | CUSTO | LUCRO | MARGEM | ESTOQUE\n");

                for(Produto p : produtos.listaProdutos()) {

                    System.out.printf(
                            "%d | %s | R$ %.2f | R$ %.2f |  %.2f%% | %d \n",
                            p.getId(),
                            p.getNome(),
                            p.getPreco(),
                            p.getLucroBrutoUnitario(),
                            p.getMargemLucro(),
                            p.getEstoque()
                    );
                }
            }
    }


    private void cadastrarProduto() {
        System.out.print("Nome: ");
        String nome = this.sc.nextLine();
        System.out.print("Preço: ");
        double preco = this.lerDouble();
        System.out.print("Estoque: ");
        int estoque = this.lerInteiro();
        System.out.print("informe o custo do produto:");
        double custo = this.lerDouble();

        Produto p = new Produto(nome, preco, estoque,custo);

        produtos.salvarProduto(p);
        System.out.println("Produto cadastrado!");

        logService.registrar(
                logado.getNome(),
                "Registrou produção do produto " + p.getNome()
        );
    }

    private void editarProduto() {
        listarProdutos();
        System.out.print("ID: ");
        int id = this.lerInteiro();
        Produto p = this.produtos.buscarPorId(id);
        if (p != null) {
            System.out.print("Novo nome: ");
            p.setNome(this.sc.nextLine());
            System.out.print("Novo preço: ");
            p.setPreco(this.lerDouble());
            System.out.print("Novo estoque: ");
            p.setEstoque(lerInteiro());
            produtos.atualizar(p);
            System.out.println("Atualizado!");
        }

    }

    private void deletarProduto() {
        listarProdutos();
        System.out.print("digite um id: ");
        int opc = lerInteiro();
        produtos.deletar(produtos.buscarPorId(opc));
        System.out.println("Produto deletado");
        listarProdutos();
    }

    private void cadastrarFuncionario() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.println("Cargo ");
        System.out.println("|1 - Gerente | 2 - Funcionario |");
        int opc = lerInteiro();
        String tipo = (opc ==  1 )? "Gerente" : "Funcionario";


       usuario.cadastrar(new Usuario(nome, login, senha, tipo));
        System.out.println("Funcionário cadastrado!");
    }

    private void exibirRelatorio() {

        for (Venda v : sistemavendas.relatorioVendas()) {

            System.out.printf("Vendedor: %s | Produto: %s | Qtd: %d | Total: R$ %.2f | Tipo Pagamento: %s\n",
                    v.getUsuario().getNome(), v.getProduto().getNome(), v.getQuantidade(), v.getValorTotal(), v.getTipoPagamento());

        }
    }

    private void acessoNegado() {System.out.println("Acesso permitido apenas para gerente!");
    }
    private int lerInteiro() {
        while(true) {
            try {
                return Integer.parseInt(this.sc.nextLine());
            } catch (Exception var2) {
                System.out.print("Número inválido: ");
            }
        }
    }

    private double lerDouble() {
        while(true) {
            try {
                return Double.parseDouble(this.sc.nextLine().replace(",", "."));
            } catch (Exception var2) {
                System.out.print("Valor inválido: ");
            }
        }
    }

    private void inicializarDados() {

    }

    private void registrarProducao() {

        listarProdutos();
        System.out.print("\nID do produto: ");
        int id = lerInteiro();
        Produto produto = produtos.buscarPorId(id);

        System.out.print("Quantidade produzida: ");
        double qtd = lerDouble();

        Producao producao = new Producao(produto, qtd);

        producaoRepo.salvar(producao);
        produto.adicionarEstoque(qtd);

        logService.registrar(
                logado.getNome(),
                "Registrou produção do produto " + produto.getNome()
        );
    }

    private void totalVendidoPorProduto() {
        listarProdutos();
        System.out.println("ID do produto: ");
        int id = lerInteiro();

        Long total = sistemavendas.totalVendidoPorProduto(id);

        System.out.println("---- Produto Total Vendido ----");
        System.out.println();
        System.out.println("\nTotal vendido: " + total);
        System.out.println();
    }

    private void topProdutosVendidos() {

        List<Object[]> resultado = sistemavendas.topProdutosVendidos();

        System.out.println("\n--- TOP PRODUTOS VENDIDOS ---");

        for (Object[] row : resultado) {
            System.out.println(row[0] + " - " + row[1]);
        }
    }

    private void listarProducao() {

        if (producaoRepo.buscarTodos().isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
        } else {
            System.out.println();
            System.out.println("---- Produtos Produzidos ----");
            System.out.println();
            System.out.println("\nID | NOME | QUANTIDADE | DATA |");

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            for(Producao p : producaoRepo.buscarTodos()) {
                System.out.printf(
                        "%d | %s | %.2f | %s\n",
                        p.getId(),
                        p.getProduto().getNome(),
                        p.getQuantidade(),
                        p.getData().format(formatter));
                }
            }

        }

    private void relatorioFinanceiro() {


        List<Venda> vendas = vendaService.listarVendas();

        if (vendas.isEmpty()) {
            System.out.println("\nNenhuma venda registrada.");
            return;
        }

        double faturamentoTotal = 0;
        double custoTotal = 0;
        double lucroTotal = 0;
        double quantidadeTotal = 0;

        Produto produtoMaisLucrativo = null;
        double maiorLucro = 0;

        for (Venda v : vendas) {

            Produto p = v.getProduto();

            double precoVenda = (p.getPreco() != null) ? p.getPreco() : 0;
            double custo = p.getCusto() != null ? p.getCusto() : 0;

            double faturamento = precoVenda * v.getQuantidade();
            double custoVenda = custo * v.getQuantidade();
            double lucro = faturamento - custoVenda;

            faturamentoTotal += faturamento;
            custoTotal += custoVenda;
            lucroTotal += lucro;
            quantidadeTotal += v.getQuantidade();

            if (lucro > maiorLucro) {
                maiorLucro = lucro;
                produtoMaisLucrativo = p;
            }
        }

        double margemMedia = faturamentoTotal == 0
                ? 0
                : (lucroTotal / faturamentoTotal) * 100;

        System.out.println("\n---- RELATORIO FINANCEIRO ----");

        System.out.printf("Faturamento total: R$ %.2f\n", faturamentoTotal);
        System.out.printf("Custo total: R$ %.2f\n", custoTotal);
        System.out.printf("Lucro bruto total: R$ %.2f\n", lucroTotal);
        System.out.printf("Margem media: %.2f%%\n", margemMedia);
        System.out.printf("Quantidade vendida: %.2f\n", quantidadeTotal);

        if (produtoMaisLucrativo != null) {
            System.out.printf(
                    "Produto mais lucrativo: %s (R$ %.2f)\n",
                    produtoMaisLucrativo.getNome(),
                    maiorLucro
            );
        }

        System.out.println("------------------------------------------------");
    }
    private void listarLogs() {


        for (LogSistema log : logService.listarTodos()) {

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                System.out.println("---- LOG DO SISTEMA ----");
                System.out.printf(
                    "%s | %s | %s\n",
                    log.getUsuario(),
                    log.getAcao(),
                    log.getData().format(formatter)   );



        }
    }
}

