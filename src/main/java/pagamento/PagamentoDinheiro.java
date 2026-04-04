//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pagamento;

public class PagamentoDinheiro extends Pagamento {
    public PagamentoDinheiro() {
        super("Dinheiro (À vista)");
    }

    public double calcularFinal(double valorBruto) {
        return valorBruto;
    }
}
