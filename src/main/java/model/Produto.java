//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package model;

import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private double preco;
    @Column(name = "estoque")
    private int estoque;
    @Column (name = "ativo")
    private boolean ativo;
    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto() {

    }


    public Long getId() {return this.id;}

    public String getNome() {return this.nome;}

    public void setNome(String nome) {this.nome = nome;}

    public double getPreco() {return this.preco;}

    public void setPreco(double preco) {this.preco = preco;}

    public int getEstoque() {return this.estoque;}

    public void setEstoque(int estoque) {this.estoque = estoque;}

    public void adicionarEstoque(double qtd) {this.estoque = (int)((double)this.estoque + qtd);}

    public void baixarEstoque(double qtd) {this.estoque = (int)((double)this.estoque - qtd);}

    public double calcularPreco(double qtd) {return this.preco * qtd;}
    public void setAtivo(boolean ativo) {this.ativo = ativo;}
}
