package service;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto p) {
        produtos.add(p);
    }

    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public void deletarPorId(int id) {
        Produto p = buscarPorId(id);
        if (p != null) {
            produtos.remove(p);
            System.out.println("[ Produto " + id + " removido com sucesso!");
        } else {
            System.out.println(" Erro: Produto com ID " + id + " não encontrado!");
        }
    }

    public void editarPorId(int idBusca, Produto novoProduto) {
        Produto pAntigo = buscarPorId(idBusca);
        if (pAntigo != null) {
            int index = produtos.indexOf(pAntigo);
            produtos.set(index, novoProduto);
        }
    }

    public boolean idJaExiste(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }
}