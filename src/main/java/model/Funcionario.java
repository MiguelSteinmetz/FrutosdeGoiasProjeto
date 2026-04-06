package model;

import jakarta.persistence.*;

@Entity(name = "funcionario")
public class Funcionario extends Usuario {
    @Column(name = "totalvendas")
    private double totalVendas;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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