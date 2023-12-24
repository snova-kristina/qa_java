package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {

  private final String sex;
  private final boolean expectedHasMane;

  public LionParamTest(String sex, boolean expectedHasMane) {
    this.sex = sex;
    this.expectedHasMane = expectedHasMane;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"Самец", true},
        {"Самка", false}
    });
  }

  @Test
  public void doesHaveManeShouldReturnCertainValue() throws Exception {
    Feline feline = new Feline();
    Lion lion = new Lion(sex, feline);
    assertEquals(expectedHasMane, lion.doesHaveMane());
  }
}
