package com.itau.pfpl.controller.modules.filter.model;

import org.junit.Assert;
import org.junit.Test;

public class ResponseStatusTest {

  @Test
  public void testGettersAndConstructorWithParameters() {
    ResponseStatus responseStatus = new ResponseStatus("status");
    Assert.assertEquals("Assert that getter are retrieving 'status'", "status", responseStatus.getStatus());
  }

  @Test
  public void testSettersAndConstructorWithoutParameters() {
    ResponseStatus responseStatus = new ResponseStatus();
    responseStatus.setStatus("status");
    Assert.assertEquals("Assert that getter are setting 'status'", "status", responseStatus.getStatus());
  }

}
