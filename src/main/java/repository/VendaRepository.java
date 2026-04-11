package repository;

import jakarta.persistence.EntityManager;
import model.Venda;
import org.hibernate.Session;

import java.util.List;

public class VendaRepository {

    private EntityManager em = CustomizerFactory.getEntityManager();

    public void salvar(Venda venda) {
        this.em.getTransaction().begin();
        this.em.persist(venda);
        this.em.getTransaction().commit();
    }

    public List<Venda> buscarTodos() {
        return this.em.createQuery("select v From Venda v", Venda.class).getResultList();
    }

    public Long totalVendidoPorProduto(int produtoId) {

        Long total = em.createQuery(
                        "SELECT SUM(v.quantidade) FROM Venda v WHERE v.produto.id = :id",
                        Long.class
                ).setParameter("id", produtoId)
                .getSingleResult();

        return total != null ? total : 0;
    }

    public List<Object[]> topProdutosVendidos() {
        String jpql = "SELECT v.produto.nome, SUM(v.quantidade) " +
                "FROM Venda v " +
                "GROUP BY v.produto.nome " +
                "ORDER BY SUM(v.quantidade) DESC";

        return this.em.createQuery(jpql)
                .getResultList();
    }
}