package br.com.notrash.notrash.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.notrash.notrash.entity.Condominio;

@Repository
public interface CondominioRepository extends CrudRepository<Condominio, Long> {
}
