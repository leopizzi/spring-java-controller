package com.itau.pfpl.controller.modules.filter.service;

import com.itau.pfpl.controller.modules.filter.model.KafkaTransactionModel;
import com.itau.pfpl.controller.modules.filter.model.ResponseStatus;

/**
 * A Service Class responsible for processing data
 * based on business rules
 */
public interface TransactionFilterService {

  /**
   * @param kafkaTransactionModel Kafka model
   * @return kafkaTransactionModel
   * Validate and filter based on transaction information
   */
  ResponseStatus validateTransaction(KafkaTransactionModel kafkaTransactionModel);
}
