package com.itau.pfpl.controller.modules.filter.controller;

import com.itau.pfpl.controller.modules.filter.model.KafkaTransactionModel;
import com.itau.pfpl.controller.modules.filter.model.ResponseStatus;
import com.itau.pfpl.controller.modules.filter.service.TransactionFilterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Controller Class responsible for intercept incoming requests and
 * send the data for further processing
 */
@RestController
public class TransactionFilterController {

  @Autowired
  private TransactionFilterServiceImpl transactionFilterServiceImpl;

  /**
   * @param kafkaTransactionModel Kafka model
   * @return ResponseEntity
   * <p>
   * Method used to send post requests with a kafka like Json
   */
  @PostMapping(path = "/send-transactions", consumes = "application/json", produces = "application/json")
  public ResponseEntity<ResponseStatus> getKafkaTransactions(@RequestBody KafkaTransactionModel kafkaTransactionModel) {
    return ResponseEntity.ok(transactionFilterServiceImpl.validateTransaction(kafkaTransactionModel));
  }
}
