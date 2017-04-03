package org.mafagafogigante.dungeon.date;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

    /* Hour Test
     * Hour input : -1  Output : 0    
     * Hour input : 25  Output : 0    
     */
	@Test
	public void DateTimeHourCheck () {
		Date NegativeHour = new Date(1, 1, 1, -1, 1, 1);
		assertEquals(0, NegativeHour.getHour(), 0.1f );
		
		Date ExceedHour = new Date(1, 1, 1, 25, 1, 1);
		assertEquals(0, ExceedHour.getHour(), 0.1f );
	}
	
    /* Minute Test
     * Minute input : -1  Output : 0    
     * Minute input : 60  Output : 0    
     */
	@Test
	public void DateTimeMinuteCheck () {
		Date NegativeMinute = new Date(1, 1, 1, 1, -1, 1);
		assertEquals(0, NegativeMinute.getMinute(), 0.1f );
		
		Date ExceedMinute = new Date(1, 1, 1, 1, 60, 1);
		assertEquals(0, ExceedMinute.getMinute(), 0.1f );
	}
	
    /* Second Test
     * Second input : -1  Output : 0    
     * Second input : 60  Output : 0    
     */
	@Test
	public void DateTimeSecondCheck () {
		Date NegativeSecond = new Date(1, 1, 1, 1, 1, -1);
		assertEquals(0, NegativeSecond.getSecond(), 0.1f );
		
		Date ExceedSecond = new Date(1, 1, 1, 1, 1, 60);
		assertEquals(0, ExceedSecond.getSecond(), 0.1f );
	}
	
    /* Year Test
     * Second input : -1  Output : 1     
     */
	@Test
	public void DateTimeYearCheck () {
		Date NegativeYear = new Date(-1, 1, 1);
		assertEquals(1, NegativeYear.getYear(), 0.1f );
		
		
	}
	
    /* Month Test
     * Month input : -1  Output : 1    
     * Month input : 11  Output : 10    
     */
	@Test
	public void DateTimeMonthCheck () {
		Date NegativeMonth = new Date(1, -1, 1);
		assertEquals(1, NegativeMonth.getMonth(), 0.1f );
		
		Date ExceedMonth = new Date(1, 11, 1);
		assertEquals(10, ExceedMonth.getMonth(), 0.1f );
	}
	
    /* Day Test
     * Day input : -1  Output : 1    
     * Day input : 11  Output : 10    
     */
	@Test
	public void DateTimeDayCheck () {
		Date NegativeDay = new Date(1, 1, -1);
		assertEquals(1, NegativeDay.getDay(), 0.1f );
		
		Date ExceedDay = new Date(1, 1, 11);
		assertEquals(10, ExceedDay.getDay(), 0.1f );
	}
	
	
	/* String Test
	 * Date input : 1, 1, 1 Output: day 1 of month 1 of the year 1
	 */
	@Test
	public void DateTime_StringDateTest () {
		Date StringCheck = new Date(1, 1, 1);
		assertEquals(String.valueOf("day 1 of month 1 of the year 1"),StringCheck.toDateString() );
	}
	
	/* Time Test
	 * Date input : 1, 1, 1, 10, 10, 10 Output: 10:10:10
	 */
	@Test
	public void DateTime_TimeDateTest () {
		Date StringCheck = new Date(1, 1, 1,  10, 10, 10);
		assertEquals(String.valueOf("10:10:10"),StringCheck.toTimeString());
	}
	
	/* Schedule Time Test
	 * Date input : 1, 1, 1, 10, 10, 10 Output: "5-01-01 10:10:10"
	 */
	@Test
	public void DateTime_SchedhuleTimeTest () {
		Date StringCheck = new Date(5, 1, 1,  10, 10, 10);
		assertEquals(String.valueOf("5-01-01 10:10:10"),StringCheck.toString());
	}
	
	/* Compare Test
	 * SameDate input : 1, 1, 2, Output: 0
	 * ExceedDate input : 2, 1, 2, Output: 1
	 * LowDate input : 1, 1, 1 Output: 0
	 */
	@Test
	public void DateTime_CompareTest(){
		Date CompareDate = new Date(1, 1, 2);
		
		Date SameDate = new Date(1, 1, 2);
		Date ExceedDate = new Date(2, 1, 2);
		Date LowDate = new Date(1, 1, 1);
		
		assertEquals(0, CompareDate.compareTo(SameDate));
		assertEquals(1, CompareDate.compareTo(ExceedDate) );
		assertEquals(-1, CompareDate.compareTo(LowDate) );
	}
	


}
