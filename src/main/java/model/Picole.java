package model;

public class Picole extends Produto {
    public Picole(int id, String nome, double preco, double estoque) {
        super(id, nome, preco, estoque);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | [PICOLÉ] %-15s | Preço Un: R$ %.2f | Estoque: %.0f",
                getId(), getNome(), getPreco(), getEstoque());
    }
    @Override
    public double calcularPreco(double qtd) {
        return this.getPreco() * qtd;
    }
}