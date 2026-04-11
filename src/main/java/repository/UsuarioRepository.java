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


    }
