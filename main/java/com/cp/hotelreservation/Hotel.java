package com.cp.hotelreservation;

public class Hotel {
	private String hotelName;
	private int regularCustomerWeekdayRate;

	public Hotel(String hotelName, int regularCustomerWeekdayRate) {
		this.hotelName = hotelName;
		this.regularCustomerWeekdayRate = regularCustomerWeekdayRate;
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
}
