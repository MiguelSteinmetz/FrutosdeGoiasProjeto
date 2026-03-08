package model;

public class Funcionario extends Usuario {
    private double totalVendas; // Para o relatório de performance

    public Funcionario(String nome, String login, String senha) {
        super(nome, login, senha, "Funcionário");
        this.totalVendas = 0.0;
    }

    public void adicionarVenda(double valor) {
        this.totalVendas += valor;
    }

    public double getTotalVendas() {
        return totalVendas;
    }
}