package com.geocode.octowallet.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.geocode.octowallet.entities.CasualExpense;
import com.geocode.octowallet.entities.CasualIncome;
import com.geocode.octowallet.entities.FixedExpense;
import com.geocode.octowallet.entities.FixedIncome;
import com.geocode.octowallet.entities.Installment;
import com.geocode.octowallet.entities.InstallmentExpense;
import com.geocode.octowallet.repositories.CasualExpenseRepository;
import com.geocode.octowallet.repositories.FixedExpenseRepository;
import com.geocode.octowallet.repositories.IncomeRepository;
import com.geocode.octowallet.repositories.InstallmentExpenseRepository;
import com.geocode.octowallet.repositories.InstallmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

  private CasualExpenseRepository casualExpenseRepository;
  private FixedExpenseRepository fixedExpenseRepository;
  private InstallmentExpenseRepository instExpenseRepository;
  private IncomeRepository incomeRepository;
  private InstallmentRepository installmentRepository;

  @Autowired
  public TestConfig(CasualExpenseRepository casualExpenseRepository, IncomeRepository incomeRepository,
      InstallmentExpenseRepository instExpenseRepository, InstallmentRepository installmentRepository,
      FixedExpenseRepository fixedExpenseRepository) {
    this.casualExpenseRepository = casualExpenseRepository;
    this.incomeRepository = incomeRepository;
    this.installmentRepository = installmentRepository;
    this.fixedExpenseRepository = fixedExpenseRepository;
    this.instExpenseRepository = instExpenseRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    CasualExpense caExp1 = new CasualExpense(null, "Fonte 600w", new BigDecimal("400.0"), LocalDate.of(2020, 2, 1));
    CasualExpense caExp2 = new CasualExpense(null, "God of War", new BigDecimal("69.0"), LocalDate.of(2019, 12, 13));
    CasualExpense caExp3 = new CasualExpense(null, "Alcool Gel", new BigDecimal("23.90"), LocalDate.of(2020, 3, 29));

    casualExpenseRepository.saveAll(Arrays.asList(caExp1, caExp2, caExp3));

    FixedExpense fixExp1 = new FixedExpense(null, "Netflix", new BigDecimal("35.90"), LocalDate.of(2018, 6, 10), true);
    FixedExpense fixExp2 = new FixedExpense(null, "Amazon Prime", new BigDecimal("9.90"), LocalDate.of(2020, 1, 6),
        true);

    fixedExpenseRepository.saveAll(Arrays.asList(fixExp1, fixExp2));

    CasualIncome casInc1 = new CasualIncome(null, "Venda teclado", new BigDecimal("400.0"), LocalDate.of(2020, 2, 4));
    FixedIncome fixInc1 = new FixedIncome(null, "Aluguel", new BigDecimal("1530.0"), LocalDate.of(2020, 1, 14), true);

    incomeRepository.saveAll(Arrays.asList(casInc1));
    incomeRepository.saveAll(Arrays.asList(fixInc1));

    InstallmentExpense instExp = new InstallmentExpense(null, "Teclado mecanico", new BigDecimal("454.84"),
        LocalDate.of(2020, 6, 1), 10);
    instExpenseRepository.saveAll(Arrays.asList(instExp));

    installmentRepository.saveAll(instExp.getInstallments());

  }
}
