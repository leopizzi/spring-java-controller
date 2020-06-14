package com.itau.pfpl.controller.modules.filter.service;

import com.itau.pfpl.controller.modules.filter.model.KafkaTransactionModel;
import com.itau.pfpl.controller.modules.filter.model.ProductIdRuleDB;
import com.itau.pfpl.controller.modules.filter.model.ResponseStatus;
import com.itau.pfpl.controller.modules.filter.repository.TransactionFilterRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class TransactionFilterServiceImplTest {

  @Mock
  private TransactionFilterRepository transactionFilterRepository;

  @InjectMocks
  private TransactionFilterServiceImpl transactionFilterService;

  @Before
  public void setUp() {
    initMocks(this);
  }

  @Test
  public void testValidateTransactionFilterService_whenTransactionIsAccepted() {

    ProductIdRuleDB productIdRuleDB = new ProductIdRuleDB(1, "2P");
    Iterable<ProductIdRuleDB> productIdRules = Arrays.asList(productIdRuleDB);
    Mockito.when(this.transactionFilterRepository.findAll())
      .thenReturn(productIdRules);

    String messageExpected = "Transaction accepted";

    KafkaTransactionModel kafkaTransactionModel = KafkaTransactionModel.builder()
      .cpf("111.111.111-11")
      .channelDescription("Online")
      .channelId("1C")
      .productDescription("Boleto")
      .productId("2P")
      .transactionDescription("Compra online com cartao de credito")
      .transactionId("431441")
      .city("Sao Paulo")
      .country("Brasil")
      .value("300")
      .build();
    ResponseStatus responseStatus = transactionFilterService.validateTransaction(kafkaTransactionModel);

    Assert.assertEquals("Assert that status is Ok", messageExpected, responseStatus.getStatus());
  }

  @Test
  public void testValidateTransactionFilterService_whenTransactionIsNOTAccepted() {

    ProductIdRuleDB productIdRuleDB = new ProductIdRuleDB(1, "2P");
    Iterable<ProductIdRuleDB> productIdRules = Arrays.asList(productIdRuleDB);
    Mockito.when(this.transactionFilterRepository.findAll())
      .thenReturn(productIdRules);

    String messageExpected = "Transaction discarded";

    KafkaTransactionModel kafkaTransactionModel = KafkaTransactionModel.builder()
      .cpf("111.111.111-11")
      .channelDescription("Online")
      .channelId("1C")
      .productDescription("Boleto")
      .productId("3P")
      .transactionDescription("Compra online com cartao de credito")
      .transactionId("431441")
      .city("Sao Paulo")
      .country("Brasil")
      .value("300")
      .build();
    ResponseStatus responseStatus = transactionFilterService.validateTransaction(kafkaTransactionModel);

    Assert.assertEquals("Assert that status is NOT Ok", messageExpected, responseStatus.getStatus());
  }


}