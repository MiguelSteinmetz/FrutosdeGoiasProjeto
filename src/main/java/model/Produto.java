package model;

public class Produto {
public abstract class Produto {
    private int id;
    private String nome;
    private double preco;
    private double estoque;
    private String tipo;

    public Produto(int id, String nome, double preco, double estoque, String tipo) {
    public Produto(int id, String nome, double preco, double estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.tipo = tipo;
    }


    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public double getEstoque() { return estoque; }
    public String getTipo() {return tipo; }
    public void adicionarEstoque(double qtd) {this.estoque += qtd; }


    public void adicionarEstoque(double qtd) {
        this.estoque += qtd; }

    public void baixarEstoque(double qtd) {
    this.estoque -= qtd; }

}