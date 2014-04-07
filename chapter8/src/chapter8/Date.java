package chapter8;
// EC for when executed that always establishes the date as the date which is the same as the day executed the program (with default constructor)
public class Date {
	private int year;
	private int month;
	private int day;
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Date(){
		long milliTime = System.currentTimeMillis();
		milliTime  = milliTime / 1000 / 60 / 60 / 24; //converts milliseconds to days
		Date d1 = new Date (1970,1,1);
		d1.addDays((int)milliTime);
		this.year = d1.year;
		this.month = d1.month;
		this.day = d1.day;
		
	}
	private void addDays(int day, Date earlier){
		int month = 0;
		int year = earlier.year;
		int counter = 0;
		while(earlier.month <= 12 && counter < day){
			while(earlier.day <= determineMonthLength(earlier .month,earlier.year) && counter < day){ //error on <, needs to be <=?
				earlier.day++;
				counter++;
				if(earlier.day > determineMonthLength(earlier.month,earlier.year)){
					earlier.month++;
					earlier.day = 1;
				}
				if(earlier.month > 12){
					earlier.year++;
					earlier.month = 1;
				}
			}
			if(earlier.month == 13){
				earlier.year++;
			}
		}
	}
	public void addDays(int day){
		addDays(day,this);
	}
	
	public void addWeeks(int weeks){
		int counter = 0;
		while(this.month <= 12 && counter < weeks){
			while(this.day <= determineMonthLength(this.month,this.year) && counter < weeks){ //error on <, needs to be <=?
				this.day += 7;
				counter++;
				if(this.day > determineMonthLength(this.month,this.year)){
					this.day = this.day - determineMonthLength(this.month,this.year);
					this.month++;
				}
				if(this.month > 12){
					this.year++;
					this.month = 1;
				}
			}
			if(this.month == 13){
				this.year++;
			}
		}
	}
	public int determineMonthLength(int month,int year){
		int days = 0;
		switch(month){
		case 1: days = 31;
				break;
		case 2: days = 28;
				if(isLeapYear())
					days++;
				break;
		case 3: days = 31;
				break;
		case 4: days = 30;
				break;
		case 5: days = 31;
				break;
		case 6: days = 30;
				break;
		case 7: days = 31;
				break;
		case 8: days = 31;
				break;
		case 9: days = 30;
				break;
		case 10: days = 31;
				break;
		case 11: days = 30;
				break;
		case 12: days = 31;
				break;
		default: days = 0;
				break;
		}
		return days;
	}
	public boolean isLeapYear(){
		if((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0){
			return true;
		}
		return false;
	}
	public int daysTo(Object obj){
		int daysTo = 0;
		int pastYear = this.year;
		int pastMonth = this.month;
		int pastDay = this.day;
		if(obj instanceof Date){
			Date other = (Date) obj;
			String date = toString(other);
			//System.out.println("***"+date);
			if(laterDate(other)){
				while(!date.equals(this.toString())){
					addDays(1,this);
					daysTo++;
				}
			}else{
				while(!toString(other).equals(toString(this))){
					addDays(1,other);
					daysTo--;
				}
				if(daysTo < -365){
					daysTo--;
				}
			}
			
		}else{
			throw new IllegalArgumentException("Did not pass object of type Date");
		}
		this.year = pastYear;
		this.month = pastMonth;
		this.day = pastDay;
		return daysTo;
	}
	public boolean laterDate(Date other){		//return true if this objects values are earlier than the passed objects values
		if(this.year < other.year){
			return true;
		}else if(this.year > other.year){
			return false;
		}else if(this.month < other.month){
			return true;
		}else if(this.month > other.month){
			return false;
		}else if(this.day < other.day){
			return true;
		}else if(this.day > other.day){
			return false;
		}else{
			return true;
		}
	}
	public int daysInMonth(int month,int year){
		int days = 0;
		for(int i = 1; i <= month; i++){
			days += determineMonthLength(i,year);
		}
		return days;
	}
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
	public String toString(){
		return toString(this);
	}
	private String toString(Date d1){
		String date = "";
		date = d1.year + "/";
		if(d1.month < 10){
			date += "0";
		}
		date += d1.month + "/" + d1.day;
		//System.out.println(date);
		return date;
	}
	
}
