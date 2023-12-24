package com.example;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

  @Test
  public void getKittensCallsFelineMethod() throws Exception {
    Feline mockedFeline = mock(Feline.class);
    Lion lion = new Lion("Самец", mockedFeline);
    lion.getFood();
    verify(mockedFeline, times(1)).getFood("Хищник");
  }

  @Test
  public void getFoodCallsFelineMethod() throws Exception {
    Feline mockedFeline = mock(Feline.class);
    Lion lion = new Lion("Самец", mockedFeline);
    lion.getFood();
    verify(mockedFeline, times(1)).getFood("Хищник");
  }

  @Test
  public void lionConstructorWhenInvalidSexShouldThrowsException() {
    Feline feline = new Feline();
    assertThrows(Exception.class, () -> new Lion("InvalidSex", feline));
  }
}
