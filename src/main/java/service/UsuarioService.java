//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package service;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList();

    public void cadastrar(Usuario u) {
        this.usuarios.add(u);
    }

    public Usuario autenticar(String login, String senha) {
        for(Usuario u : this.usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }

        return null;
    }

    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    public boolean loginJaExiste(String login) {
        for(Usuario u : this.usuarios) {
            if (u.getLogin().equalsIgnoreCase(login)) {
                return true;
            }
        }

        return false;
    }
}
