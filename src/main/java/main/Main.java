package main;

import model.*;
import service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoginService loginService = new LoginService();
        ProdutoService produtoService = new ProdutoService();
        VendaService vendaService = new VendaService();

        while (true) {

            Usuario usuarioLogado = null;

            // ===== LOGIN =====
            while (usuarioLogado == null) {
                System.out.println("=== LOGIN SORVETERIA ===");
                System.out.print("Login: ");
                String login = sc.nextLine();

                System.out.print("Senha: ");
                String senha = sc.nextLine();

                usuarioLogado = loginService.autenticar(login, senha);

                if (usuarioLogado == null) {
                    System.out.println("Login inválido!\n");
                }
            }

            System.out.println("Login realizado com sucesso!\n");

            int opcao;

            do {
                usuarioLogado.mostrarMenu();
                System.out.println("9 - Logout"); // opção para sair e trocar usuário
                opcao = lerInt(sc);

                // ===== GERENTE =====
                if (usuarioLogado instanceof Gerente) {

                    switch (opcao) {
                        case 1: // Cadastrar produto
                            System.out.print("ID: ");
                            int id = lerInt(sc);

                            System.out.print("Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("Preço: ");
                            double preco = lerDouble(sc);

                            System.out.print("Estoque: ");
                            int estoque = lerInt(sc);

                            produtoService.cadastrarProduto(
                                    new Produto(id, nome, preco, estoque)
                            );
                            System.out.println("Produto cadastrado!\n");
                            break;

                        case 2: // Listar produtos
                            listarProdutos(produtoService);
                            break;

                        case 3: // Editar produto
                            System.out.print("ID do produto: ");
                            int idEditar = lerInt(sc);

                            Produto produtoEditar = produtoService.buscarPorId(idEditar);

                            if (produtoEditar != null) {
                                System.out.print("Novo preço: ");
                                produtoEditar.setPreco(lerDouble(sc));

                                System.out.print("Novo estoque: ");
                                produtoEditar.setEstoque(lerInt(sc));

                                System.out.println("Produto atualizado!\n");
                            } else {
                                System.out.println("Produto não encontrado!\n");
                            }
                            break;

                        case 4: // Remover produto
                            System.out.print("ID do produto: ");
                            int idRemover = lerInt(sc);
                            produtoService.removerProduto(idRemover);
                            System.out.println("Produto removido!\n");
                            break;

                        case 5: // Relatório de vendas
                            System.out.println("Total vendido: R$ "
                                    + vendaService.calcularTotalVendas());
                            break;

                        case 9: // Logout
                            System.out.println("Logout realizado.\n");
                            break;

                        case 0: // Sair do programa
                            System.out.println("Sistema encerrado.");
                            sc.close();
                            return;

                        default:
                            System.out.println("Opção inválida!\n");
                    }
                }

                // ===== FUNCIONÁRIO =====
                else if (usuarioLogado instanceof Funcionario) {

                    switch (opcao) {
                        case 1:
                            listarProdutos(produtoService);

                            System.out.print("ID do produto: ");
                            int idVenda = lerInt(sc);

                            Produto produtoVenda = produtoService.buscarPorId(idVenda);

                            if (produtoVenda != null) {

                                System.out.print("Quantidade: ");
                                int quantidade = lerInt(sc);

                                if (quantidade <= produtoVenda.getEstoque()) {

                                    produtoVenda.setEstoque(
                                            produtoVenda.getEstoque() - quantidade
                                    );

                                    Venda venda = new Venda(produtoVenda, quantidade);
                                    vendaService.registrarVenda(venda);

                                    System.out.println("Venda realizada! Total: R$ "
                                            + venda.calcularTotal());

                                } else {
                                    System.out.println("Estoque insuficiente!");
                                }
                            } else {
                                System.out.println("Produto não encontrado!");
                            }
                            break;

                        case 2:
                            listarProdutos(produtoService);
                            break;

                        case 9:
                            System.out.println("Logout realizado.\n");
                            break;

                        case 0:
                            System.out.println("Sistema encerrado.");
                            sc.close();
                            return;

                        default:
                            System.out.println("Opção inválida!\n");
                    }
                }

            } while (opcao != 9);


            System.out.println("Voltando para a tela de login...\n");
        }
    }

    // ===== MÉTODOS AUXILIARES =====

    public static int lerInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }

    public static double lerDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Digite um valor válido: ");
            }
        }
    }

    public static void listarProdutos(ProdutoService service) {
        for (Produto p : service.listarProdutos()) {
            System.out.println("ID: " + p.getId()
                    + " | Nome: " + p.getNome()
                    + " | Preço: R$ " + p.getPreco()
                    + " | Estoque: " + p.getEstoque());
        }
        System.out.println();
    }
}