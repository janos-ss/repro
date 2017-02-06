package com.example;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class MyTest {
  // Assertion is not detected in this method, raising false positive:
  // "Tests should include assertions squid:S2699"
  @Test
  public void test1() {
    MyDto info = new MyDto();
    Assert.assertNotNull(info);
    Assert.assertEquals(info, info);
    Assertions.assertThat(info).isEqualTo(info);
  }

  // Assertion is correctly detected in this method
  @Test
  public void test2() {
    Object info = newMyDto();
    Assert.assertNotNull(info);
  }

  MyDto newMyDto() {
    return new MyDto();
  }
}
