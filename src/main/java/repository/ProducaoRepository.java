package repository;

import model.Producao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ProducaoRepository {

    public void salvar(Producao producao) {

        Transaction transaction = null;

        try (Session session = CustomizerFactory.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(producao);

            transaction.commit();

            System.out.println("✔ Produção salva com Hibernate!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

        }

    }
    public List<Producao> buscarTodos() {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        List<Producao> lista = session
                .createQuery("FROM Producao", Producao.class)
                .list();

        session.close();
        return lista;
    }

    public Long totalProduzidoPorProduto(int produtoId) {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        try {
            Long total = session.createQuery(
                            "SELECT SUM(p.quantidade) FROM Producao p WHERE p.produto.id = :id",
                            Long.class
                    ).setParameter("id", produtoId)
                    .uniqueResult();

            return total != null ? total : 0;
        } finally {
            session.close();
        }
    }
}