package pagamento;

public class PagamentoDinheiro extends Pagamento {

    public PagamentoDinheiro() {
        super("Dinheiro");
    }

    @Override
    public double calcularValorFinal(double valorBruto) {
        return valorBruto;
    }
}