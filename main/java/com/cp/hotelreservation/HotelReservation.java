package com.cp.hotelreservation;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	static List<Hotel> hotelList = new ArrayList<>();

	public static void addHotel(String hotelName, int rate) {
		hotelList.add(new Hotel(hotelName , rate));
	}

}
