package com.itau.pfpl.controller.modules.filter.controller;

import com.itau.pfpl.controller.modules.filter.model.KafkaTransactionModel;
import com.itau.pfpl.controller.modules.filter.service.TransactionFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionFilterController {

  @Autowired
  private TransactionFilterService transactionFilterService;

  @PostMapping(path = "/send-transactions", consumes = "application/json", produces = "application/json")
  public ResponseEntity<KafkaTransactionModel> getKafkaTransactions(@RequestBody KafkaTransactionModel kafkaTransactionModel) {
    return ResponseEntity.ok(transactionFilterService.validateTransaction());
  }
}
