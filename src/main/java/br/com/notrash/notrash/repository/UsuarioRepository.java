package br.com.notrash.notrash.repository;

import br.com.notrash.notrash.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> { }
