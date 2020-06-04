package com.geocode.octowallet.resources;

import java.net.URI;
import java.util.List;

import com.geocode.octowallet.entities.CasualExpense;
import com.geocode.octowallet.services.CasualExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * CasualExpenseResource
 */
@RestController
@RequestMapping(value = "/casualexpenses")
public class CasualExpenseResource {

  private CasualExpenseService service;

  @Autowired
  public CasualExpenseResource(CasualExpenseService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<CasualExpense>> findAll() {
    List<CasualExpense> expenses = service.findAll();
    return ResponseEntity.ok().body(expenses);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CasualExpense> findById(@PathVariable Long id) {
    CasualExpense expense = service.findById(id);
    return ResponseEntity.ok().body(expense);
  }

  @PostMapping
  public ResponseEntity<CasualExpense> save(@RequestBody CasualExpense entity) {
    CasualExpense casualExpense = service.save(entity);

    URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(casualExpense.getId())
        .toUri();

    return ResponseEntity.created(uri).body(casualExpense);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CasualExpense> update(@PathVariable Long id, @RequestBody CasualExpense entity) {

    CasualExpense updatedEntity = service.update(id, entity);

    return ResponseEntity.ok().body(updatedEntity);
  }

}
