//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pagamento;

public class PagamentoCartao extends Pagamento {
    public PagamentoCartao() {
        super("Cartão (+5%)");
    }

    public double calcularFinal(double valorBruto) {
        return valorBruto * 1.05;
    }
}
