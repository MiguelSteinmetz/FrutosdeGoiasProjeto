//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package service;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoService {
    private List<Produto> listaProdutos = new ArrayList();

    public void adicionar(Produto p) {
        this.listaProdutos.add(p);
    }

    public List<Produto> listarTodos() {
        return this.listaProdutos;
    }

    public Produto buscarPorId(int id) {
        for(Produto p : this.listaProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public boolean deletarPorId(int id) {
        Produto p = this.buscarPorId(id);
        return p != null ? this.listaProdutos.remove(p) : false;
    }

    public boolean idJaExiste(int id) {
        return this.buscarPorId(id) != null;
    }
}
