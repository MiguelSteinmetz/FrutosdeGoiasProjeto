package service;

import model.Funcionario;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;


public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(Usuario u) {
        usuarios.add(u);
    }

    public Usuario autenticar(String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    public boolean loginJaExiste(String login) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }

}