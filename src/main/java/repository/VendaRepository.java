package repository;

import jakarta.persistence.EntityManager;
import model.Venda;

import java.util.List;

public class VendaRepository {

    private EntityManager em = CustomizerFactory.getEntityManager();

    public void salvar(Venda venda) {
        this.em.getTransaction().begin();
        this.em.persist(venda);
        this.em.getTransaction().commit();
    }

    public List<Venda> buscartodos() {
        return this.em.createQuery("select v From Venda v", Venda.class).getResultList();
    }

}
