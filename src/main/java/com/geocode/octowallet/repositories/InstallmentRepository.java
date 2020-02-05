package com.geocode.octowallet.repositories;

import com.geocode.octowallet.entities.Installment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * InstallmentRepository
 */
@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {

}
