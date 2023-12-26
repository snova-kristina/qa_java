package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

  private Feline mockFeline;
  private Cat cat;

  @Before
  public void setUp() {
    mockFeline = mock(Feline.class);
    cat = new Cat(mockFeline);
  }

  @Test
  public void getSoundShouldReturnCertainSound() {
    assertEquals("Мяу", cat.getSound());
  }

  @Test
  public void getFoodShouldReturnExpectedFoodList() throws Exception {
    List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
    Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFoodList);
    List<String> actual = cat.getFood();
    assertEquals(expectedFoodList, actual);
  }

  @Test
  public void getFoodShouldThrowExeption() throws Exception {
    String errorMessage = "Cannot eat meat";
    Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception(errorMessage));
    Exception exception =assertThrows(Exception.class, () -> cat.getFood());
    assertEquals(errorMessage, exception.getMessage());
  }
}
