package repository;

import model.Venda;
import org.hibernate.Session;

import java.util.List;

public class VendaRepository {

    public void salvar(Venda venda) {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        session.beginTransaction();
        session.persist(venda);
        session.getTransaction().commit();

        session.close();
    }

    public List<Venda> buscarTodos() {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        List<Venda> lista = session
                .createQuery("FROM Venda", Venda.class)
                .list();

        session.close();
        return lista;
    }
    public Long totalVendidoPorProduto(int produtoId) {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        Long total = session.createQuery(
                        "SELECT SUM(v.quantidade) FROM Venda v WHERE v.produto.id = :id",
                        Long.class
                ).setParameter("id", produtoId)
                .uniqueResult();

        session.close();
        return total != null ? total : 0;
    }
}