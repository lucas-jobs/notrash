package br.com.notrash.notrash.service;

import br.com.notrash.notrash.dto.HistoricoPontoColetaMoradorDTO;
import br.com.notrash.notrash.entity.Condominio;
import br.com.notrash.notrash.entity.HistoricoPontoColeta;
import br.com.notrash.notrash.entity.Morador;
import br.com.notrash.notrash.entity.Usuario;
import br.com.notrash.notrash.enumation.PontoStatus;
import br.com.notrash.notrash.exception.BusinessException;
import br.com.notrash.notrash.repository.ColetaRepository;
import br.com.notrash.notrash.repository.HistoricoPontoColetaRepository;
import br.com.notrash.notrash.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class MoradorService {

    private final MoradorRepository moradorRepository;
    private final UsuarioService usuarioService;
    private final CondominioService condominioService;
    private final ColetaRepository coletaRepository;
    private final HistoricoPontoColetaRepository historicoPontoColetaRepository;

    @Autowired
    public MoradorService(MoradorRepository moradorRepository,
                          UsuarioService usuarioService,
                          CondominioService condominioService,
                          ColetaRepository coletaRepository,
                          HistoricoPontoColetaRepository historicoPontoColetaRepository) {
        this.moradorRepository = moradorRepository;
        this.usuarioService = usuarioService;
        this.condominioService = condominioService;
        this.coletaRepository = coletaRepository;
        this.historicoPontoColetaRepository = historicoPontoColetaRepository;
    }

    @Transactional
    public void salvar(Morador morador) throws BusinessException {
        if (moradorRepository.existsById(morador.getCpf())) {
            throw new BusinessException("Morador já existe!");
        }

        Usuario usuario = usuarioService.buscar(morador.getUsuario().getEmail());
        Condominio condominio = condominioService.buscar(morador.getCnpj());

        morador.setUsuario(usuario);
        morador.setCondominio(condominio);

        moradorRepository.saveAndFlush(morador);
    }

    @Transactional
    public void alterar(Long cpf, Morador morador) throws BusinessException {
        if (!moradorRepository.existsById(cpf)) {
            throw new BusinessException("Morador não existe!");
        }

        Usuario usuario = usuarioService.buscar(morador.getUsuario().getEmail());

        if(Objects.isNull(morador.getCondominio())) {
            Condominio condominio = condominioService.buscar(morador.getCnpj());
            morador.setCondominio(condominio);
        }

        morador.setCpf(cpf);
        morador.setUsuario(usuario);
        moradorRepository.saveAndFlush(morador);
    }

    public Morador buscar(Long cnpj) throws BusinessException {
        return moradorRepository.findById(cnpj).orElseThrow(() -> new BusinessException("Morador não encontrado!"));
    }

    @Transactional
    public void usarPonto(Long cpf, Morador morador) throws BusinessException {
        if(morador.getPontoUsado() == null || morador.getPontoUsado() == 0){
            throw new BusinessException("Valor usado não pode ser zerado!");
        }

        Integer pontuacaoAtual = buscar(cpf).getPontuacao();

        if(pontuacaoAtual == null || morador.getPontoUsado() > pontuacaoAtual) {
            throw new BusinessException("Morador não tem pontos o suficiente para ser usado.");
        }

        morador.setPontuacao(morador.getPontuacao() - morador.getPontoUsado());
        moradorRepository.saveAndFlush(morador);

        HistoricoPontoColeta historicoPontoColeta = new HistoricoPontoColeta();
        historicoPontoColeta.setMorador(morador);
        historicoPontoColeta.setStatus(PontoStatus.USADO);
        historicoPontoColeta.setPontuacao(morador.getPontoUsado());

        historicoPontoColetaRepository.saveAndFlush(historicoPontoColeta);
    }

    public List<HistoricoPontoColeta> historicoPontoColeta(Long cpf, PontoStatus pontoStatus) {
        Morador morador = new Morador();
        morador.setCpf(cpf);

        return historicoPontoColetaRepository.findByMoradorAndStatus(morador, pontoStatus);
    }

}