package model;

public class ProdutoFisico extends Produto {
    public ProdutoFisico(int id, String nome, double preco, double estoque) {
        super(id, nome, preco, estoque);
    }

    @Override
    public double calcularPreco(double qtd) {
        return getPreco() * qtd;
    }

    @Override
    public String getTipo() {
        return "FISICO";
    }
}