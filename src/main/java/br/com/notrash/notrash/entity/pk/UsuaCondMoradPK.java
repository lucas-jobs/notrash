package br.com.notrash.notrash.entity.pk;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class UsuaCondMoradPK implements Serializable {

    private Long usuario;
    private Long condominio;
    private Long morador;

}
