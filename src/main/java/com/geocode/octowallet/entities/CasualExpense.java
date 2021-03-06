package com.geocode.octowallet.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * CasualExpense
 */
@Entity
public class CasualExpense extends Expense {

  private static final long serialVersionUID = 1L;

  private LocalDate date;

  public CasualExpense() {
  }

  public CasualExpense(Long id, String description, BigDecimal value, LocalDate date) {
    super(id, description, value);
    this.date = date;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

}
