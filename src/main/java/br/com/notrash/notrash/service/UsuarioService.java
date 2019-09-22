package br.com.notrash.notrash.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.notrash.notrash.entity.Usuario;
import br.com.notrash.notrash.repository.UsuarioRepository;

@Service
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;

  @Autowired
  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public void cadastrar(Usuario usuario) {
    this.usuarioRepository.save(usuario);
  }

  public void editar(Long id, Usuario usuario) {
    usuario.setId(id);
    this.usuarioRepository.save(usuario);
  }

  public Optional<Usuario> buscar(Long id) {
    return this.usuarioRepository.findById(id);
  }
}
