package repository;

import jakarta.persistence.EntityManager;
import model.LogSistema;

import java.util.List;

public class LogRepository {

    public void salvar(LogSistema log) {

        EntityManager em = CustomizerFactory.getEntityManager();

        em.getTransaction().begin();

        em.persist(log);

        em.getTransaction().commit();

        em.close();
    }

    public List<LogSistema> listarTodos() {

        EntityManager em = CustomizerFactory.getEntityManager();

        List<LogSistema> logs = em
                .createQuery("FROM LogSistema", LogSistema.class)
                .getResultList();

        em.close();

        return logs;
    }
}