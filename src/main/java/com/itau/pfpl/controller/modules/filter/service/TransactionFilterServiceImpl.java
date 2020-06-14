package com.itau.pfpl.controller.modules.filter.service;

import com.itau.pfpl.controller.modules.filter.model.KafkaTransactionModel;
import com.itau.pfpl.controller.modules.filter.model.ProductIdRuleDB;
import com.itau.pfpl.controller.modules.filter.model.ResponseStatus;
import com.itau.pfpl.controller.modules.filter.repository.TransactionFilterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TransactionFilterServiceImpl implements TransactionFilterService {

  @Autowired
  private TransactionFilterRepository transactionFilterRepository;

  public ResponseStatus validateTransaction(KafkaTransactionModel kafkaTransactionModel) {
    Iterable<ProductIdRuleDB> productIdRules = transactionFilterRepository.findAll();
    ResponseStatus responseStatus = new ResponseStatus();

    productIdRules.forEach(p -> {
      if (kafkaTransactionModel.getProductId().contains(p.getProductIdRule())) {
        log.info("Transaction accepted - sending to integrator");
        responseStatus.setStatus("Transaction accepted");
      } else {
        log.info("Transaction not accepted - discarding");
        responseStatus.setStatus("Transaction discarded");
      }
    });
    return responseStatus;
  }
}
