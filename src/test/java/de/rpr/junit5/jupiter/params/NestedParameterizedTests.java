package de.rpr.junit5.jupiter.params;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NestedParameterizedTests {


  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void should_have_parameters_injected(int param) {
    System.out.println("Injected parameter: " + param);
  }

  @Nested
  class TestGroup{

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    void should_have_parameters_injected(String param) {
      System.out.println("Injected parameter: " + param);
    }
  }
}
