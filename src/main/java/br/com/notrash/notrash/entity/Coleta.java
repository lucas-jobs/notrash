package br.com.notrash.notrash.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

@Data
@Entity
@Table(name = "TB_COLETA")
@SequenceGenerator(name = "codigo", sequenceName = "T_SQ_COLETA", allocationSize = 1)
@NoArgsConstructor @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coleta implements Serializable {

    @Id
    @GeneratedValue(generator = "codigo", strategy = GenerationType.SEQUENCE)
    @Column(name = "CODIGO")
    private Long codigo;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PONTO_COLETA", referencedColumnName = "CODIGO")
    private HistoricoPontoColeta pontoColeta;

    @NotEmpty(message = "Tipo do Lixo Obrigatorio, Favor preencher corretamente")
    @Column(name = "DES_TIPO", nullable = false)
    private String tipo;

    @NotNull(message = "Peso do Lixo Obrigatorio, Favor preencher corretamente")
    @Column(name = "DES_PESO", nullable = false)
    private Double peso;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_HORA", nullable = false)
    private Calendar dataHora;

    @NotNull(message = "CPF do Morador Obrigatorio, Favor preencher corretamente")
    private transient Long cpf;

    @PrePersist
    @PreUpdate
    public void preCadastro(){
        this.dataHora = Calendar.getInstance();
    }

}
