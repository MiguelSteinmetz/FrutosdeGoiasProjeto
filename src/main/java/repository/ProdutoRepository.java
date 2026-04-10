package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Produto;
import org.hibernate.Session;


public class ProdutoRepository {

    private EntityManager em;

    public Produto buscarPorId(int id) {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        Produto produto = session.get(Produto.class, id);

        session.close();
        return produto;
    }

    public void salvar(Produto produto) {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        session.beginTransaction();
        session.persist(produto);
        session.getTransaction().commit();

        session.close();
    }

    public List<Produto> buscarTodos() {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        List<Produto> lista = session
                .createQuery("FROM Produto ORDER BY id ASC", Produto.class)
                .list();

        session.close();
        return lista;
    }

    public void remover(Produto produto) {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        session.beginTransaction();
        session.remove(produto);
        session.getTransaction().commit();

        session.close();
    }
    public void atualizar(Produto produto) {
        this.em.getTransaction().begin();
        this.em.merge(produto); // atualiza no banco
        this.em.getTransaction().commit();
    }
}