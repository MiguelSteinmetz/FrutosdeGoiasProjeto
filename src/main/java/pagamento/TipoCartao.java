package pagamento;

public enum TipoCartao {

    DEBITO {
        @Override
        public double aplicar(double valor) {
            return valor;
        }
    },

    CREDITO {
        @Override
        public double aplicar(double valor) {
            return valor * 1.05;
        }
    };

    public abstract double aplicar(double valor);
}