// WongBernard2015LabEx2 - Bernard Wong - Mantain Helpdesk Using A Sequential Text File

// Imports
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class WongBernard2015LabEx2
{
    public static void main(String[] args)
    						throws FileNotFoundException
    {
		// Constants
		final double ESSENTIAL_COST = 15.00, STANDARD_COST = 25.00, PRO_COST = 35.00, BUSINESS_COST = 50.00;
		final double HOURLY_COST = 8.00, HIGH_COST_LIMIT = 60.00;
		final int MAX_WEEKS = 3;

		// Record Layout
		int helpAccountId;
		String helpOrgName;
		String helpFirstName;
		String helpLastName;
		char helpAccountPlan;
		int helpHoursAllowed;
		int helpHoursUsed; // 3 times

		// Other Variables
		int i, sumHours, hoursOver, helpdeskCount, highCostLimitCount;
		int fCount, eCount, sCount, pCount, bCount;
		String contactFullName, accountPlanName;
		String findLastName, lowCostName, highCostName;
		double packageCost, additionalCost, highCostLimit, helpdeskCost;
		double lowCost, highCost;
		boolean nameMatch = false;
		String message, str;

		// File Objects/Variables
		Scanner inHelpdeskFile = new Scanner(new FileReader("HelpdeskUsage.dat"));
		PrintWriter outHelpdeskRep = new PrintWriter("HelpdeskUsageReport.dat");
		PrintWriter outHelpdeskFile = new PrintWriter("HighHelpdeskUsage.dat");

		// Initialise Variables
		sumHours = hoursOver = helpdeskCount = highCostLimitCount = 0;
		fCount = eCount = sCount = pCount = bCount = 0;
		highCostLimit = 0.00;
		lowCost = 99999.99;
		highCost = -99999.99;
		lowCostName = highCostName = message = "";

		// Screen/Report Header
		System.out.println("\nBernard Wong - Lab Exam 2 (December 2015)");
		System.out.println("\n Id  Contact Name  Org Name     Plan       Allowed   Wk1  Wk2   Wk3  Sum   Cost");
		System.out.println("================================================================================\n");
		outHelpdeskRep.printf("Bernard Wong - Lab Exam 2 (December 2015)%n");
		outHelpdeskRep.printf("%n Id  Contact Name  Org Name     Plan       Allowed   Wk1  Wk2   Wk3  Sum   Cost");
		outHelpdeskRep.printf("%n================================================================================%n");

		// Input Dialog
		findLastName = JOptionPane.showInputDialog("Find Contact Last Name:", "Wong");
		str = JOptionPane.showInputDialog("Enter Helpdesk Cost Limit:", HIGH_COST_LIMIT);

		// Main while loop file Input until EOF
		while (inHelpdeskFile.hasNext())
		{
			// Reset Variables
			sumHours = 0;

			// File Input
			helpAccountId = inHelpdeskFile.nextInt();
			helpOrgName = inHelpdeskFile.next();
			helpFirstName = inHelpdeskFile.next();
			helpLastName = inHelpdeskFile.next();
			helpAccountPlan = inHelpdeskFile.next().charAt(0);
			helpHoursAllowed = inHelpdeskFile.nextInt();

			contactFullName = helpLastName + "," + helpFirstName; // full name

			// Find Last Name
			if(findLastName.equalsIgnoreCase(helpLastName))
			{
				nameMatch = true;
				message += helpAccountId + " " + contactFullName + " " + helpAccountPlan + "\n";
			} // if

			// Ignore Free Trail Using If
			if(helpAccountPlan == 'f' || helpAccountPlan == 'F')
			{
				++fCount;
				inHelpdeskFile.nextLine();
			}
			else{
				// Determine Account Plan Name and Cost
				switch(helpAccountPlan)
				{
					case 'e':
					case 'E':
						accountPlanName = "Essential";
						packageCost = ESSENTIAL_COST;
						++eCount;
						break;
					case 's':
					case 'S':
						accountPlanName = "Standard";
						packageCost = STANDARD_COST;
						++sCount;
						break;
					case 'p':
					case 'P':
						accountPlanName = "Profession";
						packageCost = PRO_COST;
						++pCount;
						break;
					case 'b':
					case 'B':
						accountPlanName = "Business";
						packageCost = BUSINESS_COST;
						++bCount;
						break;
					default:
						accountPlanName = "Invalid";
						packageCost = 0;
				} // switch

				// Screen Line Output & Report
				System.out.printf("%4d %-13s %-12s %-14s %2d", helpAccountId, contactFullName, helpOrgName, accountPlanName, helpHoursAllowed);
				outHelpdeskRep.printf("%4d %-13s %-12s %-14s %2d", helpAccountId, contactFullName, helpOrgName, accountPlanName, helpHoursAllowed);

			   // For loop input and output 3 times hours used
			   for(i = 1; i <= MAX_WEEKS; i++)
				{
				   helpHoursUsed = inHelpdeskFile.nextInt();
				   System.out.printf("%6d", helpHoursUsed);
				   sumHours += helpHoursUsed; // sum hours used
				} // for

				// Calculation of Cost
				if(sumHours > helpHoursAllowed)
				{
					hoursOver = sumHours - helpHoursAllowed;
					additionalCost = hoursOver * HOURLY_COST;
				}
				else
				{
					additionalCost = 0;
				}
				helpdeskCost = packageCost + additionalCost;

				// Additional Outputs
				System.out.printf("%4d %8.2f\n", sumHours, helpdeskCost);
				outHelpdeskRep.printf("%4d %8.2f%n", sumHours, helpdeskCost);

				// Footers Determination
				++helpdeskCount;

				if(lowCost > helpdeskCost) // lowest
				{
					lowCost = helpdeskCost;
					lowCostName = helpOrgName;
				} // if

				if(highCost < helpdeskCost) // highest
				{
					highCost = helpdeskCost;
					highCostName = helpOrgName;
				} // if

				// Helpdesk Cost above limit
				highCostLimit = Double.parseDouble(str);
				if(helpdeskCost >= highCostLimit)
				{
					++highCostLimitCount;
					outHelpdeskFile.printf("%4d %-13s %-12s %-14s %2d %8.2f%n", helpAccountId, helpOrgName, contactFullName, accountPlanName, helpHoursAllowed, helpdeskCost);
				} // if
			} // else if

		} // while EOF

		// Output Footer details to Screen & Report
		System.out.printf("\nActive Customers: %3d   Free Trail: %3d    Essential: %3d\n", helpdeskCount, fCount, eCount);
		outHelpdeskRep.printf("%nActive Customers: %3d   Free Trail: %3d    Essential: %3d%n", helpdeskCount, fCount, eCount);
		System.out.printf("        Standard: %3d Proffesional: %3d    Business:  %3d\n", sCount, pCount, bCount);
		outHelpdeskRep.printf("        Standard: %3d Proffesional: %3d    Business:  %3d%n", sCount, pCount, bCount);
		System.out.printf("\nLowest Helpdesk Cost:  %5.2f used by: %5s\n", lowCost, lowCostName);
		outHelpdeskRep.printf("%nLowest Helpdesk Cost:  %5.2f used by: %5s%n", lowCost, lowCostName);
		System.out.printf("\nHighest Helpdesk Cost: %5.2f used by: %5s\n", highCost, highCostName);
		outHelpdeskRep.printf("%nHighest Helpdesk Cost: %5.2f used by: %5s%n", highCost, highCostName);
		System.out.printf("\n%1d Helpdesk Costs above the limit >= %6.2f Output\n", highCostLimitCount, highCostLimit);
		outHelpdeskRep.printf("%n%1d Helpdesk Costs above the limit >= %6.2f Output%n", highCostLimitCount, highCostLimit);

		// Close files
		inHelpdeskFile.close();
		outHelpdeskRep.close();
		outHelpdeskFile.close();

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

    } // main

} // WongBernard2015LabEx2