package com.geocode.octowallet.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.geocode.octowallet.entities.CasualExpense;
import com.geocode.octowallet.repositories.CasualExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CasualExpenseService
 */
@Service
public class CasualExpenseService {

  private CasualExpenseRepository repository;

  @Autowired
  public CasualExpenseService(CasualExpenseRepository repository) {
    this.repository = repository;
  }

  public List<CasualExpense> findAll() {
    return repository.findAll();
  }

  public CasualExpense findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Entidade CasualExpense não foi encontrada."));
  }

  public CasualExpense save(CasualExpense entity) {
    return repository.save(entity);
  }

}
