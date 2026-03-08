package service;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class LoginService {

    private List<Usuario> usuarios = new ArrayList<>();

    public LoginService() {
        usuarios.add(new model.Gerente("admin", "123"));
        usuarios.add(new model.Funcionario("func", "123"));
    }

    public Usuario autenticar(String login, String senha) {
        for (Usuario p : usuarios) {
            if (p.getLogin().equals(login) && p.getSenha().equals(senha)) {
                return p;
            }
        }
        return null;
    }
}