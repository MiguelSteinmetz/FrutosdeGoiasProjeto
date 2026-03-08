package service;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void removerProduto(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }
}