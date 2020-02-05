package com.geocode.octowallet.repositories;

import com.geocode.octowallet.entities.Income;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * IncomeRepository
 */
@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

}
