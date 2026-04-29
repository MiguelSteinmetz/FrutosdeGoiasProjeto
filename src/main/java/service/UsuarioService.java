
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

    public boolean autenticar(String login, String senha) {
    Usuario usuario = usuarioRepository.buscarPorLoginESenha(login, senha);
    return usuario != null;
}


    public List<Usuario> listaUsuarios(){
        List<Usuario> lista =usuarioRepository.buscartodos();
        return lista;
    }
    
}
