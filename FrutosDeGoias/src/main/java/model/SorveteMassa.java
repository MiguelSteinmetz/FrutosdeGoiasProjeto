package model;

public class SorveteMassa extends Produto {
    public SorveteMassa(int id, String nome, double preco, double estoque) {
        super(id, nome, preco, estoque);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | [MASSA]  %-15s | Preço Kg: R$ %.2f | Estoque: %.3f kg",
                getId(), getNome(), getPreco(), getEstoque());
    }
    @Override
    public double calcularPreco(double qtd) {
        return (this.getPreco() / 1000) * qtd;
    }
}