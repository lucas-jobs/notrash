package br.com.notrash.notrash.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.notrash.notrash.entity.pk.CondDiasColetaPK;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_CONDOMINIO_DIAS_COLETA")
@IdClass(CondDiasColetaPK.class)
public class CondDiasColeta implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "DIA_SEMANA")
  private String diaSemana;

  @Id
  @ManyToOne
  @JoinColumn(name = "CONDOMINIO_ID", referencedColumnName = "ID")
  private Condominio condominio;

  @Column(name = "HORARIO")
  private String horario;

}
