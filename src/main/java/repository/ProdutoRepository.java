
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
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Cancela se der erro no meio
            }
            System.err.println("Erro ao salvar produto: " + e.getMessage());
            throw e; // Lança para o Service/Sistema saberem que falhou
        }
    }

    public List<Produto> buscartodos() {
        return this.em.createQuery("SELECT p FROM Produto p WHERE p.ativo = true ORDER BY p.id ASC ", Produto.class).getResultList();
    }

    public void remover(Produto produto) {
        try {
            em.getTransaction().begin();
            Produto p = this.em.find(Produto.class, produto.getId());
            if (p != null) {
                p.setAtivo(false);
                this.em.merge(p);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao desativar produto: " + e.getMessage());
            throw e;
        }
    }

    public void atualizar(Produto produto) {
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
            throw e;
        }
    }

}
