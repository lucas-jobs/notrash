package br.com.notrash.notrash.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_CONDOMINIO")
@SequenceGenerator(name = "sequence_condominio", sequenceName = "seq_condominio", allocationSize = 1)
public class Condominio {

  @Id
  @GeneratedValue(generator = "sequence_condominio", strategy = GenerationType.SEQUENCE)
  @Column(name = "ID", insertable = true, updatable = false)
  private Long id;

  @NotEmpty
  @Column(name = "EDIFICIO", length = 150)
  private String nome;

  @NotEmpty
  @Column(name = "RESPONSAVEL", length = 100)
  private String responsavel;

  @Email
  @NotEmpty
  @Column(name = "EMAIL", length = 100)
  private String email;

  @OneToMany(mappedBy = "condominio")
  private List<CondDiasColeta> diasColetas;


}
