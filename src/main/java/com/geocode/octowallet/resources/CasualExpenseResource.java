package com.geocode.octowallet.resources;

import java.util.List;

import com.geocode.octowallet.entities.CasualExpense;
import com.geocode.octowallet.services.CasualExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * InstallmentResource
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

}
