package repository;

import jakarta.persistence.EntityManager;
import model.Produto;
import repository.CustomizerFactory;

import java.util.List;

public class ProdutosRepository {
    private EntityManager em = CustomizerFactory.getEntityManager();

    public void salvar(Produto p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public void atualizar(Produto p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    public void deletar(int id) {
        Produto p = em.find(Produto.class, id);
        if (p != null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }
    }

    public List<Produto> buscartodos() {
        return em.createQuery("select p from Produto p ", Produto.class).getResultList();
    }
}