package br.com.notrash.notrash.entity.converter;

import br.com.notrash.notrash.enumation.PontoStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter
public class PontoStatusConverter implements AttributeConverter<PontoStatus, String> {

    @Override
    public String convertToDatabaseColumn(PontoStatus value) {
        return Optional.ofNullable(value).map(PontoStatus::getDescricao).orElse(null);
    }

    @Override
    public PontoStatus convertToEntityAttribute(String value) {
        return PontoStatus.getPontoStatusByStatus(value);
    }
}
