package br.com.notrash.notrash.repository;

import br.com.notrash.notrash.entity.HistoricoPontoColeta;
import br.com.notrash.notrash.entity.Morador;
import br.com.notrash.notrash.enumation.PontoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoPontoColetaRepository extends JpaRepository<HistoricoPontoColeta, Long> {

    List<HistoricoPontoColeta> findByMoradorAndStatus(Morador morador, PontoStatus status);

}
