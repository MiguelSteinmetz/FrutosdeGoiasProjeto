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
    }
    public void remover(Usuario usuario) {

        try {

            em.getTransaction().begin();

        public List<Usuario> buscartodos() {
            return this.em.createQuery("select u From Usuario u", Usuario.class).getResultList();
        }


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