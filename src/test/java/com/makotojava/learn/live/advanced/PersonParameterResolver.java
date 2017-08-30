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

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

// 2b - Refactored here
public class PersonParameterResolver implements ParameterResolver {

  @Override
  public Object resolveParameter(ParameterContext pctx, ExtensionContext ectx) throws ParameterResolutionException {
    return new Person().setName("Resolved");
  }

  @Override
  public boolean supportsParameter(ParameterContext pctx, ExtensionContext ectx) throws ParameterResolutionException {
    return pctx.getParameter().getType() == Person.class;
  }

}