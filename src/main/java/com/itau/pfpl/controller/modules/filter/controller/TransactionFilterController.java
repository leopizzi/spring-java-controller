package com.itau.pfpl.controller.modules.filter.controller;

import com.itau.pfpl.controller.modules.filter.model.KafkaTransaction;
import com.itau.pfpl.controller.modules.filter.service.TransactionFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionFilterController {

  @Autowired
  private TransactionFilterService transactionFilterService;

  @PostMapping(path = "/send-transactions", consumes = "application/json", produces = "application/json")
  public String getKafkaTransactions(@RequestBody KafkaTransaction kafkaTransaction) {
    return transactionFilterService.validateTransaction();
  }
}
