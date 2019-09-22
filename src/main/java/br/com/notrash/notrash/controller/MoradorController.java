package br.com.notrash.notrash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.notrash.notrash.entity.Morador;
import br.com.notrash.notrash.service.MoradorService;

@RestController
@RequestMapping("/resident")
public class MoradorController {

  private final MoradorService moradorService;

  @Autowired
  public MoradorController(MoradorService moradorService) {
    this.moradorService = moradorService;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> find(@PathVariable Long id) {
    return null;

  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public ResponseEntity<?> search() {
    return null;
  }

  @RequestMapping(method = RequestMethod.POST)
  public void save(@RequestBody Morador morador) {

  }

  @RequestMapping(method = RequestMethod.PUT)
  public void update(@PathVariable Long id, @RequestBody Morador morador) {

  }
}
