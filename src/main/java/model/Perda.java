package model;

import model.Producao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.CustomizerFactory;

public class Perda {
    public void salvar(Perda perda) {

        Transaction tx = null;

        try (Session session = CustomizerFactory.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(perda);

            tx.commit();

            System.out.println("PERDA SALVA !");

        } catch (Exception e) {

            if (tx != null) tx.rollback();

            e.printStackTrace();
        }
    }
}