

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;
import org.hibernate.Session;
import pagamento.Pagamento;
import pagamento.PagamentoCartao;
import pagamento.PagamentoDinheiro;
import pagamento.TipoCartao;
import repository.CustomizerFactory;
import repository.ProducaoRepository;
import service.ProdutoService;
import service.UsuarioService;
import service.VendaService;
import repository.VendaRepository;


public class Sistema {


    private Scanner sc;
    private UsuarioService usuario;
    private ProdutoService produtos;
    private VendaService sistemavendas;
    private Usuario logado;
    private ProducaoRepository producaoRepo;


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

       logado = usuario.autenticar(login, senha);

        if (logado == null) {
            System.out.println(" ⚠\uFE0F [X] Usuário ou senha incorretos!");
        } else {
            System.out.println(" ⚠\uFE0F [V] Bem-vindo, " + logado.getNome());
        }

    }

    private void exibirMenuPrincipal() {
        System.out.println("\n---      FRUTOS DE GOIÀS     ---");
        System.out.println("");
        System.out.println("\n=== MENU PRINCIPAL (" + logado.getTipo() + ") ===");
        System.out.println("");
        System.out.println("");
        System.out.println("---- Opcoes de Venda ----");
        System.out.println("1. 🛒 Realizar Venda");
        System.out.println("2. 📋 Ver Cardápio");

        if (logado.getTipo().equals("Gerente")) {
            System.out.println("3. 📊 Relatório de Vendas");
            System.out.println("\n---- 📦 Opções de Produto ----");
            System.out.println("4. ⭐ Top Produtos Vendidos");
            System.out.println("5. ❌ Deletar Produto");
            System.out.println("6. ✏️ Editar Produto");
            System.out.println("7. ➕ Cadastrar Produto");
            System.out.println("8. 🏭 Registrar Produção");
            System.out.println("9. 📈 Total Vendidos por Produto");

            System.out.println("\n---- 👥 Opções de Funcionário ----");
            System.out.println("10. 👤 Cadastrar Funcionário");
            System.out.println("11. 🛑 Encerrar Sistema");
        } else {
            System.out.println("0. 🚪 Sair");
        }

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
                    this.exibirRelatorio();
                } else {
                    this.acessoNegado();
                }
                break;
            case 4:
                if (logado.getTipo().equals("Gerente")) {
                    this.topProdutosVendidos();
                } else {
                    this.acessoNegado();
                }
                break;
            case 5:
                if (logado.getTipo().equals("Gerente")) {
                    this.deletarProduto();
                } else {
                    this.acessoNegado();
                }
                break;
            case 6:
                if (logado.getTipo().equals("Gerente")) {
                    this.editarProduto();
                } else {
                    this.acessoNegado();
                }
                break;
            case 7:
                if (logado.getTipo().equals("Gerente")) {
                    this.cadastrarProduto();
                } else {
                    this.acessoNegado();
                }
                break;
            case 8:
                if (logado.getTipo().equals("Gerente")) {
                    this.registrarProducao();
                } else {
                    this.acessoNegado();
                }
                break;
            case 9:
                if (logado.getTipo().equals("Gerente")) {
                    this.totalVendidoPorProduto();
                } else {
                    this.acessoNegado();
                }
                break;
            case 10:
                if (logado.getTipo().equals("Gerente")) {
                this.cadastrarFuncionario();
            } else {
                this.acessoNegado();
            }
                break;
            case 11:
                if (logado.getTipo().equals("Gerente")) {
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                } else {
                    this.acessoNegado();
                }
                break;
            default:
                System.out.println(" ⚠\uFE0F Opção inválida!");
        }

    }

    private void realizarVenda() {
        List<ItemCarrinho> carrinho = new ArrayList<>();

        while(true) {
           listarProdutos();
            System.out.print("ID do produto (0 para finalizar): ");
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
                    }

                    double finalValor = forma.calcularFinal(total);

                    for(ItemCarrinho item : carrinho) {
                        item.getProduto().baixarEstoque(item.getQuantidade());
                    }

                    System.out.printf( "Venda concluída: R$ %.2f\n", finalValor);
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
            System.out.println("\n ⚠\uFE0F Nenhum produto cadastrado.");
        } else {
            System.out.println("\n ID | NOME | PREÇO | ESTOQUE");

            for(Produto p : produtos.listaProdutos()) {
                System.out.printf("%d | %s | R$ %.2f | %d\n", p.getId(), p.getNome(), p.getPreco(), p.getEstoque());
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

        Produto p = new Produto(nome, preco, estoque);

        produtos.salvarProduto(p);
        System.out.println(" ⚠\uFE0F Produto cadastrado!");
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

    private void acessoNegado() {
        System.out.println(" ⚠\uFE0F Acesso permitido apenas para gerente!");
    }

    private int lerInteiro() {
        while(true) {
            try {
                return Integer.parseInt(this.sc.nextLine());
            } catch (Exception var2) {
                System.out.print(" ⚠\uFE0F Número inválido: ");
            }
        }
    }

    private double lerDouble() {
        while(true) {
            try {
                return Double.parseDouble(this.sc.nextLine().replace(",", "."));
            } catch (Exception var2) {
                System.out.print(" ⚠\uFE0F Valor inválido: ");
            }
        }
    }

    private void inicializarDados() {

    }
    private void registrarProducao() {

        System.out.print("ID do produto: ");
        int id = lerInteiro();

        System.out.print("Quantidade produzida: ");
        double qtd = lerDouble();

        Producao producao = new Producao(id, qtd);

        producaoRepo.salvar(producao);
    }
    private void totalVendidoPorProduto() {

        System.out.print("ID do produto: ");
        int id = lerInteiro();

        Long total = sistemavendas.totalVendidoPorProduto(id);

        System.out.println("Total vendido: " + total);
    }
    private void topProdutosVendidos() {

        List<Object[]> resultado = sistemavendas.topProdutosVendidos();

        System.out.println("\n--- TOP PRODUTOS VENDIDOS ---");

        for (Object[] row : resultado) {
            System.out.println(row[0] + " - " + row[1]);
        }
    }

}
