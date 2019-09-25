package br.com.notrash.notrash.entity.pk;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CondDiasColetaPK implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long condominio;
  private String diaSemana;

}
