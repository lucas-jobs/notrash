package br.com.notrash.notrash.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "sequence_usuario", sequenceName = "seq_usuario", allocationSize = 1)
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_usuario")
  @Column(name = "ID", updatable = false)
  private Long id;

  @NotEmpty
  @Column(name = "TOKEN", updatable = false, unique = true)
  private String token;

  @Email
  @NotEmpty
  @Column(name = "EMAIL", updatable = false, unique = true, length = 100)
  private String email;

  @NotEmpty
  @Column(name = "NOME", length = 100)
  private String nome;

  @Temporal(TemporalType.DATE)
  @Column(name = "DATAHORA")
  private Calendar datahora;

}
