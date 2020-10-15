package com.cp.hotelreservation;

public class Hotel {
	private String hotelName;
	private int regularCustomerWeekdayRate;
	private int regularCustomerWeekendRate;
	
	public Hotel(String hotelName, int regularCustomerWeekdayRate , int regularCustomerWeekendRate) {
		this.hotelName = hotelName;
		this.regularCustomerWeekdayRate = regularCustomerWeekdayRate;
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustomerWeekdayRate() {
		return regularCustomerWeekdayRate;
	}

	public void setRegularCustomerWeekdayRate(int regularCustomerWeekdayRate) {
		this.regularCustomerWeekdayRate = regularCustomerWeekdayRate;
	}
	
	public int getRegularCustomerWeekendRate() {
		return this.regularCustomerWeekendRate;
	}
	
	public void setRegularCustomerWeekendRate(int regularCustomerWeekendRate) {
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
	}
	
}
