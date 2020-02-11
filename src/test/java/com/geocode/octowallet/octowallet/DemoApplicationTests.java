package com.geocode.octowallet.octowallet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.geocode.octowallet.entities.CasualExpense;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		List<CasualExpense> casualExpenses = new ArrayList<>();
		CasualExpense ce1 = new CasualExpense(1L, "Fonte 600w", new BigDecimal("400.0"), LocalDate.of(2020, 2, 1));
		CasualExpense ce2 = new CasualExpense(2L, "God of War", new BigDecimal("69.0"), LocalDate.of(2019, 12, 13));
		casualExpenses.addAll(Arrays.asList(ce1, ce2));
	}

}
