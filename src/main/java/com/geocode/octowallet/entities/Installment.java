package com.geocode.octowallet.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Installment
 */
@Entity
public class Installment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Double value;
  private boolean paid = false;
  private LocalDate dueDate;

  @ManyToOne
  @JoinColumn(name = "expense_id")
  @JsonBackReference
  private InstallmentExpense expense;

  public Installment() {
  }

  public Installment(Long id, Double value, boolean paid, LocalDate dueDate, InstallmentExpense expense) {
    this.id = id;
    this.value = value;
    this.paid = paid;
    this.dueDate = dueDate;
    this.expense = expense;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public boolean isPaid() {
    return paid;
  }

  public void setPaid(boolean paid) {
    this.paid = paid;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public InstallmentExpense getExpense() {
    return expense;
  }

  public void setExpense(InstallmentExpense expense) {
    this.expense = expense;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Installment other = (Installment) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
