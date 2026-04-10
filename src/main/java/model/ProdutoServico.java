package model;

public class ProdutoServico extends Produto {

    // O construtor deve receber os dados do banco
    public ProdutoServico(int id, String nome, double preco, double estoque) {
        super(id, nome, preco, estoque);
    }

    @Override
    public double calcularPreco(double qtd) {
        return getPreco() * qtd; // Lógica específica de serviço
    }

    @Override
    public String getTipo() {
        return "SERVICO";
    }
}