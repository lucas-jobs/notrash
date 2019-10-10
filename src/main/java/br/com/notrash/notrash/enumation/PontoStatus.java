package br.com.notrash.notrash.enumation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


@AllArgsConstructor
public enum PontoStatus {

    RECEBIDO("R", "Ponto Recebido"),
    USADO("U", "Ponto Usado");

    @Getter @Setter
    private String status;

    @Getter @Setter
    private String descricao;

    public static PontoStatus getPontoStatusByStatus(String status) {
        return Arrays.asList(values()).stream().filter(f -> f.getStatus().equalsIgnoreCase(status)).findFirst().orElse(null);
    }

}
