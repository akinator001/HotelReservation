package com.cp.hotelreservation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class HotelTest {
	@Test
	public void checkCheapestHotelForRegularCustomerInWeekdayRate() throws ParseException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("LakeWood", 110 , 90, 3, 80 , 80);
		hotelReservation.addHotel("BridgeWood", 150 , 50, 4, 110 , 50);
		hotelReservation.addHotel("RidgeWood", 220 , 150, 5, 100 , 40 );
		String hotel = hotelReservation.findCheapestHotel("10Sep2020","11Sep2020");
	    Assert.assertEquals("LakeWood", hotel);
	}
	
	@Test
	public void checkCheapestHotelForRegularCustomerInWeekdayWeekendRate() throws ParseException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("LakeWood", 110 , 90, 3, 80 , 80);
		hotelReservation.addHotel("BridgeWood", 150 , 50, 4, 110 , 50);
		hotelReservation.addHotel("RidgeWood", 220 , 150, 5, 100 , 40 );
		List<String> hotel = hotelReservation.findCheapestHotelWeekdayAndWeekend("10Sep2020","11Sep2020");

		List<String> expectedHotel = new ArrayList<>(Arrays.asList("LakeWood","BridgeWood"));

		Assert.assertEquals(expectedHotel , hotel);
	}	
	
	@Test
	public void checkCheapestBestRatedHotelForRegularCustomers() throws ParseException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("LakeWood", 110 , 90, 3, 80 , 80);
		hotelReservation.addHotel("BridgeWood", 150 , 50, 4, 110 , 50);
		hotelReservation.addHotel("RidgeWood", 220 , 150, 5, 100 , 40 );
		String hotel = hotelReservation.findCheapestBestRatedHotelForRegularCustomer("10Sep2020","11Sep2020");
		Assert.assertEquals("BridgeWood", hotel);
	}
	
	@Test
	public void checkBestRatedHotel() throws ParseException {
		HotelReservation hotelReservation = new HotelReservation();
		String hotel = hotelReservation.findBestRatedHotel("10Sep2020","11Sep2020");
	    Assert.assertEquals("RidgeWood", hotel);
	}
	
	@Test
	public void checkCheapestBestRatedHotelForRewardCustomers() throws ParseException{
		HotelReservation hotelReservation = new HotelReservation();
		String hotel = hotelReservation.findCheapestBestRatedHotelForRewardCustomer("10Sep2020", "11Sep2020");
	    Assert.assertEquals("RidgeWood", hotel);
	}
	
	@Test
	public void checkDateFormat() {
		HotelReservation hotelReservation = new HotelReservation();
		try {
			String hotel = hotelReservation.findBestRatedHotel("012021", "31Sep");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.assertTrue(true);
		}
	}
}
