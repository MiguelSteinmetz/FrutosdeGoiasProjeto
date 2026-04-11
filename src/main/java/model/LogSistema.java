package model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "log_sistema")
public class LogSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;

    private String acao;

    private LocalDateTime data;

    public LogSistema() {}

    public LogSistema(String usuario, String acao) {
        this.usuario = usuario;
        this.acao = acao;
        this.data = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getAcao() {
        return acao;
    }

    public LocalDateTime getData() {
        return data;
    }
}

