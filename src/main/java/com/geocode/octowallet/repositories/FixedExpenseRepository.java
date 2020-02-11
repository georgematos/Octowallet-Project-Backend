package com.geocode.octowallet.repositories;

import com.geocode.octowallet.entities.FixedExpense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FixedExpenseRepository
 */

@Repository
public interface FixedExpenseRepository extends JpaRepository<FixedExpense, Long> {
}
