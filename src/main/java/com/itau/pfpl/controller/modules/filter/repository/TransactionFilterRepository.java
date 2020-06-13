package com.itau.pfpl.controller.modules.filter.repository;

import com.itau.pfpl.controller.modules.filter.model.KafkaTransactionModel;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionFilterRepository {

  public KafkaTransactionModel getRulesOnDb() {
    return new KafkaTransactionModel("500000000");
  }
}
