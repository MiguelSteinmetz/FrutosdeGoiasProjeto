package pagamento;

public class PagamentoCartao extends Pagamento {

    private TipoCartao tipo;

    public PagamentoCartao(TipoCartao tipo) {
        super("Cartão " + tipo);
        this.tipo = tipo;
    }

    @Override
    public double calcularFinal(double valorBruto) {
        if (tipo == TipoCartao.CREDITO) {
            return valorBruto * 1.05; // +5%
        } else {
            return valorBruto;
        }
    }
}