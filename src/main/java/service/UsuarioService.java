//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package service;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {


    UsuarioRepository usuarioRepository = new UsuarioRepository();


    public void cadastrar(Usuario u) {

        usuarioRepository.salvar(u);
    }

    public Usuario autenticar(String login, String senha) {
        for(Usuario u : usuarioRepository.buscartodos()) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

}
