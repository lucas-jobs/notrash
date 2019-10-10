package br.com.notrash.notrash.service;

import br.com.notrash.notrash.entity.Coleta;
import br.com.notrash.notrash.entity.HistoricoPontoColeta;
import br.com.notrash.notrash.entity.Morador;
import br.com.notrash.notrash.enumation.ParametroPontos;
import br.com.notrash.notrash.enumation.PontoStatus;
import br.com.notrash.notrash.exception.BusinessException;
import br.com.notrash.notrash.repository.ColetaRepository;
import br.com.notrash.notrash.repository.HistoricoPontoColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ColetaService {

    private final MoradorService moradorService;
    private final ColetaRepository coletaRepository;
    private final HistoricoPontoColetaRepository historicoPontoColetaRepository;

    @Autowired
    public ColetaService(MoradorService moradorService,
                         ColetaRepository coletaRepository,
                         HistoricoPontoColetaRepository historicoPontoColetaRepository) {
        this.moradorService = moradorService;
        this.coletaRepository = coletaRepository;
        this.historicoPontoColetaRepository = historicoPontoColetaRepository;
    }

    @Transactional
    public void salvar(Coleta coleta) throws BusinessException {
        Morador morador = moradorService.buscar(coleta.getCpf());

        Integer pontoColetado = ParametroPontos.getPontoByPeso(coleta.getPeso());

        // Salvar Dados de Pontos
        HistoricoPontoColeta historicoPontoColeta = new HistoricoPontoColeta();
        historicoPontoColeta.setMorador(morador);
        historicoPontoColeta.setStatus(PontoStatus.RECEBIDO);
        historicoPontoColeta.setPontuacao(pontoColetado);
        historicoPontoColetaRepository.saveAndFlush(historicoPontoColeta);

        // Salvar Dados de Coleta
        coleta.setPontoColeta(historicoPontoColeta);
        coletaRepository.saveAndFlush(coleta);

        // Soma Pontuação Atual e Altera dados na tabela Morador
        Integer somaPontuacao = Optional.of(morador.getPontuacao())
                .map(pontuacaoAtual -> pontuacaoAtual + pontoColetado)
                .orElse(pontoColetado);

        morador.setPontuacao(somaPontuacao);
        moradorService.alterar(coleta.getCpf(), morador);
    }

}
