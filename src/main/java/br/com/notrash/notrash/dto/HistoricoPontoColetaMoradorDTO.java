package br.com.notrash.notrash.dto;

import br.com.notrash.notrash.enumation.PontoStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Calendar;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistoricoPontoColetaMoradorDTO {

    private Double peso;
    private String tipo;
    private Integer ponto;
    private PontoStatus status;
    private Calendar dataHora;

}
