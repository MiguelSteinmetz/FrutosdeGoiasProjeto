
package pagamento;

public abstract class Pagamento {

    protected String nome;

    public Pagamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public abstract double calcularFinal(double var1);
}
