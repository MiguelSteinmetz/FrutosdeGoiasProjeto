package model;

public class SorveteMassa extends Produto {
    private double precoPorKg;

    public SorveteMassa(int id, String nome, double precoPorKg) {
        super(id, nome);
        this.precoPorKg = precoPorKg;
    }

    @Override
    public double calcularPreco(double gramas) {
        return (precoPorKg / 1000) * gramas;
    }
}