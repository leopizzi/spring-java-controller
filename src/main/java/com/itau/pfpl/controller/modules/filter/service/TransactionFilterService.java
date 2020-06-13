package com.itau.pfpl.controller.modules.filter.service;

import com.itau.pfpl.controller.modules.filter.model.KafkaTransactionModel;
import com.itau.pfpl.controller.modules.filter.repository.TransactionFilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionFilterService {

  @Autowired
  private TransactionFilterRepository transactionFilterRepository;

  public KafkaTransactionModel validateTransaction() {
    return transactionFilterRepository.getRulesOnDb();
  }
}
