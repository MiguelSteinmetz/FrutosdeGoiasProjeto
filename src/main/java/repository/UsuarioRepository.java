package repository;

import model.Usuario;
import org.hibernate.Session;
import java.util.List;

public class UsuarioRepository {

    public void salvar(Usuario usuario) {
        Session session = CustomizerFactory.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(usuario);

        session.getTransaction().commit();
        session.close();
    }
    public List<Usuario> buscarTodos() {
        Session session = CustomizerFactory.getSessionFactory().openSession();

        List<Usuario> lista = session
                .createQuery("FROM Usuario", Usuario.class)
                .list();

        session.close();
        return lista;
    }
}