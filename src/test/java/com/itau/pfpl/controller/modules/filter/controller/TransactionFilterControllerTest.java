package com.itau.pfpl.controller.modules.filter.controller;

import com.google.gson.Gson;
import com.itau.pfpl.controller.modules.filter.model.KafkaTransactionModel;
import com.itau.pfpl.controller.modules.filter.model.ResponseStatus;
import com.itau.pfpl.controller.modules.filter.service.TransactionFilterServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionFilterController.class)
public class TransactionFilterControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TransactionFilterServiceImpl transactionFilterService;

  private KafkaTransactionModel kafkaTransactionModel;

  @Before
  public void setUpTests() {
    kafkaTransactionModel = KafkaTransactionModel.builder()
      .cpf("111.111.111-11")
      .channelDescription("Online")
      .channelId("1C")
      .productDescription("Boleto")
      .productId("1P")
      .transactionDescription("Compra online com cartao de credito")
      .transactionId("431441")
      .city("Sao Paulo")
      .country("Brasil")
      .value("300")
      .build();
  }

  @Test
  public void testGivenKafkaTransactionModel_ReturnResponseStatusJson() throws Exception {
    ResponseStatus responseStatus = new ResponseStatus("Success");
    Gson gson = new Gson();

    given(this.transactionFilterService.validateTransaction(Mockito.any())).willReturn(responseStatus);

    this.mockMvc.perform(post("/send-transactions")
      .contentType(MediaType.APPLICATION_JSON)
      .content(gson.toJson(kafkaTransactionModel))
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().json(gson.toJson(responseStatus)));
  }
}