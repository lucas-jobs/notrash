package br.com.notrash.notrash.controller;


import br.com.notrash.notrash.entity.Morador;
import br.com.notrash.notrash.entity.Usuario;
import br.com.notrash.notrash.enumation.PontoStatus;
import br.com.notrash.notrash.exception.BusinessException;
import br.com.notrash.notrash.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/morador")
public class MoradorController {

    private final MoradorService moradorService;

    @Autowired
    public MoradorController(MoradorService moradorService) {
        this.moradorService = moradorService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Morador morador,
                       @RequestHeader("X-USER-ID") String email) throws BusinessException {

        morador.setUsuario(new Usuario(email));
        moradorService.salvar(morador);
    }

    @PutMapping("/{cpf}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void alterar(@PathVariable Long cpf,
                        @RequestBody Morador morador,
                        @RequestHeader("X-USER-ID") String email) throws BusinessException {

        morador.setUsuario(new Usuario(email));
        moradorService.alterar(cpf, morador);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> buscar(@PathVariable Long cpf) throws BusinessException {
        return Optional.ofNullable(moradorService.buscar(cpf))
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{cpf}/usar-ponto")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void usarPonto(@PathVariable Long cpf,
                          @RequestBody Morador morador,
                          @RequestHeader("X-USER-ID") String email) throws BusinessException {

        morador.setUsuario(new Usuario(email));
        moradorService.usarPonto(cpf, morador);
    }

    @GetMapping("/{cpf}/coletas")
    public ResponseEntity<?> moradorColetas(@PathVariable Long cpf,
                                            @RequestParam PontoStatus status) {

        return Optional.ofNullable(moradorService.historicoPontoColeta(cpf, status))
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
