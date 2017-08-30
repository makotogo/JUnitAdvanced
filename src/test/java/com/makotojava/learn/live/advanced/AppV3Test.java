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
