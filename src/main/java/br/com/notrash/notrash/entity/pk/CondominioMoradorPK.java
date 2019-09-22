package br.com.notrash.notrash.entity.pk;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CondominioMoradorPK implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long condominio;
  private Long morador;

}
