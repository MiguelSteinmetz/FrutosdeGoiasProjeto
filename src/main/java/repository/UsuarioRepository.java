    package repository;

    import jakarta.persistence.EntityManager;
    import model.Produto;
    import model.Usuario;

    import java.util.ArrayList;
    import java.util.List;

    public class UsuarioRepository {

        private EntityManager em = CustomizerFactory.getEntityManager();

        public void salvar(Usuario usuario) {
            try {
                em.getTransaction().begin();
                this.em.persist(usuario);
                this.em.getTransaction().commit();
            } catch (Exception e) {
                System.err.println("Erro ao salvar usuário: " + e.getMessage());
                throw e;
            }
        }

        public List<Usuario> buscartodos() {
            try {
                return this.em.createQuery("select u From Usuario u", Usuario.class).getResultList();
            } catch (Exception e) {
                System.err.println("Erro ao listar usuários: " + e.getMessage());
                return new ArrayList<>();
            }
        }
        public Usuario buscarPorLoginESenha(String login, String senha) {
    EntityManager em = CustomizerFactory.getEntityManager();

    try {
        List<Usuario> lista = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha",
                Usuario.class)
                .setParameter("login", login)
                .setParameter("senha", senha)
                .getResultList();

        return lista.isEmpty() ? null : lista.get(0);

    } catch (Exception e) {
        System.err.println("Erro no login: " + e.getMessage());
        return null;
    } finally {
        em.close(); // 🔥 evita erro depois
    }
}


    }
