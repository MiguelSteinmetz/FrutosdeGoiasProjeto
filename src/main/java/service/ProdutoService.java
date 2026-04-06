//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package service;

import java.util.ArrayList;
import java.util.List;
import model.Produto;
import repository.ProdutoRepository;

public class ProdutoService {
    ProdutoRepository repository = new ProdutoRepository();

    public void salvarProduto(Produto p) {

        if (p.getPreco() > 0) {
            repository.salvar(p);
        } else {
            System.out.println("Erro: Preço inválido!");
        }
    }

    public List<Produto> listaProdutos(){
        List<Produto> produtos = repository.buscartodos();
        return produtos;
    }

    public Produto buscarPorId(int id) {
        Produto p = repository.buscarPorId(id);
        if (p == null) {
            System.out.println("Aviso: Produto " + id + " não encontrado.");
        }
        return p;
    }
}
