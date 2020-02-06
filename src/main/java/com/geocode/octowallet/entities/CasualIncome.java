package com.geocode.octowallet.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * CasualIncome
 */
@Entity
public class CasualIncome extends Income {

  private static final long serialVersionUID = 1L;

  public CasualIncome() {
  }

  public CasualIncome(Long id, String description, BigDecimal value, LocalDate date) {
    super(id, description, value, date);
  }

}
