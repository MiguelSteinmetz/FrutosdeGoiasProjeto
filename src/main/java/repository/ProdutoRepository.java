
package repository;

import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.Produto;
import org.postgresql.core.ConnectionFactory;

public class ProdutoRepository {
    private EntityManager em = CustomizerFactory.getEntityManager();

    public Produto buscarPorId(int id) {
        return this.em.find(Produto.class, id);
    }
    public List<Produto> buscarPorNome(String nome) {
    try {
        String jpql = "SELECT p FROM Produto p WHERE p.nome LIKE :nome";
        
        return this.em.createQuery(jpql, Produto.class)
                      .setParameter("nome", "%" + nome + "%")
                      .getResultList();

    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>(); 
        }
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
