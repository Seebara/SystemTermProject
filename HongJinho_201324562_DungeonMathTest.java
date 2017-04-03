package org.mafagafogigante.dungeon.util;

import org.junit.Assert;
import org.junit.Test;

public class DungeonMathTest {

	/*
	 * Input Data                                Output Data
	 * First:0.0 Second:1.0 Percentage: (0.0)       0.0
	 * First:1.0 Second:0.0 Percentage: (0.0)       1.0 
	 * First:0.0 Second:1.0 Percentage: (1.0)       1.0
	 * First:1.0 Second:0.0 Percentage: (1.0)       0.0
	 * First:0.0 Second:0.5 Percentage: (0.0)       0.0
	   First:0.0 Second:0.5 Percentage: (0.2)       0.1
	   First:0.0 Second:0.5 Percentage: (0.4)       0.2
	   First:0.0 Second:0.5 Percentage: (0.6)       0.3
	   First:0.0 Second:0.5 Percentage: (0.8)       0.4
	   First:0.0 Second:0.5 Percentage: (1.0)       0.5
	   
	   Weight Formula first + (second - first) * firstContribution.toDouble();
	 */
  @Test
  public void WeightedAverageShouldWorkAsExpected() throws Exception {
    Assert.assertEquals(0, Double.compare(0.0, DungeonMath.weightedAverage(0.0, 1.0, new Percentage(0.0))));
    Assert.assertEquals(0, Double.compare(1.0, DungeonMath.weightedAverage(1.0, 0.0, new Percentage(0.0))));
    Assert.assertEquals(0, Double.compare(1.0, DungeonMath.weightedAverage(0.0, 1.0, new Percentage(1.0))));
    Assert.assertEquals(0, Double.compare(0.0, DungeonMath.weightedAverage(1.0, 0.0, new Percentage(1.0))));
    Assert.assertEquals(0, Double.compare(0.0, DungeonMath.weightedAverage(0.0, 0.5, new Percentage(0.0))));
    Assert.assertEquals(0, Double.compare(0.1, DungeonMath.weightedAverage(0.0, 0.5, new Percentage(0.2))));
    Assert.assertEquals(0, Double.compare(0.2, DungeonMath.weightedAverage(0.0, 0.5, new Percentage(0.4))));
    Assert.assertEquals(0, Double.compare(0.3, DungeonMath.weightedAverage(0.0, 0.5, new Percentage(0.6))));
    Assert.assertEquals(0, Double.compare(0.4, DungeonMath.weightedAverage(0.0, 0.5, new Percentage(0.8))));
    Assert.assertEquals(0, Double.compare(0.5, DungeonMath.weightedAverage(0.0, 0.5, new Percentage(1.0))));
  }

  /*
   * inputData                     OutputData
   * long -1L                         int -1
   * long 0L			              int  0
   * long 1L			              int  1
   * (long)Inteager.Min_Value         inteager.MIN_VALUE
   */
  @Test
  public void SafeCastLongToIntegerShouldNotChangeValue() throws Exception {
    Assert.assertEquals(-1, DungeonMath.safeCastLongToInteger(-1L));
    Assert.assertEquals(0, DungeonMath.safeCastLongToInteger(0L));
    Assert.assertEquals(1, DungeonMath.safeCastLongToInteger(1L));
    Assert.assertEquals(Integer.MIN_VALUE, DungeonMath.safeCastLongToInteger((long) Integer.MIN_VALUE));
  }
  
  
  /*
   * inputData                               OutputData
   * (long) Integer.MIN_VALUE) - 1   IllegalArgumentException.class
   */
  @Test(expected = IllegalArgumentException.class)
  public void SafeCastLongToIntegerShouldThrowExceptionOnUnderflow() throws Exception {
    DungeonMath.safeCastLongToInteger(((long) Integer.MIN_VALUE) - 1);
  }

  /*
   * inputData                               OutputData
   * (long) Integer.MAX_VALUE) + 1   IllegalArgumentException.class
   */
  @Test(expected = IllegalArgumentException.class)
  public void SafeCastLongToIntegerShouldThrowExceptionOnOverflow() throws Exception {
    DungeonMath.safeCastLongToInteger(((long) Integer.MAX_VALUE) + 1);
  }

}
