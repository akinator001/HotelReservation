package com.cp.hotelreservation;

public class Hotel {
	private String hotelName;
	private int regularCustomerWeekdayRate;
	private int regularCustomerWeekendRate;
	private int rating;
	private int rewardCustomerWeekdayRate;
	private int rewardCustomerWeekendRate;
	
	public Hotel(String hotelName, int regularCustomerWeekdayRate , int regularCustomerWeekendRate,int rating, int rewardCustomerWeekdayRate , int rewardCustomerWeekendRate) {
		this.hotelName = hotelName;
		this.regularCustomerWeekdayRate = regularCustomerWeekdayRate;
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
		this.rating = rating;
		this.rewardCustomerWeekendRate = rewardCustomerWeekendRate;;
		this.rewardCustomerWeekdayRate = rewardCustomerWeekdayRate;
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
	
	public int getRating() {
		return this.rating;
	}
	
	public void setRating(int rating) {
		this.rating =rating;
	}
	
	public int getRewardCustomerWeekendRate() {
		return rewardCustomerWeekendRate;
	}

	public void setRewardCustomerWeekendRate(int rewardCustomerWeekendRate) {
		this.rewardCustomerWeekendRate = rewardCustomerWeekendRate;
	}

	public int getRewardCustomerWeekdayRate() {
		return rewardCustomerWeekdayRate;
	}

	public void setRewardCustomerWeekdayRate(int rewardCustomerWeekdayRate) {
		this.rewardCustomerWeekdayRate = rewardCustomerWeekdayRate;
	}
}
