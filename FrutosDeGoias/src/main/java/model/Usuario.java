package model;

public abstract class Usuario {
    protected String nome;
    protected String login;
    protected String senha;
    protected String tipo;

    public Usuario(String nome, String login, String senha, String tipo) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public String getTipo() { return tipo; }
}