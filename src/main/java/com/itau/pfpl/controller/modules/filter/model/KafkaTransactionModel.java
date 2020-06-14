package com.itau.pfpl.controller.modules.filter.model;

import lombok.*;

/**
 * Model designed to reflect the kafka message
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class KafkaTransactionModel {
  private String cpf;
  private String transactionId;
  private String transactionDescription;
  private String productId;
  private String productDescription;
  private String channelId;
  private String channelDescription;
  private String city;
  private String country;
  private String value;
}
