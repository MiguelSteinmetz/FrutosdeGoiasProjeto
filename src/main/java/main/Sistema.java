package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;
import pagamento.*;
import repository.ProdutosRepository;
import service.*;

public class Sistema {
    ProdutosRepository produtosRepository = new ProdutosRepository();
    private Scanner sc = new Scanner(System.in);
    private UsuarioService usuario = new UsuarioService();
    private ProdutoService produtos = new ProdutoService();
    private VendaService sistemavendas = new VendaService();
    private Usuario logado = null;

    public void iniciar() {
        inicializarDados();

        while (true) {
            if (logado == null) {
                exibirLogin();
            } else {
                exibirMenuPrincipal();
            }
        }
    }

    // ================= LOGIN =================
    private void exibirLogin() {
        System.out.println("\n--- LOGIN SISTEMA SORVETERIA ---");

        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        logado = usuario.autenticar(login, senha);

        if (logado == null) {
            System.out.println("[X] Usuário ou senha incorretos!");
        } else {
            System.out.println("[V] Bem-vindo, " + logado.getNome());
        }
    }

    // ================= MENU =================
    private void exibirMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL (" + logado.getTipo() + ") ===");

        System.out.println("1. Realizar Venda");
        System.out.println("2. Ver Cardápio");

        if (logado instanceof Gerente) {
            System.out.println("3. Relatório de Vendas");
            System.out.println("4. Deletar Produto");
            System.out.println("5. Editar Produto");
            System.out.println("6. Cadastrar Produto");
            System.out.println("7. Cadastrar Funcionário");
            System.out.println("8. Encerrar Sistema");
        }

        System.out.println("0. Logout");
        System.out.print("Escolha: ");

        int op = lerInteiro();

        switch (op) {
            case 1 -> realizarVenda();
            case 2 -> listarProdutos();

            case 3 -> {
                if (logado instanceof Gerente) exibirRelatorio();
                else acessoNegado();
            }

            case 4 -> {
                if (logado instanceof Gerente) deletarProduto();
                else acessoNegado();
            }

            case 5 -> {
                if (logado instanceof Gerente) editarProduto();
                else acessoNegado();
            }

            case 6 -> {
                if (logado instanceof Gerente) cadastrarProduto();
                else acessoNegado();
            }

            case 7 -> {
                if (logado instanceof Gerente) cadastrarFuncionario();
                else acessoNegado();
            }

            case 8 -> {
                if (logado instanceof Gerente) {
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                } else acessoNegado();
            }

            case 0 -> logado = null;

            default -> System.out.println("Opção inválida!");
        }
    }

    // ================= VENDA =================
    private void realizarVenda() {
        List<ItemCarrinho> carrinho = new ArrayList<>();

        while (true) {
            listarProdutos();
            System.out.print("ID do produto (0 para finalizar): ");
            int id = lerInteiro();

            if (id == 0) break;

            Produto p = produtos.buscarPorId(id);

            if (p != null) {
                System.out.print("Quantidade: ");
                double qtd = lerDouble();

                if (qtd <= p.getEstoque()) {
                    carrinho.add(new ItemCarrinho(p, qtd));
                    System.out.println("Adicionado!");
                } else {
                    System.out.println("Estoque insuficiente!");
                }
            }
        }

        if (carrinho.isEmpty()) return;

        double total = 0;
        for (ItemCarrinho item : carrinho) {
            total += item.getSubtotal();
        }

        System.out.printf("TOTAL: R$ %.2f\n", total);
        System.out.println("1 - Cartão | 2 - Dinheiro");
        int opc = lerInteiro();

        Pagamento forma = (opc == 1) ? new PagamentoCartao() : new PagamentoDinheiro();
        double finalValor = forma.calcularFinal(total);

        for (ItemCarrinho item : carrinho) {
            item.getProduto().baixarEstoque(item.getQuantidade());
        }

        sistemavendas.salvarVenda(finalValor, logado);

        System.out.printf("Venda concluída: R$ %.2f\n", finalValor);
    }

    // ================= PRODUTOS =================
    private void listarProdutos() {
        System.out.println("\nID | NOME | PREÇO | ESTOQUE");

        for (Produto p : produtosRepository.buscartodos()) {
            System.out.printf("%d | %s | R$ %.2f | %d\n",
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getEstoque());
        }
    }

    private void cadastrarProduto() {

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Preço: ");
        double preco = lerDouble();

        System.out.print("Estoque: ");
        int estoque = lerInteiro();
        Produto p = (new Produto(nome, preco, estoque));
       produtosRepository.salvar(p);

        System.out.println("Produto cadastrado!");
    }

    private void editarProduto() {
        System.out.print("ID: ");
        int id = lerInteiro();

        Produto p = produtos.buscarPorId(id);

        if (p != null) {
            System.out.print("Novo nome: ");
            p.setNome(sc.nextLine());

            System.out.print("Novo preço: ");
            p.setPreco(lerDouble());

            System.out.println("Atualizado!");
        }
    }

    private void deletarProduto() {
        listarProdutos();
        System.out.print("ID: ");
        int id = lerInteiro();

        produtosRepository.deletar(id);
        System.out.println("Deletado!");
    }

    // ================= FUNCIONÁRIO =================
    private void cadastrarFuncionario() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        usuario.cadastrar(new Funcionario(nome, login, senha));
        System.out.println("Funcionário cadastrado!");
    }

    // ================= RELATÓRIO =================
    private void exibirRelatorio() {
        System.out.println("Total da loja: R$ " + sistemavendas.getTotalLoja());
    }

    // ================= UTIL =================
    private void acessoNegado() {
        System.out.println("Acesso permitido apenas para gerente!");
    }

    private int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Número inválido: ");
            }
        }
    }

    private double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().replace(",", "."));
            } catch (Exception e) {
                System.out.print("Valor inválido: ");
            }
        }
    }

    private void inicializarDados() {
        usuario.cadastrar(new Gerente("Admin", "admin", "123"));
    }
}