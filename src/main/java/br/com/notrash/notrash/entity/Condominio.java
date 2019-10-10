package br.com.notrash.notrash.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_CONDOMINIO")
public class Condominio implements Serializable {

    @Id
    @NotNull(message = "Campo 'CNPJ' obrigatorio. Favor preencher corretamente")
    @Column(name = "CNPJ", length = 14)
    private Long cnpj;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DES_EMAIL", referencedColumnName = "EMAIL")
    private Usuario usuario;

    @NotEmpty(message = "Campo 'Razão social' obrigatorio, favor preencher corretamente")
    @Column(name = "RAZAO_SOCIAL", nullable = false, length = 75)
    private String razaoSocial;

    @NotNull(message = "Campo 'CEP' obrigatorio, favor preencher corretamente")
    @Column(name = "CEP", nullable = false, length = 8)
    private Long cep;

    @NotEmpty(message = "Campo 'Logradouro' obrigatorio, favor preencher corretamente")
    @Column(name = "LOGRADOURO", nullable = false, length = 100)
    private String logradouro;

    @NotEmpty(message = "Campo 'Bairro' obrigatorio, favor preencher corretamente")
    @Column(name = "BAIRRO", nullable = false, length = 100)
    private String bairro;

    @NotEmpty(message = "Campo 'Cidade' obrigatorio, favor preencher corretamente")
    @Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;

    @NotEmpty(message = "Campo 'Estado' obrigatorio, favor preencher corretamente")
    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;

    @NotEmpty(message = "Campo 'Região' obrigatorio, favor preencher corretamente")
    @Column(name = "REGIAO", nullable = false, length = 20)
    private String regiao;

    @NotEmpty(message = "Campo 'Complemento' obrigatorio, favor preencher corretamente")
    @Column(name = "COMPLEMENTO", nullable = false, length = 30)
    private String complemento;

    @NotNull(message = "Campo 'Número' obrigatorio, favor preencher corretamente")
    @Column(name = "NUMERO", nullable = false, length = 8)
    private Integer numero;

}
