package br.com.notrash.notrash.service;

import br.com.notrash.notrash.entity.Usuario;
import br.com.notrash.notrash.exception.BusinessException;
import br.com.notrash.notrash.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public void salvar(Usuario usuario) throws BusinessException {
        if(usuarioRepository.existsById(usuario.getEmail()))
            throw new BusinessException("Usuário informado já existe!");

        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario buscar(String email) throws BusinessException {
        return usuarioRepository.findById(email).orElseThrow(() -> new BusinessException("Usuário não encontrado!"));
    }

}
