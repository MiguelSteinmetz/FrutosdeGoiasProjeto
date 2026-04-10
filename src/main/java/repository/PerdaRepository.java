package repository;

import model.Perda;
import org.hibernate.Session;

import java.util.List;

public class PerdaRepository {

    public void salvar(Perda perda) {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        session.beginTransaction();
        session.persist(perda);
        session.getTransaction().commit();

        session.close();
    }

    public List<Perda> buscarTodos() {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        List<Perda> lista = session
                .createQuery("FROM Perda", Perda.class)
                .list();

        session.close();
        return lista;
    }

    public Long totalPerdasPorProduto(int produtoId) {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        try {
            Long total = session.createQuery(
                            "SELECT SUM(p.quantidade) FROM Perda p WHERE p.produto.id = :id",
                            Long.class
                    ).setParameter("id", produtoId)
                    .uniqueResult();

            return total != null ? total : 0;
        } finally {
            session.close();
        }
    }
}