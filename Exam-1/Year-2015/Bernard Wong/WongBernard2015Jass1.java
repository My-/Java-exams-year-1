// WongBernard2015Jass1 - Bernard Wong Wei Cheng
// Connacht Weight Management Solutions

import java.io.*; // Ignore 1
import java.util.Scanner; // Scanner import

public class WongBernard2015Jass1
{
	public static void main(String[] args)throws FileNotFoundException // Ignore 2
	{
		// Scanner console = new Scanner(new FileReader("TestBMI.txt")); // Ignore 3

		// Constants
		final double UNDER_WEIGHT = 100.00, NORMAL_WEIGHT = 120.00, OVER_WEIGHT = 155.00, SEVERE_WEIGHT = 200.00, TEE_SHIRT = 5.00,
						DISC_FRIEND_REFER = 0.02, DISC_RETURN_CLIENT = 0.035, DISC_CORPORATE = 0.04, VAT_RATE = 0.23; // all initialised

		// Variables
		int i, maxClient, months;
		int highestClientNum = 0, lowestClientNum = 0; // Highest and Lowest Client Number
		double height, weight, promoValue, bmi, packageCost, discAmount, teeShirtCost, fullCost, vatCost, finalCost, discRate = 0;
		double totalPackageCost = 0, totalDiscAmount = 0, totalPromoValue = 0, totalFullCost = 0, totalVatCost = 0, totalFinalCost = 0; // totals
		double lowestPackageCost = 9999.99, highestPackageCost = -9999.99; // Highest and Lowest Package Cost
		char bmiType, teeShirt, discType;

		// Keyboard Scanner
		Scanner console = new Scanner(System.in);

		// Input number of clients
		System.out.print("\nEnter number of clients: ");
		maxClient = console.nextInt();
		System.out.println();

		// Header
		System.out.println("Lab Exam 1\t\t\t\tClient   BMI       BMI   Package   Discount   Promo    Full    Vat     Final");
		System.out.println("Bernard Wong Wei Cheng\t\t\tNumber   Number   Type   Cost      Amount     Value    Cost    Cost    Cost\n");
		System.out.println("======================================================================================================================\n");

		// For Loop
		for(i = 1; i <= maxClient; i++)
		{
			// Input details
			System.out.println("Kilos/Metres/Months/TShirt/Disc/Promo/: ");
			weight = console.nextDouble();
			height = console.nextDouble();
			months = console.nextInt();
			teeShirt = console.next().charAt(0);
			discType = console.next().charAt(0);
			promoValue = console.nextDouble();

			bmi = weight / (height * height); // bmi Calculation

			if(bmi < 18.5) // Bmi Type and Package Cost
			{
				bmiType = 'U';
				packageCost = UNDER_WEIGHT;
			}
			else if (bmi >= 18.5 && bmi <= 24.9)
			{
				bmiType = 'N';
				packageCost = NORMAL_WEIGHT;
			}
			else if (bmi >= 25 && bmi <= 29.9)
			{
				bmiType = 'O';
				packageCost = OVER_WEIGHT;
			}
			else
			{
				bmiType = 'S';
				packageCost = SEVERE_WEIGHT;
			} // end if

			packageCost *= months; // packageCost Calculation

			if(discType == 'F' || discType == 'f') // discRate Calculation
			{
				discRate = DISC_FRIEND_REFER;
			}
			else if(discType == 'R' || discType == 'r')
			{
				discRate = DISC_RETURN_CLIENT;
			}
			else if(discType == 'C' || discType == 'c')
			{
				discRate = DISC_CORPORATE;
			}
			else if(discType == 'P' || discType == 'p')
			{
				if(packageCost > 450) // nested if for discType P
				{
					discRate = 0.06;
				}
				else if(packageCost >= 300)
				{
					discRate = 0.04;
				}
				else if(packageCost > 150)
				{
					discRate = 0.02;
				}
				else
				{
					discRate = 0.00;
			 	} // end nested if
			}
			else
			{
				discRate = 0;
			} // end if

			if(teeShirt == 'Y' || teeShirt == 'y') // define teeShirtCost
			{
				teeShirtCost = TEE_SHIRT;
			}
			else
			{
				teeShirtCost = 0;
			} // end if

			// Calculation of discAmount/fullCost/vatCost/finalCost
			discAmount = packageCost * discRate;
			fullCost = (packageCost - discAmount) + teeShirtCost - promoValue;
			vatCost = fullCost * VAT_RATE;
			finalCost = fullCost + vatCost;

			// Calculation of Totals
			totalPackageCost += packageCost;
			totalDiscAmount += discAmount;
			totalPromoValue += promoValue;
			totalFullCost += fullCost;
			totalVatCost += vatCost;
			totalFinalCost += finalCost;

			// Calculate highest and lowest package cost
			if(packageCost < lowestPackageCost)
			{
				lowestPackageCost = packageCost;
				lowestClientNum = i;
			} // end if

			if(packageCost > highestPackageCost)
			{
				highestPackageCost = packageCost;
				highestClientNum = i;
			} // end if

			// Unformatted Output
			//System.out.println("\t\t\t\t\t " + i + "\t" + bmi + "\t" + bmiType + "\t" + packageCost + "\t" + discAmount + "\t" + promoValue + "\t" + fullCost + "\t" + vatCost + "\t" + finalCost);

			// Formatted Output
			System.out.printf("%42d %10.2f %7c %10.2f %10.2f %7.2f %8.2f %8.2f %8.2f\n", i, bmi, bmiType, packageCost, discAmount, promoValue, fullCost, vatCost, finalCost);

		} // end for

		// Footer with Totals
		System.out.println("======================================================================================================================");
		System.out.printf("\t\t\t\t\t Totals: %23.2f %10.2f %7.2f %8.2f %8.2f %8.2f\n", totalPackageCost, totalDiscAmount, totalPromoValue, totalFullCost, totalVatCost, totalFinalCost);
		System.out.println("======================================================================================================================\n\n");

		// Output Highest and Lowest Package Cost
		System.out.printf("Client %3d has the  lowest  package cost of: %6.2f\n", lowestClientNum, lowestPackageCost);
		System.out.printf("Client %3d has the highest package cost of: %6.2f\n\n", highestClientNum, highestPackageCost);

	} // main

} // WongBernard2015Jass1