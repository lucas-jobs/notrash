package br.com.notrash.notrash.repository;

import br.com.notrash.notrash.entity.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
}
