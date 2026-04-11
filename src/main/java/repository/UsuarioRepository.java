package repository;

import jakarta.persistence.EntityManager;
import model.Usuario;

import java.util.List;

public class UsuarioRepository {

    private EntityManager em = CustomizerFactory.getEntityManager();

    public void salvar(Usuario usuario) {
        this.em.getTransaction().begin();
        this.em.persist(usuario);
        this.em.getTransaction().commit();
    }

    public List<Usuario> buscartodos() {
        return this.em.createQuery("select u From Usuario u", Usuario.class).getResultList();
    }


}
