package com.makotojava.learn.live.advanced;

import junit.framework.TestCase;

public class AppV3Test extends TestCase {

  private App classUnderTest;

  @Override
  public void setUp() {
    classUnderTest = new App();
  }

  @Override
  public void tearDown() {
    classUnderTest = null;
  }

  public void testDoIt() {
    assertEquals("String", classUnderTest.doIt("String"));
    assertEquals("StringToo", classUnderTest.doIt("StringToo"));
    assertEquals("String2", classUnderTest.doIt("String2"));
    assertEquals("StringAlso", classUnderTest.doIt("StringAlso"));
  }

}
