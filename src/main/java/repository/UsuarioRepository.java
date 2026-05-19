    package repository;

    import jakarta.persistence.EntityManager;
    import model.Usuario;

    import java.util.ArrayList;
    import java.util.List;

    public class UsuarioRepository {

    private EntityManager em =
            CustomizerFactory.getEntityManager();

    public void salvar(Usuario usuario) {

        try {

            em.getTransaction().begin();

            em.persist(usuario);

            em.getTransaction().commit();

        } catch (Exception e) {

            System.err.println(
                    "Erro ao salvar usuário: "
                    + e.getMessage()
            );

            throw e;
        }
    }

    public void atualizar(Usuario usuario) {

        try {

            em.getTransaction().begin();

            em.merge(usuario);

            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

            System.err.println(
                    "Erro ao atualizar usuário: "
                    + e.getMessage()
            );

            throw e;
        }
    }

    public List<Usuario> buscartodos() {

        try {

            return em.createQuery(
                    "select u From Usuario u ORDER BY u.id ASC",
                    Usuario.class
            ).getResultList();

        } catch (Exception e) {

            System.err.println(
                    "Erro ao listar usuários: "
                    + e.getMessage()
            );

            return new ArrayList<>();
        }
    }

    public Usuario buscarPorLoginESenha(
            String login,
            String senha
    ) {

        EntityManager em =
                CustomizerFactory.getEntityManager();

        try {

            List<Usuario> lista = em.createQuery(
                    "SELECT u FROM Usuario u "
                    + "WHERE u.login = :login "
                    + "AND u.senha = :senha",
                    Usuario.class
            )
            .setParameter("login", login)
            .setParameter("senha", senha)
            .getResultList();

            return lista.isEmpty()
                    ? null
                    : lista.get(0);

        } catch (Exception e) {

            System.err.println(
                    "Erro no login: "
                    + e.getMessage()
            );

            return null;

        } finally {

            em.close();
        }
    }
    public void remover(Usuario usuario) {

        try {

            em.getTransaction().begin();

            usuario = em.merge(usuario);

            em.remove(usuario);

            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

            throw e;
        }
    }
    
    public Usuario buscarPorId(int id) {

    return em.find(Usuario.class, id);
    }
    public List<Usuario> buscarPorNome(String nome) {

    return em.createQuery(
            "SELECT u FROM Usuario u "
            + "WHERE LOWER(u.nome) "
            + "LIKE LOWER(:nome)",
            Usuario.class
    )
    .setParameter("nome", "%" + nome + "%")
    .getResultList();
    }
}    