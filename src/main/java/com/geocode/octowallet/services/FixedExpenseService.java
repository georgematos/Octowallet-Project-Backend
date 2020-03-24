package com.geocode.octowallet.services;

import java.util.List;

import com.geocode.octowallet.entities.FixedExpense;
import com.geocode.octowallet.repositories.FixedExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FixedExpenseService
 */
@Service
public class FixedExpenseService {

  private FixedExpenseRepository repository;

  @Autowired
  public FixedExpenseService(FixedExpenseRepository repository) {
    this.repository = repository;
  }

  public List<FixedExpense> findAll() {
    return repository.findAll();
  }

  public FixedExpense findById(Long id) {
    return repository.findById(id).get();
  }

  public FixedExpense save(FixedExpense entity) {
    return repository.save(entity);
  }

}
