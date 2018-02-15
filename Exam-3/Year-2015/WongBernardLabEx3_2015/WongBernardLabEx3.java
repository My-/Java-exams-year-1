// WongBernardLabEx3 - Bernard Wong
// Olympics Medal Table

import java.util.Scanner;
import java.io.*;

public class WongBernardLabEx3
{
    public static void main(String[] args) throws FileNotFoundException
    {
		// Constants
		final int MAX_COUNTRIES = 100, INT_ARRAY_ROWS = 8;
		final int GOLD_POINTS = 5, SILVER_POINTS = 3, BRONZE_POINTS = 1;
		final String SENTINEL_EOF = "EOF", SENTINEL_STOP = "Stop";

		// File Objects
		Scanner inMedalFile = new Scanner(new FileReader("CountryMedals.dat"));
		Scanner inMedalTxFile = new Scanner(new FileReader("EventResults.dat"));

		PrintWriter outMedalRep = new PrintWriter("RejectedMedals.dat");
		PrintWriter outMedalFile = new PrintWriter("NewCountryMedals.dat");

		// Instantiate Arrays
		int[][] countryMedals = new int[MAX_COUNTRIES][INT_ARRAY_ROWS];
		String[] countryNames = new String[MAX_COUNTRIES];

		// Master File Variables (to supplement arrays)
		String countryRest;

		// Tx File Variables/File Layout
		String txCountry;
		String txEvent;
		char txGender;
		String txMedal;

		// Other Variables
		int i, j, pos, countryCount = -1;
		int beforePts, afterPts, medalCount, column, newMedalCount;
		boolean foundCountry, txError;
		String findCountryName, errorMessage = "", countryName;
		char medalType, gender;
		char option;
		Scanner console = new Scanner(System.in);

		// Headers
		System.out.println("Bernard Wong - Olympic Medal Table - Lab Ex 3");
		System.out.println("\n            <------ Male ----->   <---- Female ---->");
		System.out.println("Country     Gold  Silver Bronze   Gold Silver Bronze Points   Disq");
		System.out.println("==================================================================");

		// Country Arrays
		countryName =  inMedalFile.next().trim(); // initial read
		while(!countryName.equalsIgnoreCase(SENTINEL_EOF)){
			countryCount++;
			countryNames[countryCount] = countryName;
			System.out.printf("%-10s ", countryNames[countryCount]);

			for(j = 0; j < INT_ARRAY_ROWS; j++){
				countryMedals[countryCount][j] = inMedalFile.nextInt();
				System.out.printf("%6d ", countryMedals[countryCount][j]);
			} // for j

			System.out.println();
			countryName =  inMedalFile.next().trim(); // subsequent read
		} // while SENTINEL_EOF

		// Output/Verify Tx File
		// Header
		System.out.println("\nCountry    Event    Gender Medal");
		System.out.println("=================================");

		txCountry = inMedalTxFile.next(); // initial read
		while(!txCountry.equalsIgnoreCase(SENTINEL_EOF)){
			txEvent = inMedalTxFile.next();
			txGender = inMedalTxFile.next().charAt(0);
			txMedal = inMedalTxFile.next();

			System.out.printf("%-10s %-10s %-4c %-6s\n", txCountry, txEvent, txGender, txMedal); // Output

			txCountry = inMedalTxFile.next(); // subsequent read
		} // while SENTINEL_EOF

		// Reopen Tx File
		inMedalTxFile.close();
		inMedalTxFile = new Scanner(new FileReader("EventResults.dat"));

		// Rejected Header
		outMedalRep.printf("Mismatched Rejectd Tx Report");
		outMedalRep.printf("%n============================");
		outMedalRep.printf("%nCountry    Event    Gender Medal");
		outMedalRep.printf("%n=================================%n");

		// Header
		System.out.println("\nCountry    Event    Gender Medal");
		System.out.println("================================");

		txCountry = inMedalTxFile.next(); // initial read
		while(!txCountry.equalsIgnoreCase(SENTINEL_EOF)){
			txEvent = inMedalTxFile.next();
			txGender = inMedalTxFile.next().charAt(0);
			txMedal = inMedalTxFile.next();

			// Reset
			pos = -1;
			column = 0;
			foundCountry = false;
			txError = false;
			beforePts = afterPts = 0;

			// Search Country Name
			while (pos < countryCount && foundCountry == false){
				++pos;
				if (countryNames[pos].equalsIgnoreCase(txCountry)){
					foundCountry = true;
				} // if
			} // while

			if(foundCountry){
				beforePts = countryMedals[pos][6];

				switch(txGender){
					case 'm':
					case 'M':
						if(txMedal.equalsIgnoreCase("bronze")){
							afterPts = beforePts + BRONZE_POINTS;
							column = 2;
							++countryMedals[pos][column];
						}
						else if(txMedal.equalsIgnoreCase("silver")){
							afterPts = beforePts + SILVER_POINTS;
							column = 1;
							++countryMedals[pos][column];
						}
						else if(txMedal.equalsIgnoreCase("gold")){
							afterPts = beforePts + GOLD_POINTS;
							column = 0;
							++countryMedals[pos][column];
						}
						else{
							txError = true;
							errorMessage = " - Medal not Gold, Silver or Bronze";
						} // if medals
						break;
					case 'f':
					case 'F':
						if(txMedal.equalsIgnoreCase("bronze")){
							afterPts = beforePts + BRONZE_POINTS;
							column = 5;
							++countryMedals[pos][column];
						}
						else if(txMedal.equalsIgnoreCase("silver")){
							afterPts = beforePts + SILVER_POINTS;
							column = 4;
							++countryMedals[pos][column];
						}
						else if(txMedal.equalsIgnoreCase("gold")){
							afterPts = beforePts + GOLD_POINTS;
							column = 3;
							++countryMedals[pos][column];
						}
						else{
							txError = true;
							errorMessage = " - Medal not Gold, Silver or Bronze";
						} // if medals
						break;
					default:
						txError = true;
						errorMessage = " - Invalid Gender";
				} // switch Gender

				if(txError){
					outMedalRep.printf("%-10s %-10s %-4c %-6s %-25s%n", txCountry, txEvent, txGender, txMedal, errorMessage);
				}
				else{
					countryMedals[pos][6] = afterPts;
					System.out.printf("%-10s %-10s %-4c %-6s  Bef: %2d Aft: %2d points\n", txCountry, txEvent, txGender, txMedal, beforePts, afterPts); // Output
				} // if determine error message

			}
			else{
				outMedalRep.printf("%-10s %-10s %-4c %-6s  - Missing Country Name%n", txCountry, txEvent, txGender, txMedal);
			} // if found country

			txCountry = inMedalTxFile.next(); // subsequent read
		} // while SENTINEL_EOF

		// Output/Verify Updated File
		// Header
		System.out.println("\n            <------ Male ----->   <---- Female ---->");
		System.out.println("Country     Gold  Silver Bronze   Gold Silver Bronze Points   Disq");
		System.out.println("==================================================================");

		for(i = 0; i <= countryCount; ++i){
			System.out.printf("%-10s ", countryNames[i]);

			for(j = 0; j < INT_ARRAY_ROWS; j++){
				System.out.printf("%6d ", countryMedals[i][j]);
			} // for j

			System.out.println();
		} // for i

		System.out.println();

		// Prompt country name
		System.out.print("Enter Country Name (Stop to end): ");
		findCountryName = console.nextLine(); // initial read

		// search country name
		while(!findCountryName.equalsIgnoreCase(SENTINEL_STOP)){
			foundCountry = false;
			pos = -1;
			column = 0;

			while (pos < countryCount && foundCountry == false){
				++pos;
				if (countryNames[pos].equalsIgnoreCase(findCountryName)){
					foundCountry = true;
				} // if
			} // inner while search country

			if(!foundCountry){
				System.out.println("Sorry Country name not found - please try again.\n");
			}
			else{
				System.out.print("  Select C/ountry, D/isplay, M/edal or Q/uit: ");
				option = console.next().charAt(0);

				switch(option)
				{
					case 'c':
					case 'C':
						console.nextLine();
						do{
							System.out.println("  Current Country Name: " + countryNames[pos]);
							System.out.print("Enter new name (not blank): ");
							countryName = console.nextLine();
						} while(countryName.length() < 1);
						countryNames[pos] = countryName;
						System.out.println();
						break;
					case 'd':
					case 'D':
						// Header
						System.out.println("\n            <------ Male ----->   <---- Female ---->");
						System.out.println("Country     Gold  Silver Bronze   Gold Silver Bronze Points   Disq");
						System.out.println("==================================================================");

						for(i = 0; i <= countryCount; ++i){
							System.out.printf("%-10s ", countryNames[i]);

							for(j = 0; j < INT_ARRAY_ROWS; j++){
								System.out.printf("%6d ", countryMedals[i][j]);
							} // for j

							System.out.println();
						} // for i
						System.out.println();
						console.nextLine();
						break;
					case 'm':
					case 'M':
						do{
							System.out.print("  Enter Medal type & Gender (G/old F/emale): ");
							medalType = console.next().charAt(0);
							gender = console.next().charAt(0);
						} while(medalType != 'g' && medalType != 'G' && medalType != 'S' && medalType != 's' && medalType != 'B' && medalType != 'b'
								|| gender != 'M' && gender != 'm' && gender != 'F' && gender != 'f');

						if(gender == 'M' || gender == 'm'){
							switch(medalType){
								case 'g':
								case 'G':
									column = 0;
									medalCount = countryMedals[pos][column];
									break;
								case 's':
								case 'S':
									column = 1;
									medalCount = countryMedals[pos][column];
									break;
								case 'b':
								case 'B':
									column = 2;
									medalCount = countryMedals[pos][column];
									break;
								default:
									medalCount = 0;
							} // switch medal type
						}
						else{
							switch(medalType){
								case 'g':
								case 'G':
									column = 3;
									medalCount = countryMedals[pos][column];
									break;
								case 's':
								case 'S':
									column = 4;
									medalCount = countryMedals[pos][column];
									break;
								case 'b':
								case 'B':
									column = 5;
									medalCount = countryMedals[pos][column];
									break;
								default:
									medalCount = 0;
							} // switch medal type
						} // if gender

						System.out.println("  Curent Medal Count: " + medalCount);
						System.out.print("  Enter Medal Count: ");
						newMedalCount = console.nextInt();

						countryMedals[pos][column] = newMedalCount;
						if(column == 0 || column == 3){
							countryMedals[pos][6] = countryMedals[pos][6] - (medalCount * 5) + (newMedalCount * 5);
						}
						else if(column == 1 || column == 4){
							countryMedals[pos][6] = countryMedals[pos][6] - (medalCount * 3) + (newMedalCount * 3);
						}
						else if(column == 2 || column == 5){
							countryMedals[pos][6] = countryMedals[pos][6] - medalCount + newMedalCount;
						} // else if add points

						System.out.println();
						console.nextLine();
						break;
					case 'q':
					case 'Q':
						console.nextLine();
						break;
					default:
						System.out.println("  Sorry must enter: C/ountry, D/isplay, M/edal or Q/uit.\n");
						console.nextLine();
					} // switch option
			} // if found country

			System.out.print("Enter Country Name (Stop to end): ");
			findCountryName = console.nextLine(); // subsequent read
		} // while SENTINEL_STOP

		// Output updated arrays to new output file
		for(i = 0; i <= countryCount; ++i){

			outMedalFile.printf("%-10s ", countryNames[i]);

			for(j = 0; j < INT_ARRAY_ROWS; j++){
				outMedalFile.printf("%6d ", countryMedals[i][j]);
			} // for j

			outMedalFile.printf("%n");
		} // for

		outMedalFile.println(SENTINEL_EOF);

		// Close Files
		inMedalFile.close();
		inMedalTxFile.close();
		outMedalRep.close();
		outMedalFile.close();
    }  // main

} // WongBernardLabEx3