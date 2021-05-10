package babysitter_kata;

public class BabysitterKata_Dev {
	
	//pay rates for different shifts
	private int regularShiftHourlyPay = 12,
			bedtimeShiftHourlyPay = 8,
			midnightShiftHourlyPay = 16;
	
	//work start and end time constraints
	private int startHour = 5,
			endHour = 4;
	
	
	//rescaling times from (5)17 to (4)28
	public int rescaleTime(int time) {
		if(time >= 5 && time <= 12)
			return time + 12;
		return time + 24;
	}
	
	//start time cannot be before 5 pm and should always be before end time
	public boolean validateStartHour(int startTime, int endTime) {
		
		if( rescaleTime(startTime) < rescaleTime(startHour) || 
				rescaleTime(startTime) >= rescaleTime(endTime))
			return false;
		
		return true;
	}
	
	//end time can be no later than 4 am and should always be after start time 
	public boolean validateEndHour(int endTime, int startTime) {
		
		if( rescaleTime(endTime) > rescaleTime(endHour) || 
				rescaleTime(endTime) <= rescaleTime(startTime))
			return false;
		
		return true;
	}
	
	
	//bedtime cannot be: before start time and after end time
	public boolean validateBedTimeHour(int bedTime, int startTime, int endTime) {

		if ( rescaleTime(startTime) <= rescaleTime(bedTime) && 
				rescaleTime(bedTime) <= rescaleTime(endTime) ){
			return true;
		} else
			return false;
	}
	
	//check if input parameters are appropriate
	public boolean validateInput(int startTime, int bedTime, int endTime) {
		if(validateStartHour(startTime, endTime) && 
				validateBedTimeHour(bedTime, startTime, endTime) && 
				validateEndHour(endTime, startTime))
			return true;
		return false;
	}
	
	//calculate regular shift hours
	public int getRegularShiftHours(int startTime, int bedTime) {
		
		if ( rescaleTime(bedTime) >= rescaleTime(12) ){
			return rescaleTime(12) - rescaleTime(startTime);
		} else if (rescaleTime(bedTime) < 24) {
			return rescaleTime(bedTime) - rescaleTime(startTime);
		} else
			return 0;
	}
	
	//calculate bedtime shift hours
	public int getBedtimeShiftHours(int bedTime) {
		if ( rescaleTime(bedTime) < rescaleTime(12) ){
			return rescaleTime(12) - rescaleTime(bedTime);
		} else
			return 0;
	}
	
	//calculate midnight shift hours
	public int getMidnightShiftHours(int endTime) {
		if (rescaleTime(endTime) > rescaleTime(12) ){
			return rescaleTime(endTime) - rescaleTime(12);
		} else
			return 0;
	}
	
	
	/*
	 * Calculate the total pay for one work night, given the start, end and bed times
	 * Step 1: Validate the input start time, end time and bed times given their constraints
	 * Step 2: Calculate the working hours in each shift
	 * Step 3: Calculate the total pay
	 */
	public int getTotalPay(int startTime, int bedTime, int endTime) {
		
		int totalPay = 0;
		
		
		if(validateInput(startTime, bedTime, endTime)) {
		
			// calculate number of hours for each shift
			int regularShiftHours = getRegularShiftHours(startTime, bedTime), 
				bedtimeShiftHours = getBedtimeShiftHours(bedTime),
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
