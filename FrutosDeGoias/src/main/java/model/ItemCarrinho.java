package model;

public class ItemCarrinho {
    private Produto produto;
    private double quantidade;

    public ItemCarrinho(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.calcularPreco(quantidade);
    }

    public Produto getProduto() { return produto; }
    public double getQuantidade() { return quantidade; }
}