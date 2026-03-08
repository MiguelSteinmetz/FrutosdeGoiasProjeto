package model;

public class Gerente extends Usuario {

    public Gerente(String login, String senha) {
        super(login, senha);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("=== MENU GERENTE ===");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Editar Produto");
        System.out.println("4 - Remover Produto");
        System.out.println("5 - Relatório de Vendas");
        System.out.println("0 - Sair");
    }
}