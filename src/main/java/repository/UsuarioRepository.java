package repository;

import jakarta.persistence.EntityManager;
import model.Produto;
import model.Usuario;

import java.util.List;

public class UsuarioRepository {
    private EntityManager em = CustomizerFactory.getEntityManager();

    public void registrar(Usuario u) {
        em.getTransaction().begin();
        em.persist(u);
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
        return em.createQuery("select u from Produto u ", Produto.class).getResultList();
    }

}