

package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomizerFactory {
    private static final EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void fechar() {
        emf.close();
    }

    static {
        SessionFactory sessionFactory = (new Configuration()).configure("hibernate.cfg.xml").buildSessionFactory();
        emf = (EntityManagerFactory)sessionFactory.unwrap(EntityManagerFactory.class);
    }
}
