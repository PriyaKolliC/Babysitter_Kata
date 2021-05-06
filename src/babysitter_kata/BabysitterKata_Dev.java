package babysitter_kata;

public class BabysitterKata_Dev {
	
	//variables holding pay rates 
	private int regularShiftHourlyPay = 12,
			bedtimeShiftHourlyPay = 8,
			midnightShiftHourlyPay = 16;
	
	//variables holding start and end time constraints for the work night
	private int startHour = 5,
			endHour = 4;
	
	
	public int getRegularShiftHours() {
		return 0;
	}
	
	
	public int getBedtimeShiftHours() {
		return 0;
	}
	
	public int getMidnightShiftHours() {
		return 0;
	}
	
	
	// principle call to calculate the total pay for one night, given the start, end and bed times
	public int getTotalPay(int startTime, int bedTime, int endTime) {
		
		int totalPay = 0;
		
	
		int regularShiftHours = getRegularShiftHours(), 
			bedtimeShiftHours = getBedtimeShiftHours(),
			midnightShiftHours = getMidnightShiftHours();
		
		
		int regularShiftPay = regularShiftHours * regularShiftHourlyPay,
			bedtimeShiftPay = bedtimeShiftHours * bedtimeShiftHourlyPay,
			midnightShiftPay = midnightShiftHours * midnightShiftHourlyPay;
		
		
		totalPay = regularShiftPay + bedtimeShiftPay + midnightShiftPay;
		
		return totalPay;
	}
}
