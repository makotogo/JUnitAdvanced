/*
 * Copyright 2017 Makoto Consulting Group, Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
