package com.cp.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservation {
	static List<Hotel> hotelList = new ArrayList<>();
	static Date checkin;
	static Date checkout;
	
	public void addHotel(String hotelName, int weekdayRate , int weekendRate) {
		hotelList.add(new Hotel(hotelName , weekdayRate, weekendRate));
	}
	
	public String findCheapestHotel(String startDate,String lastDate) throws ParseException {
		checkin = new SimpleDateFormat("ddMMMyyyy").parse(startDate);
		checkout = new SimpleDateFormat("ddMMMyyyy").parse(lastDate);
		
		long days = ((checkout.getTime()-checkin.getTime())/(1000*60*60*24))+1;

		List<Long> hotelRentList = hotelList.parallelStream().map(hotel -> hotel.getRegularCustomerWeekdayRate() * days)
				                   .collect(Collectors.toList());
		long minRent = Collections.min(hotelRentList);
		Hotel cheapestHotel = hotelList.stream().filter(hotel -> hotel.getRegularCustomerWeekdayRate() * days == minRent).findFirst()
				                  .orElse(null);
		System.out.println("Hotel : "+ cheapestHotel.getHotelName()+" Cost : "+ minRent);
		return cheapestHotel.getHotelName();		
	}
	
	public List<String> findCheapestHotelWeekdayAndWeekend(String start, String finish) throws ParseException {
		convertToDates(start, finish);
		long days = ((checkout.getTime()-checkin.getTime())/(1000*60*60*24))+1;
		
		long weekendDays = getWeekendDays(checkin, checkout);
		long weekDays = days - weekendDays;
		
		List<Long> hotelRentList = hotelList.stream()
				                .map(hotel -> calculateHotelCost(hotel, weekDays, weekendDays)).collect(Collectors.toList());
		long minRent = Collections.min(hotelRentList);
		
		List<String> cheapHotelList = hotelList.stream()
				                   .filter(hotel -> calculateHotelCost(hotel, weekDays, weekendDays) == minRent)
				                    .map(hotel -> hotel.getHotelName()).collect(Collectors.toList());
		for (String hotel : cheapHotelList)
			System.out.println("Hotel : " + hotel + " Cost : " + minRent);
        return cheapHotelList;
	}

	public long calculateHotelCost(Hotel hotel, long weekDays, long weekendDays) {
		return hotel.getRegularCustomerWeekdayRate() * weekDays + hotel.getRegularCustomerWeekendRate() * weekendDays;
	}

	private long getWeekendDays(Date checkin2, Date checkout2) {
		long weekendDays = 0;
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(checkout);
		for (startCalendar.setTime(checkin); startCalendar.compareTo(endCalendar) <= 0; startCalendar.add(Calendar.DATE, 1)) {
			int dayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == 0 || dayOfWeek == 6)
				weekendDays++;
		}
		return weekendDays;
	}

	private void convertToDates(String startDate, String lastDate) throws ParseException {
		checkin = new SimpleDateFormat("ddMMMyyyy").parse(startDate);
		checkout = new SimpleDateFormat("ddMMMyyyy").parse(lastDate);

	}
}
