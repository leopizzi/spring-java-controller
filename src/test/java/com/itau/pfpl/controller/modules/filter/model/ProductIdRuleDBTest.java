package com.itau.pfpl.controller.modules.filter.model;

import org.junit.Assert;
import org.junit.Test;

public class ProductIdRuleDBTest {

  @Test
  public void testConstructors() {
    ProductIdRuleDB productIdRuleDBWithParameters = new ProductIdRuleDB(1, "test");
    ProductIdRuleDB productIdRuleDBWithoutParameters = new ProductIdRuleDB();


    Assert.assertNotNull("Assert that the object has parameters", productIdRuleDBWithParameters.getProductIdRule());
    Assert.assertNull("Assert that the object has no parameters", productIdRuleDBWithoutParameters.getProductIdRule());
  }

  @Test
  public void testGettersAndSetters() {
    ProductIdRuleDB productIdRuleDB = new ProductIdRuleDB();
    Integer expectedId = 1;
    String expectedProductIdRule = "test";
    productIdRuleDB.setId(expectedId);
    productIdRuleDB.setProductIdRule(expectedProductIdRule);


    Assert.assertEquals("Assert that getter are retrieving id", expectedId, productIdRuleDB.getId());
    Assert.assertEquals("Assert that getter are retrieving productIdRule", expectedProductIdRule, productIdRuleDB.getProductIdRule());
  }
}
