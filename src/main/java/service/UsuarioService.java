
package service;


import model.Usuario;
import model.Venda;
import repository.UsuarioRepository;

import java.util.List;

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


    public List<Usuario> listaUsuarios(){
        List<Usuario> lista =usuarioRepository.buscartodos();
        return lista;
    }
}
