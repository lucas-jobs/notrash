package br.com.notrash.notrash.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.notrash.notrash.entity.pk.CondominioMoradorPK;
import lombok.Data;

@Data
@Entity
@IdClass(CondominioMoradorPK.class)
@Table(name = "TB_CONDOMINIO_MORADOR")
public class CondominioMorador implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @ManyToOne
  @JoinColumn(name = "CONDOMINIO_ID", referencedColumnName = "ID")
  private Condominio condominio;

  @Id
  @OneToOne
  @JoinColumn(name = "MORADOR_ID", referencedColumnName = "ID", unique = true)
  private Morador morador;

  @Column(name = "DATAHORA")
  @Temporal(TemporalType.DATE)
  private Calendar datahora;

}
