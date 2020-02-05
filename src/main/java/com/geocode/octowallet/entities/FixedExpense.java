package com.geocode.octowallet.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * FixedExpense
 */
@Entity
public class FixedExpense extends Expense {

  private static final long serialVersionUID = 1L;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dueDate;

  public FixedExpense() {
  }

  public FixedExpense(Long id, String description, Double value, LocalDate dueDate) {
    super(id, description, value);
    this.dueDate = dueDate;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

}
