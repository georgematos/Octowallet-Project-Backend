package com.geocode.octowallet.octowallet;

import com.geocode.octowallet.resources.CasualExpenseResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * CasualExpenseResourceTests
 */
public class CasualExpenseResourceTests extends DemoApplicationTests {

  private MockMvc mockMvc;

  @Autowired
  private CasualExpenseResource casualExpenseResource;

  @BeforeEach
  public void setup() {
    System.out.println("BeforeAll called");
    mockMvc = MockMvcBuilders.standaloneSetup(casualExpenseResource).build();
  }

  @Test
  void findAllTest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/casualexpenses")).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testPost() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/casualexpenses"))
        .andExpect(MockMvcResultMatchers.model().attributeExists("descricao", "value", "date"))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }
}
