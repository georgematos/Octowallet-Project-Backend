package com.geocode.octowallet.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.geocode.octowallet.entities.CasualExpense;
import com.geocode.octowallet.entities.CasualIncome;
import com.geocode.octowallet.entities.FixedExpense;
import com.geocode.octowallet.entities.FixedIncome;
import com.geocode.octowallet.entities.Installment;
import com.geocode.octowallet.entities.InstallmentExpense;
import com.geocode.octowallet.repositories.ExpenseRepository;
import com.geocode.octowallet.repositories.IncomeRepository;
import com.geocode.octowallet.repositories.InstallmentExpenseRepository;
import com.geocode.octowallet.repositories.InstallmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  // repostiorios como atributos
  private ExpenseRepository expenseRepository;
  private IncomeRepository incomeRepository;
  private InstallmentRepository installmentRepository;
  private InstallmentExpenseRepository instExpenseRepository;

  @Autowired
  public TestConfig(ExpenseRepository expenseRepository, IncomeRepository incomeRepository,
      InstallmentExpenseRepository instExpenseRepository, InstallmentRepository installmentRepository) {
    // injeção dos repositorios
    this.expenseRepository = expenseRepository;
    this.incomeRepository = incomeRepository;
    this.instExpenseRepository = instExpenseRepository;
    this.installmentRepository = installmentRepository;

  }

  @Override
  public void run(String... args) throws Exception {
    // instancias e persistencias
    CasualExpense caExp1 = new CasualExpense(null, "Fonte 600w", 400.0, LocalDate.of(2020, 2, 1));
    CasualExpense caExp2 = new CasualExpense(null, "God of War", 69.0, LocalDate.of(2019, 12, 13));

    expenseRepository.saveAll(Arrays.asList(caExp1, caExp2));

    FixedExpense fixExp1 = new FixedExpense(null, "Netflix", 35.90, LocalDate.of(2018, 6, 10), true);
    FixedExpense fixExp2 = new FixedExpense(null, "Amazon Prime", 9.90, LocalDate.of(2020, 1, 6), true);

    expenseRepository.saveAll(Arrays.asList(fixExp1, fixExp2));

    CasualIncome casInc1 = new CasualIncome(null, "Venda teclado", 400.0, LocalDate.of(2020, 2, 4));
    FixedIncome fixInc1 = new FixedIncome(null, "Aluguel", 1530.0, LocalDate.of(2020, 1, 14), true);

    incomeRepository.saveAll(Arrays.asList(casInc1));
    incomeRepository.saveAll(Arrays.asList(fixInc1));

    InstallmentExpense instExp = new InstallmentExpense(null, "Teclado mecanico", 454.84, LocalDate.of(2020, 6, 1), 10);
    instExpenseRepository.saveAll(Arrays.asList(instExp));

    List<Installment> installments = instExp.generateExpenseInstallments();

    installmentRepository.saveAll(installments);

    instExp.getInstallments().addAll(installments);

    instExpenseRepository.saveAll(Arrays.asList(instExp));
  }
}
