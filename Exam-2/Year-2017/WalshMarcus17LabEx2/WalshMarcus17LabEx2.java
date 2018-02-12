// WalshMarcus17LabEx2 - Marcus Walsh
// Galway Gyms class and pay management

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class WalshMarcus17LabEx2
{
    public static void main(String[] args)
                throws FileNotFoundException
    {
		// Constants
		final int NUM_WEEKS = 5;
		final double PAY_20 = 22,
			PAY_OVER = 25,
			SALARY = 600;

		// File Objects
        Scanner inInstructorFile = new Scanner(new FileReader("InstructorDetails.dat"));
        PrintWriter outInstructorRep = new PrintWriter("InstructorReport.dat");
        PrintWriter outPlacementRep = new PrintWriter("PlacementRep.dat");
        PrintWriter outPayClassFile = new PrintWriter("PayByClass.dat");

        // InstructorDetails.dat field headers
        int instructorId;
		char instructorGym;
		String instructorLastName;
		String instructorFirstName;
		char instructorPay;
		int instructorClasses; // * 5

        // Variables
        int i;
        String fullName,
        	gymName = "",
        	payCodeName = "";
 		int totalClasses;
        double payRate = 0;
        int lowestClasses = Integer.MAX_VALUE;
        int highestClasses = Integer.MIN_VALUE;
        String lowestName = "",
        	lowestGym = "";
        String highestName = "",
        	highestGym = "";
        int sCount,
        	rCount,
        	mCount,
        	bCount,
        	aCount,
        	instructorCount,
        	placementCount,
        	byClassCount,
        	bySalaryCount;
        String inpStr;
        double payLimit;
        int payLimitCount;
        String findGymName;
        double totalFoundSalary = 0;
        String message = "";
        String title;

		// Initialize totals
        sCount = rCount = mCount = bCount = aCount = instructorCount =
        	placementCount = byClassCount = bySalaryCount = payLimitCount = 0;

        findGymName = JOptionPane.showInputDialog("Find Gym Name:", "Renmore");
        inpStr = JOptionPane.showInputDialog("Enter pay limit for instructor:", "1000.00");
        payLimit = Double.parseDouble(inpStr);

        // Screenshot 1 doesn't show name at top, but screenshot 3 does, I'm assuming it's supposed to be there
        System.out.println("Marcus Walsh - Lab Exam 2 (December 2017)");
        outInstructorRep.println("Marcus Walsh - Lab Exam 2 (December 2017)");

        System.out.println("\nId  Gym      Instructor Name   Pay Code       wk1 wk2 wk3 wk4 wk5 Total   Pay");
        outInstructorRep.println("Id  Gym      Instructor Name   Pay Code       wk1 wk2 wk3 wk4 wk5 Total   Pay");
        System.out.println("=================================================================================\n");
        outInstructorRep.println("=================================================================================");

		outPlacementRep.println("                      ID  Gym   Instructor   Pay Code");
		outPlacementRep.println("=========================================================");

        while (inInstructorFile.hasNext())
        {
            instructorId = inInstructorFile.nextInt();
			instructorGym = inInstructorFile.next().charAt(0);
			instructorLastName = inInstructorFile.next();
			instructorFirstName = inInstructorFile.next();
			instructorPay = inInstructorFile.next().charAt(0);

            fullName = instructorLastName + ", " + instructorFirstName;

            if (instructorGym == 'P' || instructorGym == 'p')
            {
				placementCount++;
                outPlacementRep.printf("Placement Instructor: %d %3s %-17s %s%n",
                instructorId, instructorGym, fullName, instructorPay);
                inInstructorFile.nextLine();
            }
            else
            {
				instructorCount++;

				switch (instructorGym)
				{
					case 'a':
					case 'A':
						gymName = "Athenry";
						aCount++;
						break;
					case 'r':
					case 'R':
						gymName = "Renmore";
						rCount++;
						break;
					case 'b':
					case 'B':
						gymName = "Barna";
						bCount++;
						break;
					case 's':
					case 'S':
						gymName = "Salthill";
						sCount++;
						break;
					case 'm':
					case 'M':
						gymName = "Merlin";
						mCount++;
						break;
					default:
						gymName = "Placement";
				} // Switch

				if (instructorPay == 'C' || instructorPay == 'c')
				{
					payCodeName = "By Class";
					byClassCount++;
				}
				else if (instructorPay == 'S' || instructorPay == 's')
				{
					payCodeName = "Salary";
					bySalaryCount++;
				}
				else
				{
					payCodeName = "Code Invalid";
				}

                System.out.printf("%2d %-8s %-17s %-12s",
                    instructorId, gymName, fullName, payCodeName);
                outInstructorRep.printf("%2d %-8s %-17s %-12s",
                    instructorId, gymName, fullName, payCodeName);

                totalClasses = 0;

                for (i = 1; i <= NUM_WEEKS; i++)
                {
					instructorClasses = inInstructorFile.nextInt();
					System.out.printf(" %3d", instructorClasses);
					outInstructorRep.printf(" %3d", instructorClasses);
					totalClasses += instructorClasses;

					// Screenshot shows highest weekly classes, not the total classes
					if (instructorClasses > highestClasses)
					{
						highestClasses = instructorClasses;
						highestName = instructorFirstName + " " + instructorLastName;
						highestGym = gymName;
					}
				}

				if (totalClasses < lowestClasses)
				{
					lowestClasses = totalClasses;
					lowestName = instructorFirstName + " " + instructorLastName;
					lowestGym = gymName;
				}

				// PAY_20 per class for first 20, PAY_EXTRA per class after, + salary if paid by salary
				payRate = Math.min(20, totalClasses) * PAY_20;
				payRate += Math.max(0, totalClasses - 20) * PAY_OVER;

				if (instructorPay == 'S' || instructorPay == 's')
					payRate += SALARY;

				if (payRate > payLimit)
					payLimitCount++;

				System.out.printf("   %-5d %8.2f\n", totalClasses, payRate);
				outInstructorRep.printf("   %-5d %8.2f%n", totalClasses, payRate);

				if (instructorPay == 'C' || instructorPay == 'c')
				{
					outPayClassFile.printf("%4d %-4s %-10s %-10s %4s %8s %.2f%n",
						instructorId, instructorGym, instructorFirstName, instructorLastName, instructorPay, totalClasses, payRate);
				}
            } // Big if

            if (findGymName.equalsIgnoreCase(gymName))
            {
				totalFoundSalary += payRate;
				message += instructorId + "  " + fullName + "  " + payCodeName + "  " + String.format("%.2f", payRate) + "\n";
			}
        } // While

		outPlacementRep.println("====================== END OF REPORT ====================");

		System.out.println("\nInstructor and Class Counts:\n");
		outInstructorRep.println("\r\nInstructor and Class Counts:\r\n");

		System.out.println("Placement Count:   " + placementCount + "   Instructor Count:   " + instructorCount);
		outInstructorRep.println("Placement Count:   " + placementCount + "   Instructor Count:   " + instructorCount);

		System.out.println("Gyms:  Salthill:  " + sCount + "  Renmore  " + rCount + "  Merlin: "
			+ mCount + "   Barna:  " + bCount + "  Athenry:  " + aCount);
		outInstructorRep.println("Gyms:  Salthill:  " + sCount + "  Renmore  " + rCount + "  Merlin: "
			+ mCount + "   Barna:  " + bCount + "  Athenry:  " + aCount);

		System.out.println("Instructors Paid by Class:  " + byClassCount + "   Instructor Paid with base salary: " + bySalaryCount);
		outInstructorRep.println("Instructors Paid by Class:  " + byClassCount + "   Instructor Paid with base salary: " + bySalaryCount);

		System.out.println("\n" + highestName + " from the " + highestGym
			+ " gym taught the most weekly classes over the past 5 weeks of " + highestClasses + ".");
		outInstructorRep.println("\r\n" + highestName + " from the " + highestGym
			+ " gym taught the most weekly classes over the past 5 weeks of " + highestClasses + ".");

		// Left in the "1 week" because it's on the screenshot
		System.out.println(lowestGym + "'s " + lowestName + " had the lowest total number of classes taught in 1 week with only "
			+ lowestClasses + " classes being taught.");
		outInstructorRep.println(lowestGym + "'s " + lowestName + " had the lowest total number of classes taught in 1 week with only "
			+ lowestClasses + " classes being taught.");

		System.out.printf("\n%d instructors got more than %.2f euros over the %d weeks.\n", payLimitCount, payLimit, NUM_WEEKS);
		outInstructorRep.printf("%n%d instructors got more than %.2f euros over the %d weeks.%n", payLimitCount, payLimit, NUM_WEEKS);

		if (totalFoundSalary > 0)
		{
			message += "Total Salary:  E" + String.format("%.2f", totalFoundSalary);
			title = "Gym Name " + findGymName + " Found";
			JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			message = "Sorry Gym Name: " + findGymName + " not found\nPlease try again";
			title = "Gym Name " + findGymName + " Not Found";
			JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
		}

		inInstructorFile.close();
		outInstructorRep.close();
		outPlacementRep.close();
		outPayClassFile.close();
		System.exit(0);
    } // main
} // WalshMarcus17LabEx2
