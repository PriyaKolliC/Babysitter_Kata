package babysitter_kata;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BabysitterKata_Test {
	
	private BabysitterKata_Dev kataTest;

	@Before
	public void executedBeforeEachTest() {
		kataTest = new BabysitterKata_Dev();
	}

	// Methods to rescale time on chosen scale i.e. 5pm - 4 am as 17 - 28.
	@Test
	public void shouldRescaleTime5to17() {
		assertEquals(17, kataTest.rescaleTime(5));
	}

	@Test
	public void shouldConvertTime12to24() {
		assertEquals(24, kataTest.rescaleTime(12));
	}
	
	@Test
	public void shouldRescaleTime4to28() {
		assertEquals(28, kataTest.rescaleTime(4));
	}
	
	// Methods to validate if start time is appropriate
	@Test
	public void returnsTrueIfStartTime5pmIsLessThanEndTime1am() {
		assertEquals(true, kataTest.validateStartHour(5, 1));
	}

	@Test
	public void returnsFalseIfStartTime4amIsLessThanEndTime4am() {
		assertEquals(false, kataTest.validateStartHour(4, 4));
	}
	
	

	// Method to validate if end time is appropriate
	@Test
	public void returnsTrueIfEndTime4amIsAfterStartTime5pm() {
		assertEquals(true, kataTest.validateEndHour(4, 5));
	}

	@Test
	public void returnsFalseIfEndTime7pmIsAfterStartTime8pm() {
		assertEquals(false, kataTest.validateEndHour(7, 8));
	}

	// Methods to validate if bedtime is within range of start time to end time
	
	@Test
	public void returnsTrueIfBedTime8pmIsWithinStartTime6pmEndTime2am() {
		assertEquals(true, kataTest.validateBedTimeHour(8, 6, 2));
	}

	@Test
	public void returnsFalseIfBedTime6pmIsWithinStartTime8pmEndTime10pm() {
		assertEquals(false, kataTest.validateBedTimeHour(6, 7, 11));
	}
	
	
	// Methods to calculate Mid night shift hours
	@Test
	public void return4HoursFromMidnightToEndTime4am() {
		assertEquals(4, kataTest.getMidnightShiftHours(4));
	}

	@Test
	public void return3HoursFromMidnightToEndTime3am() {
		assertEquals(3, kataTest.getMidnightShiftHours(3));
	}

	@Test
	public void return0HoursFromMidnightToEndTime12am() {
		assertEquals(0, kataTest.getMidnightShiftHours(12));
	}
	
	
	// Methods to calculate Regular shift hours
	@Test
	public void return7HoursStartTime5pmBedtime2am() {
		assertEquals(7, kataTest.getRegularShiftHours(5, 2));
	}

	@Test
	public void shouldReturn6HoursStartTime5pmBedtime11pm() {
		assertEquals(6, kataTest.getRegularShiftHours(5, 11));
	}
	
	
	// Methods to calculate Regular Shift Hours
	@Test
	public void shouldReturn6HoursBedTime6pm() {
		assertEquals(6, kataTest.getBedtimeShiftHours(6));
	}

	@Test
	public void shouldReturn1HoursBedTime11pm() {
		assertEquals(1, kataTest.getBedtimeShiftHours(11));
	}

	@Test
	public void shouldReturn0HoursBedtime1am() {
		assertEquals(0, kataTest.getBedtimeShiftHours(1));
	}

	
	// Methods to calculate ultimate Pay rates for one work night
	@Test
	public void return140ForStartTime5pmBedTime10pmEndTime4am() {
		assertEquals(140, kataTest.getTotalPay(5, 10, 4));
	}

	@Test
	public void return116ForStartTime5pmBedTime12amEndTime2am() {
		assertEquals(116, kataTest.getTotalPay(5, 12, 2));
	}
	
	@Test
	public void return64ForStartTime12amBedTime2amEndTime4am() {
		assertEquals(64, kataTest.getTotalPay(12, 2, 4));
	}
	
	@Test
	public void return0ForStartTime2amBedTime12amEndTime4am() {
		assertEquals(0, kataTest.getTotalPay(2, 12, 4));
	}
}