package pagamento;

public class PagamentoCartao extends Pagamento {

    private final TipoCartao tipo;

    public PagamentoCartao(TipoCartao tipo) {
        super("Cartão " + tipo);
        this.tipo = tipo;
    }

    @Override
    public double calcularValorFinal(double valorBruto) {
        return tipo.aplicar(valorBruto);
    }
}