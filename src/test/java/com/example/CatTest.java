package com.example;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
    Assert.assertEquals("Мяу", cat.getSound());
  }

  @Test
  public void getFoodShouldReturnExpectedFoodList() throws Exception {
    List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
    Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFoodList);
    List<String> actual = cat.getFood();
    Assert.assertEquals(expectedFoodList, actual);
  }

  @Test
  public void getFoodShouldThrowExeption() throws Exception {
    Mockito.when(mockFeline.eatMeat()).thenThrow(Exception.class);
    assertThrows(Exception.class, () -> cat.getFood());
  }
}
