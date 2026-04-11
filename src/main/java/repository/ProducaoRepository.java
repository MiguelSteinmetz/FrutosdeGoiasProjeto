package repository;

import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import model.Producao;

import java.util.ArrayList;
import java.util.List;

public class ProducaoRepository {

    private EntityManager em = CustomizerFactory.getEntityManager();


    public void salvar(Producao producao) {
        try {
            em.getTransaction().begin();
            em.persist(producao);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao registrar produção: " + e.getMessage());
            throw e;
        }
    }

    public List<Producao> buscarTodos() {
        try {
            return this.em.createQuery("SELECT p FROM Producao p ", Producao.class).getResultList();
        }catch (Exception e){
            System.out.println("Erro ao buscar a lista de producao: ");
            return new ArrayList<>();
        }

    }

    public Long totalProduzidoPorProduto(int produtoId) {

        Long total =  em.createQuery("SELECT SUM(p.quantidade) FROM Producao p WHERE p.produto.id =:id", Long.class).setParameter("id", produtoId).getSingleResult();
        return total != null ? total : 0L;
    }
}