package com.geocode.octowallet.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * InstallmentExpense
 */
@Entity
public class InstallmentExpense extends Expense {

  private static final long serialVersionUID = 1L;

  private LocalDate date;
  private Integer numberOfInstallments;

  @OneToMany(mappedBy = "expense")
  @JsonManagedReference
  private List<Installment> installments = new ArrayList<>();

  public InstallmentExpense() {
  }

  public InstallmentExpense(Long id, String description, BigDecimal value, LocalDate date,
      Integer numberOfInstallments) {
    super(id, description, value);
    this.date = date;
    this.numberOfInstallments = numberOfInstallments;

    installments = generateExpenseInstallments();
  }

  public List<Installment> generateExpenseInstallments() {
    BigDecimal installmentValue = super.getValue().divide(new BigDecimal(numberOfInstallments));
    for (int i = 1; i <= numberOfInstallments; i++) {
      LocalDate nextDate = date.plusMonths(i);
      installments.add(new Installment(null, installmentValue, false, nextDate, this));
    }
    return installments;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Integer getNumberOfInstallments() {
    return numberOfInstallments;
  }

  public void setNumberOfInstallments(Integer numberOfInstallments) {
    this.numberOfInstallments = numberOfInstallments;
  }

  public List<Installment> getInstallments() {
    return installments;
  }

  public void setInstallments(List<Installment> installments) {
    this.installments = installments;
  }

}
