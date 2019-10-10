package br.com.notrash.notrash.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_MORADOR")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Morador implements Serializable {

    @Id
    @NotNull(message = "Campo 'CPF' Obrigatorio, Favor preencher corretamente")
    @Column(name = "CPF", length = 11)
    private Long cpf;

    @NotEmpty(message = "Campo 'Nome' Obrigatorio, Favor preencher corretamente")
    @Column(name = "DES_NOME", nullable = false, length = 100)
    private String nome;

    @NotEmpty(message = "Campo 'Apartamento' Obrigatorio, Favor preencher corretamente")
    @Column(name = "DES_APTO", nullable = false, length = 10)
    private String apto;

    @Column(name = "PONTUACAO", nullable = false, length = 10)
    private Integer pontuacao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DES_EMAIL", referencedColumnName = "EMAIL")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "CONDOMINIO_CNPJ", referencedColumnName = "CNPJ", nullable = false)
    private Condominio condominio;

    private transient Long cnpj;
    private transient Integer pontoUsado;

    @PrePersist
    public void preCadastro() {
        this.pontuacao = 0;
    }

}
