package com.geocode.octowallet.resources;

import java.net.URI;
import java.util.List;

import com.geocode.octowallet.entities.FixedExpense;
import com.geocode.octowallet.services.FixedExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PutMapping;


/**
 * InstallmentResource
 */
@RestController
@RequestMapping(value = "/fixedexpenses")
public class FixedExpenseResource {

  private FixedExpenseService service;

  @Autowired
  public FixedExpenseResource(FixedExpenseService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<FixedExpense>> findAll() {
    List<FixedExpense> expenses = service.findAll();
    return ResponseEntity.ok().body(expenses);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<FixedExpense> findById(@PathVariable Long id) {
    FixedExpense expense = service.findById(id);
    return ResponseEntity.ok().body(expense);
  }

  @PostMapping
  public ResponseEntity<FixedExpense> save(@RequestBody FixedExpense entity) {
    FixedExpense fixedExpense = service.save(entity);

    URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(fixedExpense.getId())
        .toUri();

    return ResponseEntity.created(uri).body(fixedExpense);
  }

  @PutMapping(value="/{id}")
  public ResponseEntity<FixedExpense> update(@PathVariable Long id, @RequestBody FixedExpense entity) {
      
    FixedExpense updatedEntity = service.update(id, entity);
      
    return ResponseEntity.ok().body(updatedEntity);
  }

}
