package main;

import model.*;
import pagamento.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static UsuarioService usuario = new UsuarioService();
    private static ProdutoService produtos = new ProdutoService();
    private static VendaService sistemavendas = new VendaService();
    private static Usuario logado = null;

    public static void main(String[] args) {
        inicializarDados();

        while (true) {
            if (logado == null) {
                exibirLogin();
            } else {
                exibirMenuPrincipal();
            }
        }
    }

    private static void inicializarDados() {

        produtos.adicionar(new Picole(101, "Picolé de Morango", 5.00, 50));
        produtos.adicionar(new SorveteMassa(201, "Chocolate (KG)", 60.00, 10000));

        usuario.cadastrar(new Gerente("Admin", "admin", "123"));
    }

    private static void exibirLogin() {
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

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL (" + logado.getTipo() + ") ===");
        System.out.println("1. Realizar Venda");
        System.out.println("2. Ver Cardápio");

        // Opções exclusivas do Gerente
        if (logado instanceof Gerente) {
            System.out.println("3. Relatório de Vendas");
            System.out.println("4. Deletar Produto");
            System.out.println("5. Editar Produto");
            System.out.println("6. Cadastrar Novo Produto");
            System.out.println("7. Cadastrar Funcionário");
        }

        System.out.println("0. Sair (Logout)");
        System.out.print("Escolha uma opção: ");

        int op =  lerInteiro();

        switch (op) {
            case 1 -> realizarVenda();
            case 2 -> listarProdutos();
            case 3 -> { if (logado instanceof Gerente) exibirRelatorio(); }
            case 4 -> { if (logado instanceof Gerente) deletarProduto(); }
            case 5 -> { if (logado instanceof Gerente) editarProduto(); }
            case 6 -> { if (logado instanceof Gerente) cadastrarNovoProduto(); }
            case 7 -> { if (logado instanceof Gerente) cadastrarNovoFuncionario(); }
            case 0 -> logado = null;
            default -> System.out.println("Opção inválida!");
        }
    }
    private static void realizarVenda() {
        List<ItemCarrinho> carrinho = new ArrayList<>();
        boolean adicionando = true;

        while (adicionando) {
            listarProdutos();
            System.out.print("ID do produto (ou 0 para finalizar): ");
            int id = lerInteiro();

            if (id == 0) break;

            Produto p = produtos.buscarPorId(id);
            if (p != null) {
                System.out.println(p.getNome() + " Selecionado");
                System.out.print("Quantidade/Peso: ");
                double qtd = lerDouble();

                if (qtd <= p.getEstoque()) {
                    carrinho.add(new ItemCarrinho(p, qtd));
                    System.out.println(" Adicionado!");
                } else {
                    System.out.println(" Estoque insuficiente!");
                }
            }

            System.out.println("\nDeseja adicionar mais itens?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não (Finalizar)");
            System.out.print("Escolha: ");

            int continuar = lerInteiro();

            if (continuar == 2) {
                adicionando = false;
            }
        }

        if (carrinho.isEmpty()) return;


        double totalVenda = 0;
        for (ItemCarrinho item : carrinho) {
            totalVenda += item.getSubtotal();
        }

        System.out.printf("\nTOTAL DO CARRINHO: R$ %.2f\n", totalVenda);
        System.out.println("1 - Cartão | 2 - Dinheiro");
        int opc = lerInteiro();

        Pagamento forma = (opc == 1) ? new PagamentoCartao() : new PagamentoDinheiro();
        double valorFinal = forma.calcularFinal(totalVenda);

        for (ItemCarrinho item : carrinho) {
            item.getProduto().baixarEstoque(item.getQuantidade());
        }
        sistemavendas.salvarVenda(valorFinal, logado);

        System.out.printf("✅ Venda de %d itens finalizada! Total: R$ %.2f\n", carrinho.size(), valorFinal);
    }

    private static void listarProdutos() {
        List<Produto> produto = produtos.listarTodos();

        if (produto.isEmpty()) {
            System.out.println("\n[!] Nenhum produto cadastrado no sistema.");
            return;
        }

        System.out.println("\n========================================================================");
        System.out.printf("%-5s | %-10s | %-20s | %-12s | %-10s\n", "ID", "TIPO", "NOME", "PREÇO", "ESTOQUE");
        System.out.println("------------------------------------------------------------------------");

        for (Produto p : produto) {
            String tipo = (p instanceof Picole) ? "PICOLÉ" : "MASSA";

            System.out.printf("%-5d | %-10s | %-20s | R$ %-9.2f | %-10.2f\n",
                    p.getId(),
                    tipo,
                    p.getNome(),
                    p.getPreco(),
                    p.getEstoque()
            );
        }
        System.out.println("========================================================================\n");
    }

    private static void cadastrarNovoProduto() {
        System.out.println("\n--- CADASTRAR NOVO PRODUTO ---");
        System.out.print("Defina um ID para este produto: ");
        int id = lerInteiro();

        if (produtos.idJaExiste(id)) {
            System.out.println("[X] Erro: Já existe um produto com o ID " + id + "!");
            return;
        }

        System.out.print("Nome do Produto: ");
        String nome = sc.nextLine();


        System.out.print("Estoque Inicial (Unid para Picole / Gramas para Massa): ");
        double estoqueInicial = lerDouble();

        if (estoqueInicial < 0) {
            System.out.println(" Erro: O estoque não pode ser negativo!");
            return;
        }

        System.out.println("Tipo: 1. Picole | 2. Sorvete de Massa");
        int tipo = lerInteiro();

        if (tipo == 1) {
            System.out.print("Preço unitário: ");
            double preco = lerDouble();

            produtos.adicionar(new Picole(id, nome, preco, estoqueInicial));
        } else if (tipo == 2) {
            System.out.print("Preço por KG: ");
            double preco = lerDouble();

            produtos.adicionar(new SorveteMassa(id, nome, preco, estoqueInicial));
        } else {
            System.out.println("[X] Erro: Tipo inválido! Produto não cadastrado.");
            return;
        }

        System.out.println("[V] Produto " + id + " (" + nome + ") cadastrado com sucesso!");
    }

    private static void exibirRelatorio() {
        System.out.println("\n=== RELATÓRIO DE VENDAS (GERENCIAL) ===");
        System.out.printf("FATURAMENTO TOTAL DA LOJA: R$ %.2f\n", sistemavendas.getTotalLoja());
        System.out.println("---------------------------------------");
        System.out.println("PERFORMANCE POR FUNCIONÁRIO:");

        for (Usuario u : usuario.listarTodos()) {
            if (u instanceof Funcionario) {
                Funcionario func = (Funcionario) u;
                System.out.printf("- %s: R$ %.2f\n", func.getNome(), func.getTotalVendas());
            }
        }
        System.out.println("=======================================");
    }

    private static void deletarProduto() {
        listarProdutos();
        System.out.print("Digite o CODIGO (ID) do produto para excluir: ");
        int id = lerInteiro();
        produtos.deletarPorId(id);

        System.out.println("\n Produto Deletado");
    }

    private static void editarProduto() {
        listarProdutos();
        System.out.print("\nDigite o ID do produto: ");
        int id = lerInteiro();
        Produto p = produtos.buscarPorId(id);

        if (p != null) {
            System.out.print("\nNovo nome (Atual: " + p.getNome() + "): ");
            p.setNome(sc.nextLine());

            System.out.print("\nNovo preço (Atual: " + p.getPreco() + "): ");
            p.setPreco(lerDouble());

            System.out.print("Quanto deseja ADICIONAR ao estoque atual? ");
            double qtdNova = lerDouble();
            p.adicionarEstoque(qtdNova);

            System.out.println("Produto editado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
    private static void cadastrarNovoFuncionario() {
        System.out.println("\n--- NOVO FUNCIONARIO ---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        if (usuario.loginJaExiste(login)) {
            System.out.println(" Erro: Este login já esta sendo usado por outro usuario!");
            return;
        }

        Funcionario novoFunc = new Funcionario(nome, login, senha);
        usuario.cadastrar(novoFunc);

        System.out.println("Funcionario Cadastrado: " + nome);

    }

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Erro: Digite um número inteiro valido: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                String entrada = sc.nextLine().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Erro: Digite um valor valido: ");
            }
        }
    }
}