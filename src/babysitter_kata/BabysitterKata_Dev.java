package babysitter_kata;

public class BabysitterKata_Dev {
	
	//pay rates for different shifts
	private int regularShiftHourlyPay = 12,
			bedtimeShiftHourlyPay = 8,
			midnightShiftHourlyPay = 16;
	
	//work start and end time constraints
	private int startHour = 5,
			endHour = 4;
	
	//start time cannot be before 5 pm
	public boolean validateStartHour(int startTime) {
		
		if(startTime < startHour )
			return false;
		
		return true;
	}
	
	//end time can be no later than 4 am 
	public boolean validateEndHour(int endTime) {
		
		if(endTime > endHour)
			return false;
		
		return true;
	}
	
	
	//bedtime cannot be: before start time and after end time
	public boolean validateBedTimeHour(int bedTime, int startTime, int endTime) {

		if (startTime <= bedTime && bedTime <= endTime) {
			return true;
		} else
			return false;
	}
	
	//check if input parameters are appropriate
	public boolean validateInput(int startTime, int bedTime, int endTime) {
		if(validateStartHour(startTime) && validateBedTimeHour(bedTime, startTime, endTime) && validateEndHour(endTime))
			return true;
		return false;
	}
	
	//calculate regular shift hours
	public int getRegularShiftHours(int startTime, int bedTime, int endTime) {
		
		if (bedTime >= 12) {
			return 12 - startTime;
		} else if (bedTime < 12) {
			return bedTime - startTime;
		} else
			return 0;
		
	}
	
	//calculate bedtime shift hours
	public int getBedtimeShiftHours(int startTime, int bedTime) {
		if (startTime < 12) {
			return 12 - bedTime;
		} else
			return 0;
	}
	
	//calculate midnight shift hours
	public int getMidnightShiftHours(int endTime) {
		if (endTime > 12) {
			return endTime - 12;
		} else
			return 0;
	}
	
	
	// calculate the total pay for one night, given the start, end and bed times
	public int getTotalPay(int startTime, int bedTime, int endTime) {
		
		int totalPay = 0;
		
		if(validateInput(startTime, bedTime, endTime)) {
		
			// calculate number of hours for each shift
			int regularShiftHours = getRegularShiftHours(startTime, bedTime, endTime), 
				bedtimeShiftHours = getBedtimeShiftHours(startTime, bedTime),
				midnightShiftHours = getMidnightShiftHours(endTime);
			
			//calculate cumulative sum of pay for each shift
			int regularShiftPay = regularShiftHours * regularShiftHourlyPay,
				bedtimeShiftPay = bedtimeShiftHours * bedtimeShiftHourlyPay,
				midnightShiftPay = midnightShiftHours * midnightShiftHourlyPay;
			
			
			totalPay = regularShiftPay + bedtimeShiftPay + midnightShiftPay;
		}
		return totalPay;
	}
}
