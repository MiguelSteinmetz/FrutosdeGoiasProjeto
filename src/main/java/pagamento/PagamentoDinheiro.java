package pagamento;

public class PagamentoDinheiro extends Pagamento {
    public PagamentoDinheiro() {
        super("Dinheiro (À vista)");
    }

    @Override
    public double calcularFinal(double valorBruto) {
        return valorBruto; // Sem taxas
    }
}