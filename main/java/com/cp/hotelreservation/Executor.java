package com.cp.hotelreservation;

import java.util.Scanner;

public class Executor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Enter hotel name");
			String hotel_name = sc.next();
			System.out.println("Enter rate for regular customer");
			int rate = sc.nextInt();

			HotelReservation.addHotel(hotel_name, rate);
			System.out.println("To add more hotel Y/N");
			char choice = sc.next().charAt(0);
			if (choice == 'Y' || choice == 'y')
				continue;
			else
				break;
		}
		
	}
}
