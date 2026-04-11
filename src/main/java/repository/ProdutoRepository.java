
package repository;

import jakarta.persistence.EntityManager;
import java.util.List;
import model.Produto;

public class ProdutoRepository {
    private EntityManager em = CustomizerFactory.getEntityManager();

    public Produto buscarPorId(int id) {
        return this.em.find(Produto.class, id);
    }

    public void salvar(Produto produto) {
        this.em.getTransaction().begin();
        this.em.persist(produto);
        this.em.getTransaction().commit();
    }

    public List<Produto> buscartodos() {
        return this.em.createQuery("SELECT p FROM Produto p WHERE p.ativo = true ORDER BY p.id ASC ", Produto.class).getResultList();
    }

    public void remover(Produto produto) {
        this.em.getTransaction().begin();
        Produto p = this.em.find(Produto.class, produto.getId());
        if (p != null) {
            p.setAtivo(false);
            this.em.merge(p);
        }
        this.em.getTransaction().commit();
    }

    public void atualizar (Produto produto){
        this.em.getTransaction().begin();
        this.em.merge(produto);
        this.em.getTransaction().commit();
    }

}
