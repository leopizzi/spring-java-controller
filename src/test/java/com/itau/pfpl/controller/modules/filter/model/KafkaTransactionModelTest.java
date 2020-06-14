package com.itau.pfpl.controller.modules.filter.model;

import org.junit.Assert;
import org.junit.Test;

public class KafkaTransactionModelTest {

  @Test
  public void testConstructors() {
    KafkaTransactionModel kafkaTransactionModelConstructorWithParameters = new KafkaTransactionModel("cpf", "transactionId", "transactionDescription", "productId", "productDescription", "channelId", "channelDescription", "city", "country", "value");
    KafkaTransactionModel kafkaTransactionModelWithoutParameters = new KafkaTransactionModel();


    Assert.assertNotNull("Assert that the object has parameters", kafkaTransactionModelConstructorWithParameters.getCpf());
    Assert.assertNull("Assert that the object has no parameters", kafkaTransactionModelWithoutParameters.getCpf());
  }

  @Test
  public void testGettersAndBuilder() {
    KafkaTransactionModel kafkaTransactionModel = KafkaTransactionModel.builder()
      .value("value")
      .transactionId("transactionId")
      .transactionDescription("transactionDescription")
      .productId("productId")
      .productDescription("productDescription")
      .country("country")
      .city("city")
      .channelId("channelId")
      .channelDescription("channelDescription")
      .cpf("cpf")
      .build();

    Assert.assertEquals("Assert getter value", "value", kafkaTransactionModel.getValue());
    Assert.assertEquals("Assert getter transactionId", "transactionId", kafkaTransactionModel.getTransactionId());
    Assert.assertEquals("Assert getter transactionDescription", "transactionDescription", kafkaTransactionModel.getTransactionDescription());
    Assert.assertEquals("Assert getter productId", "productId", kafkaTransactionModel.getProductId());
    Assert.assertEquals("Assert getter productDescription", "productDescription", kafkaTransactionModel.getProductDescription());
    Assert.assertEquals("Assert getter country", "country", kafkaTransactionModel.getCountry());
    Assert.assertEquals("Assert getter city", "city", kafkaTransactionModel.getCity());
    Assert.assertEquals("Assert getter channelId", "channelId", kafkaTransactionModel.getChannelId());
    Assert.assertEquals("Assert getter channelDescription", "channelDescription", kafkaTransactionModel.getChannelDescription());
    Assert.assertEquals("Assert getter cpf", "cpf", kafkaTransactionModel.getCpf());
  }

  @Test
  public void testSetters() {
    KafkaTransactionModel kafkaTransactionModel = new KafkaTransactionModel();

    kafkaTransactionModel.setValue("value");
    kafkaTransactionModel.setTransactionId("transactionId");
    kafkaTransactionModel.setTransactionDescription("transactionDescription");
    kafkaTransactionModel.setProductId("productId");
    kafkaTransactionModel.setProductDescription("productDescription");
    kafkaTransactionModel.setCountry("country");
    kafkaTransactionModel.setCity("city");
    kafkaTransactionModel.setChannelId("channelId");
    kafkaTransactionModel.setChannelDescription("channelDescription");
    kafkaTransactionModel.setCpf("cpf");

    Assert.assertEquals("Assert setter value", "value", kafkaTransactionModel.getValue());
    Assert.assertEquals("Assert setter transactionId", "transactionId", kafkaTransactionModel.getTransactionId());
    Assert.assertEquals("Assert setter transactionDescription", "transactionDescription", kafkaTransactionModel.getTransactionDescription());
    Assert.assertEquals("Assert setter productId", "productId", kafkaTransactionModel.getProductId());
    Assert.assertEquals("Assert setter productDescription", "productDescription", kafkaTransactionModel.getProductDescription());
    Assert.assertEquals("Assert setter country", "country", kafkaTransactionModel.getCountry());
    Assert.assertEquals("Assert setter city", "city", kafkaTransactionModel.getCity());
    Assert.assertEquals("Assert setter channelId", "channelId", kafkaTransactionModel.getChannelId());
    Assert.assertEquals("Assert setter channelDescription", "channelDescription", kafkaTransactionModel.getChannelDescription());
    Assert.assertEquals("Assert setter cpf", "cpf", kafkaTransactionModel.getCpf());
  }


}
