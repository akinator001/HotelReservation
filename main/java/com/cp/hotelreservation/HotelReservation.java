package com.cp.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservation {
	static List<Hotel> hotelList = new ArrayList<>();
	static Date checkin;
	static Date checkout;
	
	public void addHotel(String hotelName, int rate) {
		hotelList.add(new Hotel(hotelName , rate));
	}
	
	public String findCheapestHotel(String startDate,String lastDate) throws ParseException {
		checkin = new SimpleDateFormat("ddMMMyyyy").parse(startDate);
		checkout = new SimpleDateFormat("ddMMMyyyy").parse(startDate);
		
		long days = ((checkout.getTime()-checkin.getTime())/(1000*60*60*24))+1;

		List<Long> hotelRentList = hotelList.parallelStream().map(hotel -> hotel.getRegularCustomerWeekdayRate() * days)
				                   .collect(Collectors.toList());
		long minRent = Collections.min(hotelRentList);
		Hotel cheapestHotel = hotelList.stream().filter(hotel -> hotel.getRegularCustomerWeekdayRate() * days == minRent).findFirst()
				                  .orElse(null);
		System.out.println("Hotel : "+ cheapestHotel.getHotelName()+" Cost : "+ minRent);
		return cheapestHotel.getHotelName();		
	} 
}
