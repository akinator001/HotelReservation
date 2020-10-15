package com.cp.hotelreservation;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;


public class HotelTest {
	@Test
	public void checkCheapestHotelForRegularCustomerInWeekdayRate() throws ParseException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("LakeWood", 110);
		hotelReservation.addHotel("BridgeWood", 150);
		hotelReservation.addHotel("RidgeWood", 220);
		String hotel = hotelReservation.findCheapestHotel("10Sep2020","11Sep2020");
	    Assert.assertEquals("LakeWood", hotel);
	}
}
