package com.geocode.octowallet.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * FixedExpense
 */
@Entity
public class FixedExpense extends Expense {

  private static final long serialVersionUID = 1L;

  private LocalDate dueDate;
  private boolean active;

  public FixedExpense() {
  }

  public FixedExpense(Long id, String description, BigDecimal value, LocalDate dueDate, boolean active) {
    super(id, description, value);
    this.dueDate = dueDate;
    this.active = active;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

}
