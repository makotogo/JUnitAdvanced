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

/**
 * Simple class that does nothing much really.
 * 
 * TODO: replace this class with your application logic.
 *
 */
public class App {
  /**
   * Simple method that takes a String and returns it.
   * 
   * @param argument
   *          The String to be returned.
   * 
   * @return - String - the string that was passed in.
   */
  public String doIt(String argument) {
    return argument;
  }

  /**
   * Do it for a Person.
   * 
   * @param person
   *          The Person
   * 
   * @return String - the name attribute.
   */
  public String doIt(Person person) {
    return person.getName();
  }
}
