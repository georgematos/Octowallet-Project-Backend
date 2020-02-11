package com.geocode.octowallet.repositories;

import com.geocode.octowallet.entities.CasualExpense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CasualExpenseRepository
 */

@Repository
public interface CasualExpenseRepository extends JpaRepository<CasualExpense, Long> {
}
