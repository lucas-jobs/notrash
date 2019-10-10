package br.com.notrash.notrash.controller;

import br.com.notrash.notrash.entity.Usuario;
import br.com.notrash.notrash.exception.BusinessException;
import br.com.notrash.notrash.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void salvar(@RequestBody Usuario usuario) throws BusinessException {
        usuarioService.salvar(usuario);
    }

}
