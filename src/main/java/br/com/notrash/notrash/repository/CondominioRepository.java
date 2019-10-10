package br.com.notrash.notrash.repository;

import br.com.notrash.notrash.entity.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {
}
