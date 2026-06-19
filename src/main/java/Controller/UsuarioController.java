package Controller;

import model.SessaoUsuario;
import model.Usuario;
import service.LogService;
import service.UsuarioService;

import java.util.List;


public class UsuarioController {

    //
    // Dependencias
    //
    private final UsuarioService usuarioService;
    private final LogService logService;

    //
    // Construtor
    //
    public UsuarioController() {
        this.usuarioService = new UsuarioService();
        this.logService     = new LogService();
    }

    //
    // LOGIN / LOGOUT
    //


    public ResultadoOperacao login(String login, String senha) {

        //    Validacoes de entrada
        if (login == null || login.trim().isEmpty()) {
            return ResultadoOperacao.erro("Informe o login.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            return ResultadoOperacao.erro("Informe a senha.");
        }

        //    Busca o usuario pelo login
        Usuario usuario = usuarioService.buscarPorLogin(login.trim());
        if (usuario == null) {
            return ResultadoOperacao.erro("Usuário não encontrado.");
        }

        //    Verifica a senha
        if (!usuario.getSenha().equals(senha)) {
            return ResultadoOperacao.erro("Senha incorreta.");
        }

        //   Armazena na sessao e registra log
        SessaoUsuario.setUsuarioLogado(usuario);
        logService.registrar(usuario.getNome(), "Realizou login no sistema.");

        return ResultadoOperacao.sucesso("Bem-vindo, " + usuario.getNome() + "!");
    }


    public void logout() {
        Usuario usuarioAtual = SessaoUsuario.getUsuarioLogado();
        if (usuarioAtual != null) {
            logService.registrar(usuarioAtual.getNome(), "Realizou logout do sistema.");
        }
        SessaoUsuario.limpar();
    }

    //
    // CONSULTAS
    //


    public List<Usuario> listarUsuarios() {
        return usuarioService.listaUsuarios();
    }


    public Usuario getUsuarioLogado() {
        return SessaoUsuario.getUsuarioLogado();
    }


    public boolean usuarioEhGerente() {
        Usuario u = SessaoUsuario.getUsuarioLogado();
        return u != null && "Gerente".equals(u.getTipo());
    }

    //
    // CADASTRAR FUNCIONARIO
    //


    public ResultadoOperacao cadastrarFuncionario(String nome, String login,
                                                  String senha, String tipo,
                                                  Usuario usuarioLogado) {
        //    Verifica permissão
        if (!usuarioEhGerente()) {
            return ResultadoOperacao.erro("Acesso negado. Apenas Gerentes podem cadastrar funcionários.");
        }

        //    Validações de campos
        if (nome == null || nome.trim().isEmpty()) {
            return ResultadoOperacao.erro("O nome não pode ser vazio.");
        }
        if (login == null || login.trim().isEmpty()) {
            return ResultadoOperacao.erro("O login não pode ser vazio.");
        }
        if (senha == null || senha.length() < 4) {
            return ResultadoOperacao.erro("A senha deve ter pelo menos 4 caracteres.");
        }
        if (!"Gerente".equals(tipo) && !"Funcionario".equals(tipo)) {
            return ResultadoOperacao.erro("Tipo inválido. Use \"Gerente\" ou \"Funcionario\".");
        }

        //   Verifica se o login já existe
        if (usuarioService.buscarPorLogin(login.trim()) != null) {
            return ResultadoOperacao.erro("Já existe um usuário com o login \"" + login + "\".");
        }

        //   Cria e salva o usuario
        Usuario novoUsuario = new Usuario(nome.trim(), login.trim(), senha, tipo);
        usuarioService.cadastrar(novoUsuario);

        //    Registra log
        logService.registrar(
                usuarioLogado.getNome(),
                "Cadastrou funcionário: " + novoUsuario.getNome() + " (" + tipo + ")"
        );

        return ResultadoOperacao.sucesso("Funcionário \"" + novoUsuario.getNome() + "\" cadastrado com sucesso!");
    }

    //
    // CLASSE AUXILIAR — mesmo padrão dos outros Controllers
    //


    public static class ResultadoOperacao {

        private final boolean sucesso;
        private final String mensagem;

        private ResultadoOperacao(boolean sucesso, String mensagem) {
            this.sucesso  = sucesso;
            this.mensagem = mensagem;
        }

        public static ResultadoOperacao sucesso(String mensagem) {
            return new ResultadoOperacao(true, mensagem);
        }

        public static ResultadoOperacao erro(String mensagem) {
            return new ResultadoOperacao(false, mensagem);
        }

        public boolean isSucesso() { return sucesso; }
        public String getMensagem() { return mensagem; }

        @Override
        public String toString() {
            return (sucesso ? "[OK] " : "[ERRO] ") + mensagem;
        }
    }
}