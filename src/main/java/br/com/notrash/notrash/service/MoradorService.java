
package br.com.notrash.notrash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.notrash.notrash.entity.Morador;
import br.com.notrash.notrash.repository.MoradorRepository;

@Service
public class MoradorService {

  private final MoradorRepository moradorRepository;

  @Autowired
  public MoradorService(MoradorRepository moradorRepository) {
    this.moradorRepository = moradorRepository;
  }

  @Transactional
  public void cadastrar(Morador morador) {
    this.moradorRepository.save(morador);
  }

  @Transactional
  public void editar(Long id, Morador morador) {
    morador.setId(id);
    this.moradorRepository.save(morador);
  }

}
