package com.geocode.octowallet.repositories;

import com.geocode.octowallet.entities.Expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ExpenseRepository
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
