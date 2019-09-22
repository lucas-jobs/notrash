package br.com.notrash.notrash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.notrash.notrash.entity.Condominio;
import br.com.notrash.notrash.service.CondominioService;

@RestController
@RequestMapping("/condominum")
public class CondominioController {

  private final CondominioService condominioService;

  @Autowired
  public CondominioController(CondominioService condominioService) {
    this.condominioService = condominioService;
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
  public void save(@RequestBody Condominio condominio) {

  }

  @RequestMapping(method = RequestMethod.PUT)
  public void update(@PathVariable Long id, @RequestBody Condominio condominio) {

  }
}
