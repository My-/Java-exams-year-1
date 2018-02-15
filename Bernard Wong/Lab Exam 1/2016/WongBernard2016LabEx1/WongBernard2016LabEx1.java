// WongBernard2016LabEx1 - Bernard Wong Wei Cheng
// Sliabh Liag Manor Service Cost

import java.io.*; // Ignore 1.1
import java.util.Scanner;

public class WongBernard2016LabEx1
{
	public static void main(String[] args)throws FileNotFoundException // Ignore 1.2
	{
		// Scanner console = new Scanner(new FileReader("TestData.txt")); // Ignore 1.3

		// Constant
		final double DEPOSIT = 200.00, SINGLE_ROOM = 85.00, DOUBLE_ROOM = 175.00, LUNCH = 15.00, DINNER = 25.00, BOTH_FOOD = 32.00;
		final double ACTIVITY_1 = 100.00, ACTIVITY_2 = 175.00, ACTIVITY_3 = 225.00, ACTIVITY_4 = 275.00, ACTIVITY_5 = 325.00, ACTIVITY_6 = 375.00;
		final double DISC_6 = 0.02, DISC_10 = 0.04, DISC_15 = 0.05, DISC_FOOD = 0.05, DISC_ACTIVITY = 0.02, MAX_FOOD_DISC = 180.00, VAT_RATE = 0.09;

		// Variables
		int i, numTourist, numNights, doubleRooms, singleRooms, numGroup, numActivity, totalTourNum = 0;
		int highestGroup = 0, lowestGroup = 0, highestMember = 0, lowestMember = 0;
		double accCost, foodCost, actCost, stayCost, discAmount, vatCost, promoAmount, totalCost, averageCost;
		double accDiscRate = 0, foodDiscRate = 0, actDiscRate = 0, accDiscAmount, foodDiscAmount, actDiscAmount;
		double totalAccCost = 0, totalFoodCost = 0, totalActCost = 0, totalStayCost = 0;
		double totalDiscAmount = 0, totalVatCost = 0, totalPromoAmount = 0, finalTotalCost = 0, totalAverageCost = 0;
		double highestExpenditure = -99999.99, lowestExpenditure = 99999.99;
		char foodCategory;

		// Keyboard input
		Scanner console = new Scanner(System.in);

		// Preliminary input
		System.out.print("\nNumber of tour groups?: ");
		numGroup = console.nextInt();

		// Heading
		System.out.println("\nBernard                   Tour       Acc        Food       Act        Stay       Disc       VAT        Total       Per-");
		System.out.println("Wong Wei Cheng            No         Cost       Cost       Cost       Cost       Amt        Cost       Cost        Person");
		System.out.println("===============================================================================================================================");

		// For loop
		for (i = 1; i <= numGroup; i++)
		{
			// Input Line
			System.out.println("\nNo/Ni/Do/Si/Fo/Ac/Pr");
			numTourist = console.nextInt();
			numNights = console.nextInt();
			doubleRooms = console.nextInt();
			singleRooms = console.nextInt();
			foodCategory = console.next().charAt(0);
			numActivity = console.nextInt();
			promoAmount = console.nextDouble();

			// Calculate Accommodation Cost
			accCost = (singleRooms * SINGLE_ROOM + doubleRooms * DOUBLE_ROOM) * numNights;

			// If statement Calculate Food Cost
			if(foodCategory == 'L' || foodCategory == 'l')
			{
				foodCost = numTourist * LUNCH * numNights;
			}
			else if(foodCategory == 'D' || foodCategory == 'd')
			{
				foodCost = numTourist * DINNER * numNights;
			}
			else if(foodCategory == 'B' || foodCategory == 'b')
			{
				foodCost = numTourist * BOTH_FOOD * numNights;
			}
			else
			{
				foodCost = 0;
			} // End if

			// If statement Calculate Activity Cost
			if(numActivity == 1)
			{
				actCost = ACTIVITY_1 * numTourist;
			}
			else if(numActivity == 2)
			{
				actCost = ACTIVITY_2 * numTourist;
			}
			else if(numActivity == 3)
			{
				actCost = ACTIVITY_3 * numTourist;
			}
			else if(numActivity == 4)
			{
				actCost = ACTIVITY_4 * numTourist;
			}
			else if(numActivity == 5)
			{
				actCost = ACTIVITY_5 * numTourist;
			}
			else if(numActivity == 6)
			{
				actCost = ACTIVITY_6 * numTourist;
			}
			else
			{
				actCost = 0;
			} // End if

			// Calculation of Stay Cost
			stayCost = actCost + accCost + foodCost;

			// If statement define accommodation discount rate
			if(numNights > 4)
			{
				if(numTourist >= 15)
				{
					accDiscRate = DISC_15;
				}
				else if(numTourist >= 10)
				{
					accDiscRate = DISC_10;
				}
				else if(numTourist >= 6)
				{
					accDiscRate = DISC_6;
				}
				else
				{
					accDiscRate = 0;
				} // End nested if

			} // End if

			// Calculation of Accommodation discount amount
			accDiscAmount = accCost * accDiscRate;

			// If statement define food discount rate
			if(numTourist >= 10 && foodCategory == 'B' || foodCategory == 'b')
			{
				foodDiscRate = DISC_FOOD;

			} // End if

			// Calculation of Food discount amount
			foodDiscAmount = foodCost * foodDiscRate;

			// Food Discount Capped
			if(foodDiscAmount > 180.00)
			{
				foodDiscAmount = 180.00;
			}

			// If statement define activity discount rate
			if(numTourist >= 10 && numActivity >= 4)
			{
				actDiscRate = DISC_ACTIVITY;
			}
			else
			{
				actDiscRate = 0;
			} // End if

			// Calculation of Activity discount amount
			actDiscAmount = actCost * actDiscRate;

			// Calculation of Discount Amount
			discAmount = accDiscAmount + foodDiscAmount + actDiscRate + promoAmount;

			// Calculation of VAT Cost
			vatCost = (stayCost - discAmount) * VAT_RATE;

			// Calculation of Total Cost
			totalCost = stayCost - discAmount + vatCost;

			// Calculation of Average Cost per person
			averageCost = totalCost / numTourist;

			// Unformatted Output
			/*System.out.println("\t\t" + i + "\t" + accCost + "\t" + foodCost + "\t" + actCost + "\t"
				+ stayCost + "\t" + discAmount + "\t" + vatCost + "\t" + totalCost + "\t" + averageCost);*/

			// Formatted Output
			System.out.printf("%27d %17.2f %10.2f %10.2f %10.2f %10.2f %10.2f %10.2f %10.2f",
				i, accCost, foodCost, actCost, stayCost, discAmount, vatCost, totalCost, averageCost);

			// Calculation of totals
			totalTourNum += i;
			totalAccCost += accCost;
			totalFoodCost += foodCost;
			totalActCost += actCost;
			totalStayCost += stayCost;
			totalDiscAmount += discAmount;
			totalVatCost += vatCost;
			finalTotalCost += totalCost;
			totalAverageCost += averageCost;

			if(highestExpenditure < totalCost)
			{
				highestGroup += i;
				highestMember += numTourist;
				highestExpenditure += totalCost;
			} // End if

			if(lowestExpenditure > totalCost)
			{
				lowestGroup += i;
				lowestMember += numTourist;
				lowestExpenditure += totalCost;
			} // End if

		} // End for

		// Output Footer with totals
		System.out.println("\n===============================================================================================================================");
		System.out.printf("%28d %16.2f %10.2f %10.2f %10.2f %10.2f %10.2f %10.2f %10.2fz\n",
			totalTourNum, totalAccCost, totalFoodCost, totalActCost, totalStayCost, totalDiscAmount, totalVatCost, finalTotalCost, totalAverageCost);
		System.out.println("===============================================================================================================================\n");

		// Highest and lowest
		System.out.printf("Tour group %2d has the highest number of members at %2d with expenditure of: %8.2f\n", highestGroup, highestMember, highestExpenditure);
		System.out.printf("Tour group %2d has the lowest number of members at %2d with expenditure of: %7.2f\n", lowestGroup, lowestMember, lowestExpenditure);

	} // main

} // WongBernard2016LabEx1