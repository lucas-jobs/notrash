package br.com.notrash.notrash.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.notrash.notrash.entity.pk.UsuarioCondominioPK;
import lombok.Data;

@Data
@Entity
@IdClass(UsuarioCondominioPK.class)
@Table(name = "TB_USUARIO_CONDOMINIO")
public class UsuarioCondominio implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @OneToOne
  @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
  private Usuario usuario;

  @Id
  @OneToOne
  @JoinColumn(name = "CONDOMINIO_ID", referencedColumnName = "ID")
  private Condominio condominio;

  @Temporal(TemporalType.DATE)
  @Column(name = "DATAHORA")
  private Calendar datahora;

}
