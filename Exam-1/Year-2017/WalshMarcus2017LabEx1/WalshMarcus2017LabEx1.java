//SdPd/java Lab Exam 1 - Marcus Walsh
//G-Uber taxi trip fare calculator, calculates individual fares and additional charges associated with the services on offer

import java.io.*; // Ignore 1.1
import java.util.Scanner;

public class WalshMarcus2017LabEx1
{
	public static void main(String[] args)throws FileNotFoundException // Ignore 1.2
	{
		//Constants
		final int NUM_TRIPS;
		final double STANDARD_CHARGE = 2.10,
			PREMIUM_CHARGE = 2.90,
			ADDITIONAL_PASSENGER = 1.00,
			FARE_A = 1.10,
			FARE_B = 1.45,
			FARE_C = 1.40,
			FARE_D = 1.65,
			ADDOMODATION_CHARGE = 10.00,
			MAX_CARD_CHARGE = 0.05,
			MIN_CARD_CHARGE = 0.03,
			DISC_50 = 0.05,
			DISC_100 = 0.06,
			DISC_150 = 0.07,
			VAT_RATE = 0.23,
			AVERAGE_DISCOUNT;

		//Variables
		int i;
		int passengers;
		double distance;
		char fare;
		double cardCharge;
		char accomodation;
		double fareCost,
			passengerFee,
			accomoCost,
			fullCost,
			cardCost,
			discCost,
			netCost,
			vatCost,
			finalCost;
		double highestTripFare = 0, lowestTripFare = 21470000;
		int highestTrip = 0, lowestTrip = 0;
		double totalFareCost = 0,
			totalPFee = 0,
			totalAccomoCost = 0,
			totalFullCost = 0,
			totalCardCost = 0,
			totalDiscCost = 0,
			totalNetCost = 0,
			totalVatCost = 0,
			totalFinalCost = 0;
		int totalTripsA = 0,
			totalTripsB = 0,
			totalTripsC = 0,
			totalTripsD = 0,
			numDiscounts = 0;
		//Scanner console = new Scanner(new FileReader("LabEx1.txt")); // Ignore 1.3
		Scanner console = new Scanner(System.in);

		System.out.print("Enter number of trips today: ");
		NUM_TRIPS = console.nextInt();

		System.out.println();
		System.out.println();
		System.out.println("Walsh Marcus Lab Exam 1	  TRIP  FARE	P-FEE   ACCO	FULL	CARD	DISC	 NET	 VAT   FINAL");
		System.out.println("=========================================================================================================");

		for (i = 1; i <= NUM_TRIPS; i++)
		{
			System.out.println("Pas/Dist/Fare/CCard/Acc " + i + ":");
			passengers = console.nextInt();
			distance = console.nextDouble();
			fare = console.next().charAt(0);
			cardCharge = console.nextDouble();
			accomodation = console.next().charAt(0);

			if (fare == 'S' || fare == 's')
			{
				fareCost = STANDARD_CHARGE;
				if (distance <= 15)
				{
					fareCost += distance * FARE_A;
					totalTripsA++;
				}
				else
				{
					fareCost += distance * FARE_B;
					totalTripsB++;
				}
			}
			else if (fare == 'P' || fare == 'p')
			{
				fareCost = PREMIUM_CHARGE;
				if (distance <= 15)
				{
					fareCost += distance * FARE_C;
					totalTripsC++;
				}
				else
				{
					fareCost += distance * FARE_D;
					totalTripsD++;
				}
			}
			else
			{
				fareCost = 0;
			}

			passengerFee = (passengers - 1) * ADDITIONAL_PASSENGER;

			if (accomodation == 'Y' || accomodation == 'y')
			{
				accomoCost = ADDOMODATION_CHARGE;
			}
			else
			{
				accomoCost = 0;
			}

			fullCost = fareCost + passengerFee + accomoCost;

			cardCost = cardCharge / 100;
			cardCost = Math.min(cardCost, MAX_CARD_CHARGE);
			cardCost *= fullCost;

			if (distance > 150)
			{
				discCost = fullCost * DISC_150;
				numDiscounts++;
			}
			else if (distance > 100)
			{
				discCost = fullCost * DISC_100;
				numDiscounts++;
			}
			else if (distance > 50)
			{
				discCost = fullCost * DISC_50;
				numDiscounts++;
			}
			else
			{
				discCost = 0;
			}

			netCost = fullCost + cardCost - discCost;
			vatCost = netCost * VAT_RATE;
			finalCost = netCost + vatCost;

			if (lowestTripFare > finalCost)
			{
				lowestTripFare = finalCost;
				lowestTrip = i;
			}

			if (highestTripFare < finalCost)
			{
				highestTripFare = finalCost;
				highestTrip = i;
			}

			totalFareCost += fareCost;
			totalPFee += passengerFee;
			totalAccomoCost += accomoCost;
			totalFullCost += fullCost;
			totalCardCost += cardCost;
			totalDiscCost += discCost;
			totalNetCost += netCost;
			totalVatCost += vatCost;
			totalFinalCost += finalCost;

		//	System.out.println(fareCost + " " + passengerFee + " " + accomoCost + " " + fullCost + " "
		//		+ cardCost + " " + discCost + " " + netCost + " " + vatCost + " " + finalCost);
			System.out.printf("%31d%8.2f%9.2f%7.2f%8.2f%8.2f%8.2f%8.2f%8.2f%8.2f\n", i, fareCost,
				passengerFee, accomoCost, fullCost, cardCost, discCost, netCost, vatCost, finalCost);
		} // for

		System.out.println("=========================================================================================================");
		System.out.printf("%39.2f%9.2f%7.2f%8.2f%8.2f%8.2f%8.2f%8.2f%8.2f\n", totalFareCost, totalPFee, totalAccomoCost,
			totalFullCost, totalCardCost, totalDiscCost, totalNetCost, totalVatCost, totalFinalCost);
		System.out.println("=========================================================================================================");

		System.out.println("  " + totalTripsA + " Trip(s) were fare category A");
		System.out.println("  " + totalTripsB + " Trip(s) were fare category B");
		System.out.println("  " + totalTripsC + " Trip(s) were fare category C");
		System.out.println("  " + totalTripsD + " Trip(s) were fare category D");

		System.out.println();
		System.out.printf("Trip: %d had the highest fare at :%7.2f euro\n",highestTrip, highestTripFare);
		System.out.printf("Trip: %d had the lowest fare at  :%7.2f euro\n", lowestTrip, lowestTripFare);
		System.out.println();

		AVERAGE_DISCOUNT = totalDiscCost / numDiscounts;
		System.out.printf("The average discount was: %.2f euro\n", AVERAGE_DISCOUNT);
		System.out.println("\n=========================================================================================================");

	} // main

} // WalshMarcus2017LabEx1