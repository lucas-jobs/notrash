
package br.com.notrash.notrash.service;

import org.springframework.stereotype.Service;

import br.com.notrash.notrash.repository.CondominioRepository;

@Service
public class CondominioService {

  private final CondominioRepository condominioRepository;

  public CondominioService(CondominioRepository condominioRepository) {
    this.condominioRepository = condominioRepository;
  }

  public void cadastrar() {
  }

}
