package com.cp.hotelreservation;

import java.text.ParseException;
import java.util.Scanner;

public class Executor {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		HotelReservation hotelReservation = new HotelReservation();
		
		while (true) {

			System.out.println("Enter hotel name : ");
			String hotel_name = sc.next();
			System.out.println("Enter rate for regular customer on weekday");
			int weekdayRate = sc.nextInt();
			System.out.println("Enter rate for regular customer on weekend");
			int weekendRate = sc.nextInt();
			System.out.println("Enter rating of hotel");
			int rating = sc.nextInt();
			System.out.println("Enter special rate for loyal customer for weekdays");
			int rewardCustomerWeekday=sc.nextInt();
			System.out.println("Enter special rate for loyal customer for weekend");
			int rewardCustomerWeekend=sc.nextInt();
			
			hotelReservation.addHotel(hotel_name, weekdayRate,weekendRate,rating,rewardCustomerWeekday,rewardCustomerWeekend);
			System.out.println("To add more hotel Y/N");
			char choice = sc.next().charAt(0);
			if (choice == 'Y' || choice == 'y')
				continue;
			else
				break;
		}
		System.out.println("Find the cheapest hotel within given date range");
		System.out.println("Enter start date in format (ddMMMyyy)");
		String startDate = sc.next();
		System.out.println("Enter last date in format (ddMMMyyyy)");
		String lastDate = sc.next();
		System.out.print(hotelReservation.findCheapestHotel(startDate, lastDate));
		System.out.print(hotelReservation.findCheapestHotelWeekdayAndWeekend(startDate, lastDate));
		System.out.print(hotelReservation.findBestRatedHotel(startDate, lastDate));
		System.out.println(hotelReservation.findCheapestBestRatedHotelForRewardCustomer(startDate, lastDate));
		System.out.println(hotelReservation.findCheapestBestRatedHotelForRegularCustomer(startDate, lastDate));
	}
}
