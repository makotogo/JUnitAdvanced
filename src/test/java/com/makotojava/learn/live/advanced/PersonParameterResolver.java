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