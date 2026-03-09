package pagamento;

public class PagamentoCartao extends Pagamento {

    public PagamentoCartao() {
        super("Cartão (+5%)");
    }

    @Override
    public double calcularFinal(double valorBruto) {
        return valorBruto * 1.05;
    }
}