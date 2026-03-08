package model;

public class ItemVenda {
    private Produto produto;
    private double quantidadeOuPeso;
    private double precoCalculado;

    public ItemVenda(Produto produto, double quantidadeOuPeso, double precoCalculado) {
        this.produto = produto;
        this.quantidadeOuPeso = quantidadeOuPeso;
        this.precoCalculado = precoCalculado;
    }

    public double getPrecoCalculado() { return precoCalculado; }
}