package br.com.notrash.notrash.enumation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
public enum ParametroPontos {

    PARAMETRO_1(1, 3, 5),
    PARAMETRO_2(3, 5, 10),
    PARAMETRO_3(5, 7, 15),
    PARAMETRO_4(7, 9, 20),
    PARAMETRO_5(9, 11, 25),
    PARAMETRO_6(11, 13, 30),
    PARAMETRO_7(13, 15, 35);

    @Getter @Setter
    private Integer pesoMinimo;

    @Getter @Setter
    private Integer pesoMaximo;

    @Getter @Setter
    private Integer ponto;

    public static Integer getPontoByPeso(Double peso) {
        if (peso == null || peso == 0) {
            return 0;
        }

        return Arrays.asList(values()).stream().filter(parametro ->
                pesagem(peso, parametro.getPesoMinimo(), parametro.getPesoMaximo())
        ).map(ParametroPontos::getPonto).findFirst().orElse(0);

    }

    private static boolean pesagem(Double peso, Integer pesoMinimo, Integer pesoMaximo) {
        if (peso >= peso) {
            if(peso < pesoMaximo) return true;

            return false;
        } else {
            return false;
        }
    }

}
