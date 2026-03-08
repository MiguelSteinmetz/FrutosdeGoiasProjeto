package model;

public class Funcionario extends Usuario {

    public Funcionario(String login, String senha) {
        super(login, senha);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("=== MENU FUNCIONÁRIO ===");
        System.out.println("1 - Realizar Venda");
        System.out.println("2 - Listar Produtos");
        System.out.println("0 - Sair");
    }
}