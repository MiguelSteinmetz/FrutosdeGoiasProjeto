
package repository;

import jakarta.persistence.EntityManager;
import java.util.List;
import model.Produto;

public class ProdutoRepository {
    private EntityManager em = CustomizerFactory.getEntityManager();

    public Produto buscarPorId(int id) {
        return (Produto)this.em.find(Produto.class, id);
    }

    public void salvar(Produto produto) {
        this.em.getTransaction().begin();
        this.em.persist(produto);
        this.em.getTransaction().commit();
        em.close();
    }

    public List<Produto> buscartodos() {
        return this.em.createQuery("select p From Produto p", Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String prefixo) {
        return this.em.createQuery("select p from Produto p where p.nome like :prefixo", Produto.class).setParameter("prefixo", prefixo + "%").getResultList();
    }

    public void remover(Produto produto) {
        this.em.getTransaction().begin();
        this.em.remove(this.em.contains(produto) ? produto : this.em.merge(produto));
        this.em.getTransaction().commit();
    }
}
