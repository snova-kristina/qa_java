package com.example;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

  @Spy
  private Feline feline = new Feline();

  @Test
  public void getFamilyShouldReturnFeline() {
    Feline feline = new Feline();
    Assert.assertEquals("Кошачьи", feline.getFamily());
  }

  @Test
  public void getKittensWithParamsShouldEqualSentValue() {
    int expectedKittensCount = 3;
    Feline feline = new Feline();
    Assert.assertEquals(expectedKittensCount, feline.getKittens(expectedKittensCount));
  }

  @Test
  public void getKittensWithoutParamsShouldCallGetKittens() {
    feline.getKittens();
    Mockito.verify(feline, Mockito.times(1)).getKittens(1);
  }

  @Test
  public void eatMeatShouldReturnExpectedFoodList() throws Exception {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
    List<String> actualFood = feline.eatMeat();
    assertEquals(expectedFood, actualFood);
    Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
  }
}
