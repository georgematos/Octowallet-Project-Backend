package com.geocode.octowallet.repositories;

import com.geocode.octowallet.entities.InstallmentExpense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * InstallmentExpenseRepository
 */
@Repository
public interface InstallmentExpenseRepository extends JpaRepository<InstallmentExpense, Long> {

}
