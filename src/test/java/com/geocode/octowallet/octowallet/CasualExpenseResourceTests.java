package com.geocode.octowallet.octowallet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Arrays;

import com.geocode.octowallet.resources.CasualExpenseResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    mockMvc = standaloneSetup(casualExpenseResource).build();
  }

  @Test
  void getAllCasualExpenseTest() throws Exception {

    mockMvc.perform(get("/casualexpenses")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].description", is("Fonte 600w")))
        .andExpect(jsonPath("$[0].value", is(400.0)))
        .andExpect(jsonPath("$[0].date", is(Arrays.asList(2020, 2, 1))))
        .andExpect(jsonPath("$[1].id", is(2)))
        .andExpect(jsonPath("$[1].description", is("God of War")))
        .andExpect(jsonPath("$[1].value", is(69.0)))
        .andExpect(jsonPath("$[1].date", is(Arrays.asList(2019, 12, 13))));
  }

  @Test
  void getCasualExpenseByIdTest() throws Exception {

    mockMvc.perform(get("/casualexpenses/1")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.description", is("Fonte 600w")))
        .andExpect(jsonPath("$.value", is(400.0)))
        .andExpect(jsonPath("$.date", is(Arrays.asList(2020, 2, 1))));
  }

  @Disabled
  @Test
  void postCasualExpenseTest() throws Exception {
    //TODO Implementar teste de post
  }

}
