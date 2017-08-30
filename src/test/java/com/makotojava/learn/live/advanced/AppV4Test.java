package com.makotojava.learn.live.advanced;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AppV4Test {

  private App classUnderTest;

  @Before
  public void setUp() {
    classUnderTest = new App();
  }

  @After
  public void tearDown() {
    classUnderTest = null;
  }

  @Parameters
  public static Collection<String> parameters() {
    List<String> ret = new ArrayList<>();

    ret.add("String");
    ret.add("StringToo");
    ret.add("String2");
    ret.add("StringAlso");

    return ret;
  }

  @Test
  public void testDoIt() {
    assertEquals("String", classUnderTest.doIt("String"));
    assertEquals("StringToo", classUnderTest.doIt("StringToo"));
    assertEquals("String2", classUnderTest.doIt("String2"));
    assertEquals("StringAlso", classUnderTest.doIt("StringAlso"));
  }

  @Test
  public void testDoIt_withParams() {
    assertEquals(stringParam, classUnderTest.doIt(stringParam));
  }

  private String stringParam;

  public AppV4Test(String stringParam) {
    this.stringParam = stringParam;
  }

}
