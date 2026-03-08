package model;

public abstract class Produto {
    protected int id; // Agora você que manda o valor para cá
    protected String nome;

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }

    public abstract double calcularPreco(double valor);
}