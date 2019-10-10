package br.com.notrash.notrash.service;

import br.com.notrash.notrash.entity.Condominio;
import br.com.notrash.notrash.exception.BusinessException;
import br.com.notrash.notrash.repository.CondominioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CondominioService {

    private final UsuarioService usuarioService;
    private final CondominioRepository condominioRepository;

    public CondominioService(UsuarioService usuarioService,
                             CondominioRepository condominioRepository) {
        this.usuarioService = usuarioService;
        this.condominioRepository = condominioRepository;
    }

    @Transactional
    public void salvar(Condominio condominio) throws BusinessException {
        if(condominioRepository.existsById(condominio.getCnpj())) {
            throw new BusinessException("Condominio já existe!");
        }

        condominio.setUsuario(this.usuarioService.buscar(condominio.getUsuario().getEmail()));
        condominioRepository.saveAndFlush(condominio);
    }

    @Transactional
    public void alterar(Long cnpj, Condominio condominio) throws BusinessException {
        if(!condominioRepository.existsById(cnpj)) {
            throw new BusinessException("Condominio não existe!");
        }

        condominio.setCnpj(cnpj);
        condominio.setUsuario(this.usuarioService.buscar(condominio.getUsuario().getEmail()));
        condominioRepository.saveAndFlush(condominio);
    }

    public Condominio buscar(Long cnpj) throws BusinessException {
        return condominioRepository.findById(cnpj).orElseThrow(() -> new BusinessException("Condominio não encontrado!"));
    }

}
