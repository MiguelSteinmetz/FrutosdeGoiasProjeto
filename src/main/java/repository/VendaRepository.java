package repository;

import jakarta.persistence.EntityManager;
import model.Venda;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class VendaRepository {

    private EntityManager em = CustomizerFactory.getEntityManager();

    public void salvar(Venda venda) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(venda);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao salvar venda: " + e.getMessage());
            throw e;
        }
    }

    public List<Venda> buscarTodos() {
        try {
            return this.em.createQuery("select v From Venda v", Venda.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao listar vendas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Long totalVendidoPorProduto(int produtoId) {
        try {

            Long total = em.createQuery(
                            "SELECT SUM(v.quantidade) FROM Venda v WHERE v.produto.id = :id",
                            Long.class
                    ).setParameter("id", produtoId)
                    .getSingleResult();
            return total != null ? total : 0;
        }catch (Exception e){
            System.err.println("Erro ao listar produtos mais vendidos: " + e.getMessage());
            return 0L;
        }
    }

    public List<Object[]> topProdutosVendidos() {
        try {
            String jpql = "SELECT v.produto.nome, SUM(v.quantidade) " +
                    "FROM Venda v " +
                    "GROUP BY v.produto.nome " +
                    "ORDER BY SUM(v.quantidade) DESC";
            return this.em.createQuery(jpql)
                    .getResultList();
        }catch (Exception e) {
            System.err.println("Erro ao listar produtos mais vendidos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}