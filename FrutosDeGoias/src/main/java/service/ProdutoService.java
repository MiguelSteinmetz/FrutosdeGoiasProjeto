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
        return null; // Não achou
    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto buscarPorIndice(int index) {
        if (index >= 0 && index < produtos.size()) {
            return produtos.get(index);
        }
        System.out.println("[X] Produto não encontrado!");
        return null;
    }
    public void deletar(int index) {
        if (index >= 0 && index < produtos.size()) {
            produtos.remove(index);
            System.out.println("[V] Produto removido com sucesso!");
        } else {
            System.out.println("[X] Índice inválido!");
        }
    }

    public void atualizar(int idAntigo, Produto novoProduto) {
        // 1. Remove o produto que tem o ID antigo
        Produto p = buscarPorId(idAntigo);
        if (p != null) {
            produtos.remove(p);
            // 2. Adiciona a nova versão editada
            produtos.add(novoProduto);
        }
    }

    public void editar(int index, Produto novoProduto) {
        if (index >= 0 && index < produtos.size()) {
            produtos.set(index, novoProduto);
            System.out.println("[V] Produto atualizado!");
        }
    }

    public boolean idJaExiste(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return true; // Encontrou um produto com esse ID
            }
        }
        return false;
    }
}