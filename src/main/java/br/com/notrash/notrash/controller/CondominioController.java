package br.com.notrash.notrash.controller;

import br.com.notrash.notrash.entity.Condominio;
import br.com.notrash.notrash.entity.Usuario;
import br.com.notrash.notrash.exception.BusinessException;
import br.com.notrash.notrash.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/condominio")
public class CondominioController {

    private final CondominioService condominioService;

    @Autowired
    public CondominioController(CondominioService condominioService) {
        this.condominioService = condominioService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void salvar(@RequestBody Condominio condominio,
                       @RequestHeader("X-USER-ID") String email) throws BusinessException {

        condominio.setUsuario(new Usuario(email));
        condominioService.salvar(condominio);
    }

    @PutMapping("/{cnpj}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void alterar(@PathVariable Long cnpj,
                        @RequestBody Condominio condominio,
                        @RequestHeader("X-USER-ID") String email) throws BusinessException {

        condominio.setCnpj(cnpj);
        condominio.setUsuario(new Usuario(email));
        condominioService.alterar(cnpj, condominio);
    }

    @GetMapping(value = "/{cnpj}")
    public ResponseEntity<?> buscar(@PathVariable Long cnpj) throws BusinessException {
        return Optional.ofNullable(condominioService.buscar(cnpj))
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
