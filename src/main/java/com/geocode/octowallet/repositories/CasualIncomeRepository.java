package com.geocode.octowallet.repositories;

import com.geocode.octowallet.entities.CasualIncome;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CasualIncomeRepository
 */
@Repository
public interface CasualIncomeRepository extends JpaRepository<CasualIncome, Long> {

}
