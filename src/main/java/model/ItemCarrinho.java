//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package model;

public class ItemCarrinho {
    private Produto produto;
    private double quantidade;

    public ItemCarrinho(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return this.produto.calcularPreco(this.quantidade);
    }

    public Produto getProduto() {
        return this.produto;
    }

    public double getQuantidade() {
        return this.quantidade;
    }
}
