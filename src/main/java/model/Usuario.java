
package model;

import jakarta.persistence.*;

@Entity (name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column (name = "nome")
    protected String nome;
    @Column (name = "login")
    protected String login;
    @Column (name = "senha")
    protected String senha;
    @Column (name = "tipo")
    protected String tipo;

    private double totalVendas;

    public Usuario(String nome, String login, String senha, String tipo) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario() {

    }

    public int getId() {return id;}

    public String getNome() {return this.nome;}

    public String getLogin() {return this.login;}

    public String getSenha() {
        return this.senha;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void adicionarVenda(double valor) {
        this.totalVendas += valor;
    }
}
