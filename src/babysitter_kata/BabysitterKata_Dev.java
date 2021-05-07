package babysitter_kata;

public class BabysitterKata_Dev {
	
	//variables holding pay rates 
	private int regularShiftHourlyPay = 12,
			bedtimeShiftHourlyPay = 8,
			midnightShiftHourlyPay = 16;
	
	//variables holding start and end time constraints for the work night
	private int startHour = 5,
			endHour = 4;
	
	
	public boolean validateStartHour(int startTime) {
		if(startTime < startHour )
			return false;
		return true;
	}
	
	public boolean validateEndHour(int endTime) {
		if(endTime > endHour)
			return false;
		return true;
	}
	
	public boolean validateBedTimeHour(int bedTime, int startTime, int endTime) {

		if (startTime <= bedTime && bedTime <= endTime) {
			return true;
		} else
			return false;
	}
	
	public int getRegularShiftHours(int startTime, int bedTime, int endTime) {
		
		if (bedTime >= 12) {
			return 12 - startTime;
		} else if (bedTime < 12) {
			return bedTime - startTime;
		} else
			return 0;
		
	}
	
	
	public int getBedtimeShiftHours(int startTime, int bedTime) {
		if (startTime < 12) {
			return 12 - bedTime;
		} else
			return 0;
	}
	
	public int getMidnightShiftHours(int endTime) {
		if (endTime > 12) {
			return endTime - 12;
		} else
			return 0;
	}
	
	
	// principle call to calculate the total pay for one night, given the start, end and bed times
	public int getTotalPay(int startTime, int bedTime, int endTime) {
		
		int totalPay = 0;
		
	
		int regularShiftHours = getRegularShiftHours(startTime, bedTime, endTime), 
			bedtimeShiftHours = getBedtimeShiftHours(startTime, bedTime),
			midnightShiftHours = getMidnightShiftHours(endTime);
		
		
		int regularShiftPay = regularShiftHours * regularShiftHourlyPay,
			bedtimeShiftPay = bedtimeShiftHours * bedtimeShiftHourlyPay,
			midnightShiftPay = midnightShiftHours * midnightShiftHourlyPay;
		
		
		totalPay = regularShiftPay + bedtimeShiftPay + midnightShiftPay;
		
		return totalPay;
	}
}
