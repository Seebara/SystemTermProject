package org.mafagafogigante.dungeon.date;

import org.junit.Assert;
import org.junit.Test;

/*
 * InputData                OutpudData:    
 * End  : Day + 1             1 day
 * End  : Day + 2             2 days
 * End  : Day - 2            
 * End  : Month + 1           1 month
 * End  : Month + 1           2 months
 * End  : Day + 1             2 months and 1 day
 * End  : Day + 1             2 months and 2 days
 * End  : Month - 2           2 days
 * End  : Day - 2             
 * End  : Year + 1            1 year
 * End  : Year + 1            2 years
 * End  : Day + 1             2 years and 1 day
 * End  : Day - 1  Month + 1  2 years and 1 month
 * End  : Day + 1             2 years and 1 month and 1 day
 */


public class DurationTest {

  @Test
  public void DurationTestToString() throws Exception {
    Date Start = new Date(2017, DungeonTimeUnit.YEAR.as(DungeonTimeUnit.MONTH), DungeonTimeUnit.MONTH.as(
        DungeonTimeUnit.DAY), 0, 0, 0);
    Date End = new Date(2017, DungeonTimeUnit.YEAR.as(DungeonTimeUnit.MONTH), DungeonTimeUnit.MONTH.as(
        DungeonTimeUnit.DAY), 0, 0, 0);

    End = End.plus(1, DungeonTimeUnit.DAY);
    Assert.assertEquals("1 day", new Duration(Start, End).toString());
    End = End.plus(1, DungeonTimeUnit.DAY);
    Assert.assertEquals("2 days", new Duration(Start, End).toString());
    End = End.minus(2, DungeonTimeUnit.DAY);

    End = End.plus(1, DungeonTimeUnit.MONTH);
    Assert.assertEquals("1 month", new Duration(Start, End).toString());
    End = End.plus(1, DungeonTimeUnit.MONTH);
    Assert.assertEquals("2 months", new Duration(Start, End).toString());
    End = End.plus(1, DungeonTimeUnit.DAY);
    Assert.assertEquals("2 months and 1 day", new Duration(Start, End).toString());
    End = End.plus(1, DungeonTimeUnit.DAY);
    Assert.assertEquals("2 months and 2 days", new Duration(Start, End).toString());
    End = End.minus(2, DungeonTimeUnit.DAY);
    End = End.minus(2, DungeonTimeUnit.MONTH);

    End = End.plus(1, DungeonTimeUnit.YEAR);
    Assert.assertEquals("1 year", new Duration(Start, End).toString());
    End = End.plus(1, DungeonTimeUnit.YEAR);
    Assert.assertEquals("2 years", new Duration(Start, End).toString());
    End = End.plus(1, DungeonTimeUnit.DAY);
    Assert.assertEquals("2 years and 1 day", new Duration(Start, End).toString());
    End = End.minus(1, DungeonTimeUnit.DAY);
    End = End.plus(1, DungeonTimeUnit.MONTH);
    Assert.assertEquals("2 years and 1 month", new Duration(Start, End).toString());
    End = End.plus(1, DungeonTimeUnit.DAY);
    Assert.assertEquals("2 years, 1 month, and 1 day", new Duration(Start, End).toString());
  }

}
