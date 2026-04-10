//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package service;


import java.util.ArrayList;
import java.util.List;
import model.Produto;
import repository.ProdutoRepository;
import repository.*;

public class ProdutoService {
    private ProdutoRepository repositoryProduto = new ProdutoRepository();
    private ProducaoRepository producaoRepository = new ProducaoRepository();
    private VendaRepository vendaRepository = new VendaRepository();
    private PerdaRepository perdaRepository = new PerdaRepository();


    public void salvarProduto(Produto p) {
        if (p.getPreco() > 0) {
            repositoryProduto.salvar(p);
        } else {
            System.out.println("Erro: Preço inválido!");
        }
    }

    public List<Produto> listaProdutos(){
        List<Produto> produtos = repositoryProduto.buscarTodos();
        return produtos;
    }

    public Produto buscarPorId(int id) {
        Produto p = repositoryProduto.buscarPorId(id);
        if (p == null) {
            System.out.println("Aviso: Produto " + id + " não encontrado.");
        }
        return p;
    }

    public void deletar(Produto p){
        repositoryProduto.remover(p);
    }

    public void atualizar(Produto p){
        repositoryProduto.atualizar(p);
    }
    public int calcularEstoque(int produtoId) {

        int produzido = producaoRepository.totalProduzidoPorProduto(produtoId).intValue();
        int vendido = vendaRepository.totalVendidoPorProduto(produtoId).intValue();
        int perdas = perdaRepository.totalPerdasPorProduto(produtoId).intValue();

        return produzido - vendido - perdas;
    }

}
