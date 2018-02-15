// WongBernard16LabEx2 - Bernard Wong - Mantains race times and equipment hire

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class WongBernard16LabEx2
{
    public static void main(String[] args)
    						throws FileNotFoundException
    {
		// Constants
		final double EQUIPMENT_M = 20.00, EQUIPMENT_S = 25.00, EQUIPMENT_F = 30.00, EARLY_DISCOUNT = 0.1;
		final double RACE_TIME_LIMIT = 75.00;
		final int MAX_RACE_TIMES = 4;

		// Record Layout
		int compId;
		char compClubCode;
		String compFirstName;
		String compLastName;
		char compRaceType;
		char compEarlyBird;
		double compRaceTimes; // 4 times

		// Other Variables
		int i;
		double averageTimes, equipmentCost, equipmentTotal, earlyBirdDisc;
		String compClubName, compFullName, compRaceName;
		int activeCount, inactiveCount;
		int gCount, eCount, wCount, sCount, miniCount, sportCount, fullCount;
		String fastestComp, slowestComp, fastestRace, slowestRace;
		double fastestTime, slowestTime;
		double sumRaceTimes, underLimit;
		String findClubName, str, message;
		int underLimitCount;
		boolean nameMatch;

		// File Objects/Variables
		Scanner inRaceFile = new Scanner(new FileReader("RaceDetails.dat"));
		PrintWriter outRaceRep = new PrintWriter("RaceDetailsRep.dat");
		PrintWriter outRaceRep2 = new PrintWriter("NonCompetingRep.dat");
		PrintWriter outRaceFile = new PrintWriter("EarlyBird.dat");

		// Initailize variables
		activeCount = inactiveCount = underLimitCount = 0;
		gCount = eCount = wCount = sCount =  miniCount = sportCount = fullCount = 0;
		sumRaceTimes = equipmentCost = underLimit = 0.0;
		fastestTime = 999.99;
		slowestTime = -999.99;
		fastestComp = fastestRace = slowestComp = slowestRace =  message = "";
		nameMatch = false;

		// Screen/Report Header
		System.out.println("Bernard Wong - Lab Exam 2 (December 2016)");
		System.out.println("\n Id   Competitor   Club     Type  EB   R1     R2     R3     R4        Avg   Cost");
		System.out.println("==================================================================================");

		outRaceRep.printf("Bernard Wong - Lab Exam 2 (December 2016)");
		outRaceRep.printf("%n Id   Competitor   Club     Type  EB   R1     R2     R3     R4        Avg   Cost%n");
		outRaceRep.printf("==================================================================================%n");

		// Input Dialog
		findClubName = JOptionPane.showInputDialog("Find Club Name:", "Galway");
		str = JOptionPane.showInputDialog("Enter Average Race Time Limit for Mini race:", RACE_TIME_LIMIT);

		// Main while loop - Read file Input until EOF
		while(inRaceFile.hasNext())
		{
			// File Input
			compId = inRaceFile.nextInt();
			compClubCode = inRaceFile.next().charAt(0);
			compFirstName = inRaceFile.next();
			compLastName = inRaceFile.next();
			compRaceType = inRaceFile.next().charAt(0);
			compEarlyBird = inRaceFile.next().charAt(0);

			compFullName = compFirstName + " " + compLastName; // full name

			// Ignore N
			if(compClubCode == 'n' || compClubCode == 'N')
			{
				++inactiveCount;

				// Non Competing Report
				outRaceRep2.printf(" %3d %-12s %2c %2c %2c  - Non Competing%n", compId, compFullName, compClubCode, compRaceType, compEarlyBird);

				inRaceFile.nextLine();
			}
			else
			{
				++activeCount; // Competing Count

				// Reset Variables
				sumRaceTimes = 0.0;

				// Determine club name
				switch(compClubCode)
				{
					case 'g':
					case 'G':
						compClubName = "Galway";
						++gCount;
						break;
					case 'e':
					case 'E':
						compClubName = "Ennis";
						++eCount;
						break;
					case 'w':
					case 'W':
						compClubName = "Westport";
						++wCount;
						break;
					case 's':
					case 'S':
						compClubName = "Sligo";
						++sCount;
						break;
					default:
						compClubName = "Not Competing";
						++inactiveCount;
				} // switch

				// Determine Race Name
				if(compRaceType == 'm' || compRaceType == 'M')
				{
					compRaceName = "Mini";
					equipmentCost = EQUIPMENT_M;
					++miniCount;
				}
				else if(compRaceType == 's' || compRaceType == 'S')
				{
					compRaceName = "Sport";
					equipmentCost = EQUIPMENT_S;
					++sportCount;
				}
				else if(compRaceType == 'f' || compRaceType == 'F')
				{
					compRaceName = "Full";
					equipmentCost = EQUIPMENT_F;
					++fullCount;
				}
				else
				{
					compRaceName = "Invalid";
				} // if

				// Screen Line Output & Report
				System.out.printf("%4d %-12s %-8s %-6s %1c ", compId, compFullName, compClubName, compRaceName, compEarlyBird);
				outRaceRep.printf("%4d %-12s %-8s %-6s %1c ", compId, compFullName, compClubName, compRaceName, compEarlyBird);

				// inner for loop Race Time
				for(i = 1; i <= MAX_RACE_TIMES; i++)
				{
					compRaceTimes = inRaceFile.nextDouble();
					System.out.printf(" %6.1f", compRaceTimes); // Line Output
					outRaceRep.printf(" %6.1f", compRaceTimes); // Report
					sumRaceTimes += compRaceTimes;

					// Determine fastest and slowest competitors
					if(fastestTime > compRaceTimes)
					{
						fastestTime = compRaceTimes;
						fastestComp = compLastName + ", " + compFirstName;
						fastestRace = compRaceName;
					} // if
					if(slowestTime < compRaceTimes)
					{
						slowestTime = compRaceTimes;
						slowestComp = compLastName + ", " + compFirstName;
						slowestRace = compRaceName;
					} // if
				} // for

				// Calculate Average Time
				averageTimes = sumRaceTimes / 4.0;

				// Total Equipment Cost
				if(compEarlyBird == 'y' || compEarlyBird == 'Y')
				{
					equipmentTotal = equipmentCost * 4;
					earlyBirdDisc = equipmentTotal * EARLY_DISCOUNT;
					equipmentTotal -= earlyBirdDisc;
					outRaceFile.printf(" %3d %-12s %-8s %-5s%n", compId, compFullName, compClubName, compRaceName); // Early Bird File
				}
				else
				{
					equipmentTotal = equipmentCost * 4;
				} // if

				// Additional Outputs
				System.out.printf(" %8.1f %6.2f\n", averageTimes, equipmentTotal);
				outRaceRep.printf(" %8.1f %6.2f%n", averageTimes, equipmentTotal);

				// Competitors under limit
				underLimit = Double.parseDouble(str);
				if(underLimit > averageTimes)
				{
					++underLimitCount;
				} // if

				// Find Club Name
				if(findClubName.equalsIgnoreCase(compClubName))
				{
					nameMatch = true;
					message += String.format("%3d  %-7s  %11s\n", compId, compFullName, compRaceName);
				} // if

			} // big if

		} // while

		// Output Footer details to Screen & Report
		System.out.printf("\nCompetitor Counts:\n");
		System.out.printf("\nCompeting: %3d    Not Competing: %3d", activeCount, inactiveCount);
		System.out.printf("\nClubs:  Galway: %2d   Ennis: %1d   Westport: %1d   Sligo: %1d", gCount, eCount, wCount, sCount);
		System.out.printf("\nMini Race: %1d   Sport Race: %1d   Full Race: %1d\n", miniCount, sportCount, fullCount);
		System.out.printf("\nThe first competitor over the line was %8s in the %4s race in %4.1f minutes.", fastestComp, fastestRace, fastestTime);
		System.out.printf("\nThe last competitor over the line was %10s in the %4s race in %5.1f minutes.\n", slowestComp, slowestRace, slowestTime);
		System.out.printf("\n%1d competitors had an overall average in the Mini race of less than %2.0f minutes.\n", underLimitCount, underLimit);

		outRaceRep.printf("%nCompetitor Counts:%n");
		outRaceRep.printf("%nCompeting: %3d    Not Competing: %3d", activeCount, inactiveCount);
		outRaceRep.printf("%nClubs:  Galway: %2d   Ennis: %1d   Westport: %1d   Sligo: %1d", gCount, eCount, wCount, sCount);
		outRaceRep.printf("%nMini Race: %1d   Sport Race: %1d   Full Race: %1d%n", miniCount, sportCount, fullCount);
		outRaceRep.printf("%nThe first competitor over the line was %8s in the %4s race in %4.1f minutes.", fastestComp, fastestRace, fastestTime);
		outRaceRep.printf("%nThe last competitor over the line was %10s in the %4s race in %5.1f minutes.%n", slowestComp, slowestRace, slowestTime);
		outRaceRep.printf("%n%1d competitors had an overall average in the Mini race of less than %2.0f minutes.%n", underLimitCount, underLimit);

		// Close files
		inRaceFile.close();
		outRaceRep.close();
		outRaceRep2.close();
		outRaceFile.close();

		// Message Dialog
		if(nameMatch == true)
		{
			JOptionPane.showMessageDialog(null, message , "Club Name Found - " + findClubName, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry Club Name: " + findClubName + " not found - please try again", "Club Name Not Found", JOptionPane.WARNING_MESSAGE);
		} // if

		// Exit
		System.exit(0);

    }// main

}// class