// WongBernard2014LabEx2 - Bernard Wong - Mantain water usage and cost data using a seqential file

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class WongBernard2014LabEx2
{
    public static void main(String[] args)
    						throws FileNotFoundException
    {
		// Constants
		final double UNIT_COST = 0.10, WATER_COST_LIMIT = 200.00;
		final int MAX_USAGE = 4, MONTH_PER_YEAR = 12;

		// File Objects/Variables
		Scanner inWaterFile = new Scanner(new FileReader("WaterUsage.dat"));
		PrintWriter outWaterRep = new PrintWriter("WaterUsageReport.dat");
		PrintWriter outWaterFile = new PrintWriter("HighWaterUsage.dat");

		// Record Layout
		int customerID;
		char customerStat;
		String customerFirstName;
		String customerLastName;
		char customerPlan;
		double customerStandingCharge;
		int customerFreeUnits;
		int customerUsage; // 4 times

		// Other Variables
		int i, sumUnits;
		int customerCount, inactiveCount, suspendedCount, activeCount;
		int singleCount, doubleCount, concessionCount, familyCount, bigFamilyCount, pendingCount;
		int leastUnits, leastUnitsPeriod;
		int highCostLimitCount;
		String customerFullName, customerPlanName;
		String findLastName, str, message;
		String leastUnitsCustomer, highestCostCustomer, highCustomerUsage;
		double annualAverage;
		double waterUsageCost, highestCost, highCostLimit;
		boolean nameMatch;

		// Initailise variables
		customerCount = inactiveCount = suspendedCount = activeCount = 0;
		singleCount = doubleCount = concessionCount = familyCount = bigFamilyCount = pendingCount = 0;
		leastUnits = 9999;
		highestCost = -9999.99;
		leastUnitsPeriod = highCostLimitCount = 0;
		leastUnitsCustomer = highestCostCustomer = message = highCustomerUsage = "";
		nameMatch = false;
		highCostLimit = 0.0;

		// Screen/Report Header
		System.out.println("\nBernard Wong - Lab Exam 2 (December 2014)");
		System.out.println("\n  Id     Name          Plan  Stand  Free   Q1   Q2   Q3   Q4   Sum  Avg    Cost");
		System.out.println("===============================================================================");

		outWaterRep.printf("Bernard Wong - Lab Exam 2 (December 2014)%n");
		outWaterRep.printf("%n  Id     Name          Plan  Stand  Free   Q1   Q2   Q3   Q4   Sum  Avg    Cost%n");
		outWaterRep.printf("===============================================================================%n");

		// Input Dialog
		findLastName = JOptionPane.showInputDialog("Find Customer Last Name:", "Wong");
		str = JOptionPane.showInputDialog("Enter Water Cost Limit:", WATER_COST_LIMIT);

		// Main while loop file Input until EOF
		while(inWaterFile.hasNext())
		{
			// Reset Variables
			sumUnits = 0;
			annualAverage = 0;
			highCustomerUsage = "";

			// File input
			customerID = inWaterFile.nextInt();
			customerStat = inWaterFile.next().charAt(0);
			customerFirstName = inWaterFile.next();
			customerLastName = inWaterFile.next();
			customerPlan = inWaterFile.next().charAt(0);
			customerStandingCharge = inWaterFile.nextDouble();
			customerFreeUnits = inWaterFile.nextInt();

			customerFullName = customerLastName + "," + customerFirstName; // full name

			// Find Last Name
			if(findLastName.equalsIgnoreCase(customerLastName))
			{
				nameMatch = true;
				message += customerID + " " + customerStat + " " + customerFullName + " " + customerPlan + "\n";
			} // if

			// Customer Status to process or not
			if(customerStat == 's' || customerStat == 'S')
			{
				++suspendedCount;
				inWaterFile.nextLine();
			}
			else if(customerStat == 'x' || customerStat == 'X')
			{
				++inactiveCount;
				inWaterFile.nextLine();
			}
			else
			{
				++activeCount;

				// Determine
				switch(customerPlan)
					{
						case '1':
							customerPlanName = "Single";
							++singleCount;
							break;
						case '2':
							customerPlanName = "Double";
							++doubleCount;
							break;
						case 'c':
						case 'C':
							customerPlanName = "Concess";
							++concessionCount;
							break;
						case 'f':
						case 'F':
							customerPlanName = "Family";
							++familyCount;
							break;
						case 'b':
						case 'B':
							customerPlanName = "Big Fam";
							++bigFamilyCount;
							break;
						default:
							customerPlanName = "Pending";
							++pendingCount;
				} // switch

				// Screen Line Output & Report
				System.out.printf("%4d %-14s %7s %6.2f %5d ", customerID, customerFullName, customerPlanName, customerStandingCharge, customerFreeUnits);
				outWaterRep.printf("%4d %-14s %7s %6.2f %5d ", customerID, customerFullName, customerPlanName, customerStandingCharge, customerFreeUnits);

			   // Inner for Customer Usage
			   for(i = 1; i <= MAX_USAGE; i++)
			   {
				   customerUsage = inWaterFile.nextInt();
				   System.out.printf("%4d ", customerUsage); // Line output
				   outWaterRep.printf("%4d ", customerUsage); // Report
				   sumUnits += customerUsage; // sum units
				   highCustomerUsage += String.format("%5d", customerUsage); // outWaterFile

				   // Least Unit customer
				   if(leastUnits > customerUsage && customerUsage != 0)
				   {
						leastUnits = customerUsage;
						leastUnitsPeriod = i;
						leastUnitsCustomer = customerFirstName + " " + customerLastName;
				   } // if

			    } // inner for

				// Calculate average
				annualAverage = (double)sumUnits / MONTH_PER_YEAR;

				// Calculate total usage cost
				waterUsageCost = (sumUnits - customerFreeUnits) * UNIT_COST + customerStandingCharge;

				if(waterUsageCost < customerStandingCharge) // cannot be less than standing charge
				{
					waterUsageCost = customerStandingCharge;
				} // if

				// Additional Outputs
				System.out.printf("%5d %4.0f %7.2f\n", sumUnits, annualAverage, waterUsageCost);
				outWaterRep.printf("%5d %4.0f %7.2f%n", sumUnits, annualAverage, waterUsageCost);

				// highest cost customer
				if(highestCost < waterUsageCost)
				{
					highestCost = waterUsageCost;
					highestCostCustomer = customerFirstName + " " + customerLastName;
				} // if

				// High Usage Water
				highCostLimit = Double.parseDouble(str);
				if(waterUsageCost > highCostLimit)
				{
					++highCostLimitCount;
					outWaterFile.printf("%4d %1c %-10s %-10s %1c %6.2f %5d %20s %5d %4.0f %7.2f%n"
											, customerID, customerStat, customerFirstName, customerLastName
											, customerPlan, customerStandingCharge,  customerFreeUnits, highCustomerUsage
											, sumUnits, annualAverage, waterUsageCost);
				} // if

			} // big if

			++customerCount;
	    } // while

		// Output Footer details to Screen and Report
		System.out.printf("\n    Customers: %3d     Inactive: %3d    Suspended: %3d       Active: %3d\n"
							, customerCount, inactiveCount, suspendedCount, activeCount);
		System.out.printf("       Single: %3d       Double: %3d   Concession: %3d\n"
							, singleCount, doubleCount, concessionCount);
		System.out.printf("       Family: %3d   Big Family: %3d      Pending: %3d\n"
							, familyCount, bigFamilyCount, pendingCount);
		System.out.printf("\nLeast units: %1d used in quarter: %1d by: %12s\n", leastUnits, leastUnitsPeriod, leastUnitsCustomer);
		System.out.printf("\nMost expensive Water cost: %6.2f used by: %13s\n", highestCost, highestCostCustomer);
		System.out.printf("\n%1d High usage Water cost records >= %6.2f Output\n", highCostLimitCount, highCostLimit);

		outWaterRep.printf("%n    Customers: %3d     Inactive: %3d    Suspended: %3d       Active: %3d%n"
							, customerCount, inactiveCount, suspendedCount, activeCount);
		outWaterRep.printf("       Single: %3d       Double: %3d   Concession: %3d%n"
							, singleCount, doubleCount, concessionCount);
		outWaterRep.printf("       Family: %3d   Big Family: %3d      Pending: %3d%n"
							, familyCount, bigFamilyCount, pendingCount);
		outWaterRep.printf("%nLeast units: %1d used in quarter: %1d by: %12s%n", leastUnits, leastUnitsPeriod, leastUnitsCustomer);
		outWaterRep.printf("%nMost expensive Water cost: %6.2f used by: %13s%n", highestCost, highestCostCustomer);
		outWaterRep.printf("%n%1d High usage Water cost records >= %6.2f Output%n", highCostLimitCount, highCostLimit);

		// Close files
		inWaterFile.close();
		outWaterRep.close();
		outWaterFile.close();

		// Message Dialog
		if(nameMatch == true)
		{
			JOptionPane.showMessageDialog(null, message , "Lastnames Found - Bernard Wong", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry Lastname: " + findLastName + " not found - please try again", "Lastnames Found - Bernard Wong", JOptionPane.ERROR_MESSAGE);
		} // if

		// Exit
		System.exit(0);
    }  // main

} // WongBernard2014LabEx2