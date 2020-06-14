package com.itau.pfpl.controller.modules.filter.repository;

import com.itau.pfpl.controller.modules.filter.model.ProductIdRuleDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Class responsible for retrieving information from database
 */
@Repository
public interface TransactionFilterRepository extends CrudRepository<ProductIdRuleDB, Integer> {}
