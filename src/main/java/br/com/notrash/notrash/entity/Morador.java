package br.com.notrash.notrash.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_MORADOR")
public class Morador {

  @Id
  @SequenceGenerator(name = "seqCondominio", allocationSize = 1)
  @GeneratedValue(generator = "seqCondominio", strategy = GenerationType.SEQUENCE)
  @Column(name = "ID", insertable = true, updatable = false)
  private Long id;

  @Column(name = "NOME", length = 100)
  @NotEmpty
  private String nome;

  @Column(name = "EMAIL", length = 100)
  @Email
  private String email;

  @Column(name = "DATAHORA")
  @Temporal(TemporalType.DATE)
  private Calendar datahora;

  // @OneToOne(mappedBy = "morador")
  // private CondominioMorador condominio;

}
