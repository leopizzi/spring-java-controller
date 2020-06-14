package com.itau.pfpl.controller.modules.filter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ProductIdRuleDB {
  @Column(name = "id")
  @Id
  private Integer id;

  @Column(name = "productIdRule")
  private String productIdRule;
}

