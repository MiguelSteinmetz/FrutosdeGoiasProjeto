package service;

import model.Produto;
import repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private ProdutoRepository repo = new ProdutoRepository();

    private List<Produto> listaProdutos = new ArrayList<>();

    public void adicionar(Produto p) {
        listaProdutos.add(p);
    }

    public List<Produto> listarTodos() {
        return listaProdutos;
    }

    public Produto buscarPorId(int id) {
        for (Produto p : listaProdutos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public boolean deletarPorId(int id) {
        Produto p = buscarPorId(id);
        if (p != null) {
            return listaProdutos.remove(p);
        }
        return false;
    }


    public boolean idJaExiste(int id) {
        return buscarPorId(id) != null;
    }

}