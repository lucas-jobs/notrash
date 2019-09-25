package br.com.notrash.notrash.controller;

import br.com.notrash.notrash.entity.Usuario;
import br.com.notrash.notrash.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        return null;

    }

    @RequestMapping(method = RequestMethod.POST)
    public void cadastrar(@RequestBody Usuario usuario) {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void alterar(@PathVariable Long id, @RequestBody Usuario usuario) {

    }
}
