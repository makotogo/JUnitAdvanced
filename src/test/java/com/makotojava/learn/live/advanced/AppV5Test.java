package com.makotojava.learn.live.advanced;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(JUnitPlatform.class)
@DisplayName("Testing the App")
public class AppV5Test {

  private static final Logger log = Logger.getLogger(AppV5Test.class);

  private App classUnderTest;

  @BeforeEach
  void setUp() {
    classUnderTest = new App();
  }

  @Test
  @DisplayName("When using assertAll on a bunch of Strings, it should succeed.")
  public void doIt() {
    log.info("Testing doIt()...");
    assertAll(
        () -> assertEquals("String", classUnderTest.doIt("String")),
        () -> assertEquals("StringToo", classUnderTest.doIt("StringToo")),
        () -> assertEquals("String2", classUnderTest.doIt("String2")),
        () -> assertEquals("StringAlso", classUnderTest.doIt("StringAlso")));
  }

  // 1
  @Nested
  @DisplayName("When injecting Person via ParameterResolver")
  // 3
  @ExtendWith(PersonParameterResolver.class)
  public class ParameterResolverAppTest {

    @Test
    @DisplayName("Testing doIt(Person)")
    public void doIt(Person person) {
      String name = person.getName();
      assertEquals(name, classUnderTest.doIt(person));
    }

  }

  // 2a PersonParameterResolver - first as static inner class
  // 2b Refactor to its own class (optional)
  public static class PersonParameterResolver implements ParameterResolver {

    @Override
    public Object resolveParameter(ParameterContext pctx, ExtensionContext ectx) throws ParameterResolutionException {
      return new Person().setName("Resolved");
    }

    @Override
    public boolean supportsParameter(ParameterContext pctx, ExtensionContext ectx) throws ParameterResolutionException {
      return pctx.getParameter().getType() == Person.class;
    }

  }

  // 4
  private static final Person PERSON1 = new Person().setName("Joe");
  private static final Person PERSON2 = new Person().setName("Jane");

  public enum PersonEnum {
    PERSON_1(PERSON1),
    PERSON_2(PERSON2);

    private Person person;

    private PersonEnum(Person person) {
      this.person = person;
    }

    public Person getPerson() {
      return this.person;
    }
  }

  // 5
  @Nested
  @DisplayName("When injecting Person via @ParameterizedTest - EnumSource")
  public class ParameterizedTestAppTest {

    @ParameterizedTest
    @EnumSource(PersonEnum.class)
    @DisplayName("Testing doIt with EnumSource")
    public void doIt(PersonEnum person) {
      String name = person.getPerson().getName();
      assertEquals(name, classUnderTest.doIt(person.getPerson()));
    }

  }

  // 6
  @ParameterizedTest
  @ValueSource(strings = { "Barbara", "Ed", "Pankaj" })
  @DisplayName("When injecting Strings via ParameterizedTest - ValueSource")
  public void doIt(String name) {
    Person person = new Person().setName(name);
    assertEquals(person.getName(), classUnderTest.doIt(person));
  }

  // 7
  @ParameterizedTest
  @MethodSource(value = "personProvider")
  @DisplayName("When injecting Person via ParameterizedTest - MethodSource")
  public void doIt(Person person) {
    assertEquals(person.getName(), classUnderTest.doIt(person));
  }

  // 8
  private static Iterator<Person> personProvider() {
    PersonEnum[] testPersons = PersonEnum.values();
    List<Person> people = new ArrayList<>();
    for (PersonEnum personEnum : testPersons) {
      people.add(personEnum.getPerson());
    }
    return people.iterator();
  }

}
