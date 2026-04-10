package repository;

import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import model.Producao;
import java.util.List;

public class ProducaoRepository {

    private EntityManager em = CustomizerFactory.getEntityManager();


    public void salvar(Producao producao) {

        em.getTransaction().begin();
        em.persist(producao);
        em.getTransaction().commit();

    }

    public List<Producao> buscarTodos() {
        return this.em.createQuery("SELECT p FROM Producao p ", Producao.class).getResultList();
    }

    public Long totalProduzidoPorProduto(int produtoId) {

        Long total =  em.createQuery("SELECT SUM(p.quantidade) FROM Producao p WHERE p.produto.id =:id", Long.class).setParameter("id", produtoId).getSingleResult();
        return total != null ? total : 0L;
    }
}