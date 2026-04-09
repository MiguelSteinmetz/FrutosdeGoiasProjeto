package model;

import jakarta.persistence.*;

@Entity( name = "Venda")
public class Venda {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario_fk")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;

    @Column(name = "tipo_pagamento")
    private String tipoPagamento;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "valortotal")
    private double valorTotal;

    public Venda(Usuario usuario, Produto produto, int quantidade, double valorTotal, String tipoPagamento) {
        this.usuario = usuario;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
    }

    public Venda(){

    }

    public Produto getProduto() {return produto;}
    public void setProduto(Produto produto) {this.produto = produto;}
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
    public double getValorTotal() {return valorTotal;}
    public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}
    public String getTipoPagamento() {return tipoPagamento;}
    public void setTipoPagamento(String tipoPagamento) {this.tipoPagamento = tipoPagamento;}
}
