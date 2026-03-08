package main;

import model.*;
import pagamento.*;
import service.*;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static UsuarioService userService = new UsuarioService();
    private static ProdutoService prodService = new ProdutoService();
    private static VendaService vendaService = new VendaService();
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

        prodService.adicionar(new Picole(101, "Picolé de Morango", 5.00));
        prodService.adicionar(new SorveteMassa(201, "Chocolate (KG)", 60.00));

        userService.cadastrar(new Gerente("Admin", "admin", "123"));
    }

    private static void exibirLogin() {
        System.out.println("\n--- LOGIN SISTEMA SORVETERIA ---");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        logado = userService.autenticar(login, senha);

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
            System.out.println("4. Cadastrar Novo Produto");
            System.out.println("5. Editar Produto");
            System.out.println("6. Deletar Produto");
            System.out.println("7. Cadastrar Funcionário");
        }

        System.out.println("0. Sair (Logout)");
        System.out.print("Escolha uma opção: ");

        int op =  lerInteiro();

        switch (op) {
            case 1 -> realizarVenda();
            case 2 -> listarProdutos();
            case 3 -> { if (logado instanceof Gerente) exibirRelatorio(); }
            case 4 -> { if (logado instanceof Gerente) cadastrarNovoProduto(); }
            case 5 -> { if (logado instanceof Gerente) editarProduto(); }
            case 6 -> { if (logado instanceof Gerente) deletarProduto(); }
            case 7 -> { if (logado instanceof Gerente) cadastrarNovoFuncionario(); }
            case 0 -> logado = null;
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void realizarVenda() {
        System.out.println("\n--- NOVA VENDA ---");
        listarProdutos();

        System.out.print("Digite o CODIGO (ID) do produto: ");
        int idDigitado = lerInteiro();

        Produto p = prodService.buscarPorId(idDigitado);

        if (p == null) {
            System.out.println("[X] Erro: Produto não encontrado!");
            return;
        }

        System.out.print("Informe Quantidade ou Gramas: ");
        double input = lerDouble();
        double subtotal = p.calcularPreco(input);

        System.out.printf("Subtotal: R$ %.2f\n", subtotal);

        System.out.println("Forma de Pagamento: 1. Dinheiro | 2. Cartão (+5%)");
        int opPag =  lerInteiro();

        Pagamento formaPg;
        if (opPag == 2) {
            formaPg = new PagamentoCartao();
        } else {
            formaPg = new PagamentoDinheiro();
        }

        double valorFinal = formaPg.calcularFinal(subtotal);

        vendaService.salvarVenda(valorFinal, logado);

        System.out.println("\n[V] VENDA FINALIZADA COM SUCESSO!");
        System.out.printf("Total Pago (%s): R$ %.2f\n", formaPg.getNome(), valorFinal);
    }

    private static void listarProdutos() {
        System.out.println("\n--- CARDÁPIO ---");
        for (Produto p : prodService.listarTodos()) {
            System.out.println("ID: [" + p.getId() + "] - " + p.getNome());
        }
    }

    private static void cadastrarNovoProduto() {
        System.out.print("Defina um ID para este produto: ");
        int id = lerInteiro();

        if (prodService.idJaExiste(id)) {
            System.out.println("[X] Erro: Já existe um produto com o ID " + id + "!");
            return;
        }
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.println("1. Picolé | 2. Sorvete de Massa");
        int tipo = lerInteiro();

        if (tipo == 1) {
            System.out.print("Preço unitário: ");
            double preco = lerDouble();
            prodService.adicionar(new Picole(id, nome, preco));
        } else {
            System.out.print("Preço por KG: ");
            double preco = lerDouble();
            prodService.adicionar(new SorveteMassa(id, nome, preco));
        }
        System.out.println("Produto " + id + " cadastrado com sucesso!");
    }

    private static void exibirRelatorio() {
        System.out.println("\n=== RELATÓRIO DE VENDAS (GERENCIAL) ===");
        System.out.printf("FATURAMENTO TOTAL DA LOJA: R$ %.2f\n", vendaService.getTotalLoja());
        System.out.println("---------------------------------------");
        System.out.println("PERFORMANCE POR FUNCIONÁRIO:");

        for (Usuario u : userService.listarTodos()) {


            if (u instanceof Funcionario) {


                Funcionario f = (Funcionario) u;

                System.out.printf("- %s: R$ %.2f\n", f.getNome(), f.getTotalVendas());
            }
        }
        System.out.println("=======================================");
    }

    private static void deletarProduto() {
        listarProdutos();
        System.out.print("Digite o CODIGO (ID) do produto para excluir: ");
        int id = lerInteiro();
        prodService.deletarPorId(id);
    }

    private static void editarProduto() {
        listarProdutos();
        System.out.print("Digite o CODIGO (ID) do produto que deseja editar: ");
        int idBusca = lerInteiro();


        Produto produtoAntigo = prodService.buscarPorId(idBusca);

        if (produtoAntigo == null) {
            System.out.println("[X] Erro: Produto com ID " + idBusca + " não encontrado!");
            return;
        }

        System.out.println("Editando: " + produtoAntigo.getNome());

        System.out.print("Novo ID (ou digite " + produtoAntigo.getId() + " para manter): ");
        int novoId = lerInteiro();

        if (novoId != idBusca && prodService.idJaExiste(novoId)) {
            System.out.println("[X] Erro: O novo ID " + novoId + " já pertence a outro produto!");
            return;
        }

        System.out.print("Novo Nome: ");
        String novoNome = sc.nextLine();

        Produto novoProduto;

        if (produtoAntigo instanceof Picole) {
            System.out.print("Novo Preço Unitário: ");
            double novoPreco = lerDouble();
            novoProduto = new Picole(novoId, novoNome, novoPreco);
        } else {
            System.out.print("Novo Preço por KG: ");
            double novoPreco = lerDouble();
            novoProduto = new SorveteMassa(novoId, novoNome, novoPreco);
        }

        prodService.editarPorId(idBusca, novoProduto);

        System.out.println("[V] Produto atualizado com sucesso!");
    }

    private static void cadastrarNovoFuncionario() {
        System.out.println("\n--- NOVO FUNCIONÁRIO ---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        // Criamos o objeto do tipo Funcionario
        Funcionario novoF = new Funcionario(nome, login, senha);

        // Chamamos o SEU userService para salvar na lista de usuários
        userService.cadastrar(novoF);

        System.out.println("[V] " + nome + " agora é um funcionário do sistema!");
    }

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("[!] Erro: Digite um número inteiro válido: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                // Substitui vírgula por ponto para evitar erros de padrão regional
                String entrada = sc.nextLine().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("[!] Erro: Digite um valor numérico (ex: 10.50): ");
            }
        }
    }
}