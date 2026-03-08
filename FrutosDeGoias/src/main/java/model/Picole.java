package model;

public class Picole extends Produto {
    private double precoUnitario;

    public Picole(int id, String nome, double precoUnitario) {
        super(id, nome);
        this.precoUnitario = precoUnitario;
    }

    @Override
    public double calcularPreco(double quantidade) {
        return precoUnitario * quantidade;
    }
}