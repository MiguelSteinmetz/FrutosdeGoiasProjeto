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
    private Double preco;
    @Column(name = "estoque")
    private int estoque;
    @Column(nullable = false)
    private boolean ativo = true;
    @Column(name = "custo")
    private Double custo;

    public Produto(String nome, double preco, int estoque,double custo) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.custo = custo;
    }

    public Produto() {
    }

    public double getLucroBrutoUnitario() {
        return preco - custo;
    }

    public double getMargemLucro() {

        if (preco == 0) {
            return 0;
        }

        return ((preco - custo) / preco) * 100;
    }




    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void adicionarEstoque(double qtd) {
        this.estoque = (int)((double)this.estoque + qtd);
    }

    public void baixarEstoque(double qtd) {
        this.estoque = (int)((double)this.estoque - qtd);
    }

    public double calcularPreco(double qtd) {return this.preco * qtd;}
    public void setAtivo(boolean ativo) {this.ativo = ativo;}
    public Double getCusto() {return custo;}

    public void setCusto(Double custo) {this.custo = custo;}

}
