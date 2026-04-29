package pagamento;

public abstract class Pagamento {

    protected final String nome;

    public Pagamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularValorFinal(double valorBruto);
}