package br.com.notrash.notrash.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

@Data
@Entity
@Table(name = "TB_USUARIO")
@AllArgsConstructor @NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @Email
    @NotEmpty(message = "Campo 'Email' Obrigatorio, Favor preencher corretamente")
    @Column(name = "EMAIL", nullable = false, length = 150)
    private String email;

    @Column(name = "NOME_COMPLETO", length = 100)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_HORA")
    private Calendar dataHora;

    @PrePersist
    public void preCadastro(){
        this.dataHora = Calendar.getInstance();
    }

    public Usuario(String email) {
        this.email = email;
    }

}
