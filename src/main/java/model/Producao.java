package model;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.CustomizerFactory;

import java.time.LocalDateTime;

@Entity
@Table(name = "producao")
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produto_id")
    private int produtoId;

    @Column(name = "quantidade")
    private double quantidade;

    private LocalDateTime data;

    // construtor vazio pro Hibernate
    public Producao() {
    }

    public Producao(int produtoId, double quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
    }

    // getters e setters
    public Long getId() {
        return id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

}