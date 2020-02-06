package com.geocode.octowallet.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * FixedIncome
 */
@Entity
public class FixedIncome extends Income {

  private static final long serialVersionUID = 1L;

  private boolean active;

  public FixedIncome() {
  }

  public FixedIncome(Long id, String description, BigDecimal value, LocalDate date, boolean active) {
    super(id, description, value, date);
    this.active = active;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

}
