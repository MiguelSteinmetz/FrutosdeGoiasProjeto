package model;

import jakarta.persistence.*;

@Entity(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private double preco;
    @Column(name = "estoque")
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }


    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getEstoque() { return estoque; }


    public void adicionarEstoque(double qtd) {
        this.estoque += qtd; }

    public void baixarEstoque(double qtd) {
        this.estoque -= qtd; }

    public double calcularPreco(double qtd){
        return this.preco * qtd;
    }

    public Produto(){}
}