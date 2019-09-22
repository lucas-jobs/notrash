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
public class Condominio {

  @Id
  @SequenceGenerator(name = "seqCondominio", allocationSize = 1)
  @GeneratedValue(generator = "seqCondominio", strategy = GenerationType.SEQUENCE)
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
  private List<CondominioMorador> moradores;

  @OneToMany(mappedBy = "condominio")
  private List<CondominioDiasColeta> diasColetas;

}
