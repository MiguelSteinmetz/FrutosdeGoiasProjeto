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
    private static Usuario logado = null; // Começa como null para forçar o login

    public static void main(String[] args) {
        inicializarDados(); // Cria os usuários e produtos iniciais

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
        }

        System.out.println("0. Sair (Logout)");
        System.out.print("Escolha uma opção: ");

        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1 -> realizarVenda();
            case 2 -> listarProdutos();
            case 3 -> { if (logado instanceof Gerente) exibirRelatorio(); }
            case 4 -> { if (logado instanceof Gerente) cadastrarNovoProduto(); }
            case 5 -> { if (logado instanceof Gerente) editarProduto(); }
            case 6 -> { if (logado instanceof Gerente) deletarProduto(); }
            case 0 -> logado = null; // Faz o logout e volta para a tela de login
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void realizarVenda() {
        System.out.println("\n--- NOVA VENDA ---");
        listarProdutos();

        System.out.print("Digite o CODIGO (ID) do produto: ");
        int idDigitado = Integer.parseInt(sc.nextLine());

        // Usamos o novo método buscarPorId que criamos no Service
        Produto p = prodService.buscarPorId(idDigitado);

        if (p == null) {
            System.out.println("[X] Erro: Produto com ID " + idDigitado + " não encontrado!");
            return;
        }

        System.out.print("Informe Quantidade ou Gramas: ");
        double input = Double.parseDouble(sc.nextLine());
        double subtotal = p.calcularPreco(input);

    }

    private static void listarProdutos() {
        System.out.println("\n--- CARDÁPIO ---");
        for (Produto p : prodService.listarTodos()) {
            System.out.println("ID: [" + p.getId() + "] - " + p.getNome());
        }
    }

    private static void cadastrarNovoProduto() {
        System.out.print("Defina um ID para este produto: ");
        int id = Integer.parseInt(sc.nextLine());

        if (prodService.idJaExiste(id)) {
            System.out.println("[X] Erro: Já existe um produto com o ID " + id + "!");
            return; // Sai do método e volta para o menu
        }
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.println("1. Picolé | 2. Sorvete de Massa");
        int tipo = Integer.parseInt(sc.nextLine());

        if (tipo == 1) {
            System.out.print("Preço unitário: ");
            double preco = Double.parseDouble(sc.nextLine());
            prodService.adicionar(new Picole(id, nome, preco));
        } else {
            System.out.print("Preço por KG: ");
            double preco = Double.parseDouble(sc.nextLine());
            prodService.adicionar(new SorveteMassa(id, nome, preco));
        }
        System.out.println("Produto " + id + " cadastrado com sucesso!");
    }

    private static void exibirRelatorio() {
        System.out.println("\n=== RELATÓRIO DE VENDAS ===");
        System.out.printf("Total Geral: R$ %.2f\n", vendaService.getTotalLoja());
    }

    private static void deletarProduto() {
        listarProdutos();
        System.out.print("Digite o CODIGO (ID) do produto para excluir: ");
        int id = Integer.parseInt(sc.nextLine()); // O usuário digita "101"
        prodService.deletarPorId(id); // O Service se vira para achar o 101
    }

    private static void editarProduto() {
        listarProdutos();
        System.out.print("Digite o CODIGO (ID) do produto que deseja editar: ");
        int idBusca = Integer.parseInt(sc.nextLine());

        // 1. Busca o produto atual para saber o que estamos editando
        Produto produtoAntigo = prodService.buscarPorId(idBusca);

        if (produtoAntigo == null) {
            System.out.println("[X] Erro: Produto com ID " + idBusca + " não encontrado!");
            return;
        }

        System.out.println("Editando: " + produtoAntigo.getNome());

        // 2. Pergunta os novos dados
        System.out.print("Novo ID (ou digite " + produtoAntigo.getId() + " para manter): ");
        int novoId = Integer.parseInt(sc.nextLine());

        // Validação: Se o ID mudou, verifica se o novo ID já não existe em outro produto
        if (novoId != idBusca && prodService.idJaExiste(novoId)) {
            System.out.println("[X] Erro: O novo ID " + novoId + " já pertence a outro produto!");
            return;
        }

        System.out.print("Novo Nome: ");
        String novoNome = sc.nextLine();

        Produto novoProduto;

        // 3. Verifica o tipo (Picolé ou Massa) para criar o objeto correto
        if (produtoAntigo instanceof Picole) {
            System.out.print("Novo Preço Unitário: ");
            double novoPreco = Double.parseDouble(sc.nextLine());
            novoProduto = new Picole(novoId, novoNome, novoPreco);
        } else {
            System.out.print("Novo Preço por KG: ");
            double novoPreco = Double.parseDouble(sc.nextLine());
            novoProduto = new SorveteMassa(novoId, novoNome, novoPreco);
        }

        // 4. ENVIA PARA O SERVICE EXECUTAR A TROCA
        prodService.editarPorId(idBusca, novoProduto);

        System.out.println("[V] Produto atualizado com sucesso!");
    }
}