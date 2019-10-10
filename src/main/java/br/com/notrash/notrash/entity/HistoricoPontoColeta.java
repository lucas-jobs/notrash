package br.com.notrash.notrash.entity;

import br.com.notrash.notrash.entity.converter.PontoStatusConverter;
import br.com.notrash.notrash.enumation.PontoStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Data
@Entity
@Table(name = "TB_HISTORICO_PONTO_COLETA")
@SequenceGenerator(name = "codigo", sequenceName = "T_SQ_HIST_PONT_COLE", allocationSize = 1)
public class HistoricoPontoColeta implements Serializable {

    @Id
    @GeneratedValue(generator = "codigo", strategy = GenerationType.SEQUENCE)
    @Column(name = "CODIGO")
    private Long codigo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MORADOR_ID", referencedColumnName = "CPF")
    private Morador morador;

    @Column(name = "PONTUACAO", nullable = false)
    private Integer pontuacao;

    @Column(name = "STATUS", nullable = false)
    @Convert(converter = PontoStatusConverter.class)
    private PontoStatus status;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_HORA", nullable = false)
    private Calendar dataHora;

    @OneToOne(mappedBy = "pontoColeta")
    private Coleta coleta;

    @PrePersist
    @PreUpdate
    public void preCadastro(){
        this.dataHora = Calendar.getInstance();
    }
}
