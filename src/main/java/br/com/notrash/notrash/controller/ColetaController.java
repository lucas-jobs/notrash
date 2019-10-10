package br.com.notrash.notrash.controller;


import br.com.notrash.notrash.entity.Coleta;
import br.com.notrash.notrash.exception.BusinessException;
import br.com.notrash.notrash.service.ColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/coleta")
public class ColetaController {

    private final ColetaService coletaService;

    @Autowired
    public ColetaController(ColetaService coletaService) {
        this.coletaService = coletaService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Coleta coleta) throws BusinessException {
        coletaService.salvar(coleta);
    }

}
