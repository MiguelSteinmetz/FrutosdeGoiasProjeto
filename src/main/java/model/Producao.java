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

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private double quantidade;

    private LocalDateTime data;

    // construtor vazio pro Hibernate
    public Producao() {
    }

    public Producao(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public double getQuantidade() { return quantidade; }
    public void setQuantidade(double quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

}