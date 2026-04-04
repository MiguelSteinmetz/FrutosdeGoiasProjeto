//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Funcionario;
import model.Gerente;
import model.ItemCarrinho;
import model.Produto;
import model.Usuario;
import pagamento.Pagamento;
import pagamento.PagamentoCartao;
import pagamento.PagamentoDinheiro;
import repository.ProdutoRepository;
import service.ProdutoService;
import service.UsuarioService;
import service.VendaService;

public class Sistema {
    ProdutoRepository produtoRepository = new ProdutoRepository();
    private Scanner sc;
    private UsuarioService usuario;
    private ProdutoService produtos;
    private VendaService sistemavendas;
    private Usuario logado;

    public Sistema() {
        this.sc = new Scanner(System.in);
        this.usuario = new UsuarioService();
        this.produtos = new ProdutoService();
        this.sistemavendas = new VendaService();
        this.logado = null;
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
        System.out.println("\n--- LOGIN SISTEMA SORVETERIA ---");
        System.out.print("Login: ");
        String login = this.sc.nextLine();
        System.out.print("Senha: ");
        String senha = this.sc.nextLine();
        this.logado = this.usuario.autenticar(login, senha);
        if (this.logado == null) {
            System.out.println("[X] Usuário ou senha incorretos!");
        } else {
            System.out.println("[V] Bem-vindo, " + this.logado.getNome());
        }

    }

    private void exibirMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL (" + this.logado.getTipo() + ") ===");
        System.out.println("1. Realizar Venda");
        System.out.println("2. Ver Cardápio");
        if (this.logado instanceof Gerente) {
            System.out.println("3. Relatório de Vendas");
            System.out.println("4. Deletar Produto");
            System.out.println("5. Editar Produto");
            System.out.println("6. Cadastrar Produto");
            System.out.println("7. Cadastrar Funcionário");
            System.out.println("8. Encerrar Sistema");
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
                if (this.logado instanceof Gerente) {
                    this.exibirRelatorio();
                } else {
                    this.acessoNegado();
                }
                break;
            case 4:
                if (this.logado instanceof Gerente) {
                    this.deletarProduto();
                } else {
                    this.acessoNegado();
                }
                break;
            case 5:
                if (this.logado instanceof Gerente) {
                    this.editarProduto();
                } else {
                    this.acessoNegado();
                }
                break;
            case 6:
                if (this.logado instanceof Gerente) {
                    this.cadastrarProduto();
                } else {
                    this.acessoNegado();
                }
                break;
            case 7:
                if (this.logado instanceof Gerente) {
                    this.cadastrarFuncionario();
                } else {
                    this.acessoNegado();
                }
                break;
            case 8:
                if (this.logado instanceof Gerente) {
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                } else {
                    this.acessoNegado();
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }

    }

    private void realizarVenda() {
        List<ItemCarrinho> carrinho = new ArrayList();

        while(true) {
            this.listarProdutos();
            System.out.print("ID do produto (0 para finalizar): ");
            int id = this.lerInteiro();
            if (id == 0) {
                if (carrinho.isEmpty()) {
                    return;
                } else {
                    double total = (double)0.0F;

                    for(ItemCarrinho item : carrinho) {
                        total += item.getSubtotal();
                    }

                    System.out.printf("TOTAL: R$ %.2f\n", total);
                    System.out.println("1 - Cartão | 2 - Dinheiro");
                    int opc = this.lerInteiro();
                    Pagamento forma = (Pagamento)(opc == 1 ? new PagamentoCartao() : new PagamentoDinheiro());
                    double finalValor = forma.calcularFinal(total);

                    for(ItemCarrinho item : carrinho) {
                        item.getProduto().baixarEstoque(item.getQuantidade());
                    }

                    this.sistemavendas.salvarVenda(finalValor, this.logado);
                    System.out.printf("Venda concluída: R$ %.2f\n", finalValor);
                    return;
                }
            }

            Produto p = this.produtos.buscarPorId(id);
            if (p != null) {
                System.out.print("Quantidade: ");
                double qtd = this.lerDouble();
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
        List<Produto> lista = this.produtos.listarTodos();
        if (this.produtoRepository.buscartodos().isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
        } else {
            System.out.println("\nID | NOME | PREÇO | ESTOQUE");

            for(Produto p : this.produtoRepository.buscartodos()) {
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
        this.produtoRepository.salvar(p);
        System.out.println("Produto cadastrado!");
    }

    private void editarProduto() {
        System.out.print("ID: ");
        int id = this.lerInteiro();
        Produto p = this.produtos.buscarPorId(id);
        if (p != null) {
            System.out.print("Novo nome: ");
            p.setNome(this.sc.nextLine());
            System.out.print("Novo preço: ");
            p.setPreco(this.lerDouble());
            System.out.println("Atualizado!");
        }

    }

    private void deletarProduto() {
        System.out.print("ID: ");
        int id = this.lerInteiro();
        this.produtos.deletarPorId(id);
        System.out.println("Deletado!");
    }

    private void cadastrarFuncionario() {
        System.out.print("Nome: ");
        String nome = this.sc.nextLine();
        System.out.print("Login: ");
        String login = this.sc.nextLine();
        System.out.print("Senha: ");
        String senha = this.sc.nextLine();
        this.usuario.cadastrar(new Funcionario(nome, login, senha));
        System.out.println("Funcionário cadastrado!");
    }

    private void exibirRelatorio() {
        System.out.println("Total da loja: R$ " + this.sistemavendas.getTotalLoja());
    }

    private void acessoNegado() {
        System.out.println("Acesso permitido apenas para gerente!");
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
        this.usuario.cadastrar(new Gerente("Admin", "admin", "123"));
    }
}
