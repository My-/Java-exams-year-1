// WongBernardLabEx3 - Bernard Wong
// Connaught Media Customer Maintenance

// imports
import java.io.*;
import java.util.*;

public class WongBernardLabEx3
{
    public static void main(String[] args) throws FileNotFoundException
    {
		// Constants
		final int MAX_CUSTOMERS = 50, INT_ARRAY_ROWS = 4, SENTINEL_0 = 0;
		final String SENTINEL_EXIT = "EXIT";

		// File Objects
		Scanner inMediaFile = new Scanner(new FileReader("MediaMaster.dat"));
		Scanner inMediaTxFile = new Scanner(new FileReader("MediaTx.dat"));
		PrintWriter outMediaRep = new PrintWriter("MediaRejected.dat");
		PrintWriter outMediaFile = new PrintWriter("MediaNewMaster.dat");

		// Media Master File Variables (to supplement arrays)
		int custNum;
		char custStatus;
		String custRest;
		double custCost;
		String custName;

		// Media Tx File Variables/File Layout
		int txCustNum;
		char txCode;
		String txSubCode;
		double txAmount;

		// 1/2 dim Arrays
		int[][] custData = new int[MAX_CUSTOMERS][INT_ARRAY_ROWS];
		char[] custStatuses = new char[MAX_CUSTOMERS];
		String[] custDistricts = new String[MAX_CUSTOMERS];
		double[] custCosts = new double[MAX_CUSTOMERS];
		String[] custNames = new String[MAX_CUSTOMERS];

		double[][] priceList = {
									{0.00, 1.01, 2.02, 3.03, 4.04},
									{0.00, 11.01, 12.02, 13.03, 0.00},
									{0.00, 101.01, 102.02, 103.03, 0.00}
								};

		// Other Variables
		int custAcceptCount = -1, custRejectCount = 0, txAcceptCount = 0, txRejectCount = 0;
		int i, j, pos;
		int custCount, txCount, column;
		boolean foundCustomer, txError;
		String findCustName, errorMessage="", empName="", subString;
		char option;
		Scanner console = new Scanner(System.in);

		// Headers
		System.out.println("Bernard Wong - Media Maintenance - Lab Ex 3 - Feb 2017");
		System.out.println("==============================================================");
		System.out.println("Cust   Customer     Tv  Phone   Inet      Cost        Customer");
		System.out.println("Num St District   Pack   Pack   Pack      Pack            Name");
		System.out.println("==============================================================");

		// Media Arrays
		custNum =  inMediaFile.nextInt(); // initial read
		while(custNum != SENTINEL_0){

			custStatus = inMediaFile.next().charAt(0);
			if(custStatus == 'A' || custStatus == 'a'){
				++custAcceptCount;
				custData [custAcceptCount][0] = custNum;
				custStatuses [custAcceptCount] = custStatus;
				custDistricts [custAcceptCount] = inMediaFile.next().toLowerCase();

				System.out.printf("%3d %1c %9s", custData[custAcceptCount][0], custStatuses[custAcceptCount], custDistricts[custAcceptCount]);

				for(j = 1; j < INT_ARRAY_ROWS; j++){
					custData[custAcceptCount][j] = inMediaFile.nextInt();
					System.out.printf(" %6d", custData[custAcceptCount][j]);
				} // for

				custCosts [custAcceptCount] = inMediaFile.nextDouble();
				custNames [custAcceptCount] = inMediaFile.nextLine().trim();
				System.out.printf(" %9.2f %15s",custCosts [custAcceptCount], custNames[custAcceptCount]);

				System.out.println();
			}
			else{
				custRejectCount++;
				custRest = inMediaFile.nextLine();
				outMediaFile.printf("%3d %3c  ", custNum, custStatus);
				outMediaFile.println(custRest);
			} // if custStatus

			custNum =  inMediaFile.nextInt(); // subsequent read
		} // while SENTINEL_0 EOF

		// Footer
		custAcceptCount++;
		custCount = custRejectCount + custAcceptCount;
		System.out.printf("\nCustomer Count: %3d  Rejected: %3d  Accepted: %3d\n", custCount, custRejectCount, custAcceptCount);

		// while/Output/Verify Tx File (without rejected Tx)
		// Header
		System.out.println("\nCust   Tx  Sub      Tx");
		System.out.println(" Num Code Code  Amount");
		System.out.println("======================");

		txCustNum = inMediaTxFile.nextInt(); // initial read
		while(txCustNum != SENTINEL_0){
			txAcceptCount++;
			txCode = inMediaTxFile.next().charAt(0);
			txSubCode = inMediaTxFile.next();
			txAmount = inMediaTxFile.nextDouble();

			System.out.printf(" %3d %4c %4s %7.2f\n", txCustNum, txCode, txSubCode, txAmount);

			txCustNum = inMediaTxFile.nextInt(); // subsequent read
		}

		// Footer
		txCount = txAcceptCount + txRejectCount;
		System.out.printf("\nTx: %2d Rej: %2d Acc: %2d\n", txCount, txRejectCount, txAcceptCount);

		// while ReProcess Tx File (inner while search) & Rejection Report
		// Report File Header
		outMediaRep.println("Mismatched Rejected Tx Report");
		outMediaRep.println("=============================");
		outMediaRep.println("Cust   Tx  Sub      Tx");
		outMediaRep.println(" Num Code Code  Amount");
		outMediaRep.println("================================================");

		// Reopen Tx File
		inMediaTxFile.close();
		inMediaTxFile = new Scanner(new FileReader("MediaTx.dat"));

		// Header
		System.out.println("\nCust   Tx  Sub      Tx");
		System.out.println(" Num Code Code  Amount");
		System.out.println("======================");

		// Reset
		txCount = 0;
		txAcceptCount = 0;

		txCustNum = inMediaTxFile.nextInt(); // initial read
		while(txCustNum != SENTINEL_0){
			txCode = inMediaTxFile.next().charAt(0);
			txSubCode = inMediaTxFile.next().toLowerCase();
			txAmount = inMediaTxFile.nextDouble();
			pos = -1;
			foundCustomer = false;
			txError = false;

			// Customer Number Rejection
			while (pos < custAcceptCount - 1 && foundCustomer == false){
				++pos;
				if (custData[pos][0] == txCustNum){
					foundCustomer = true;
				}
				else if (custData[pos][0] > txCustNum){
					break;
				} // if
			} // while Rejection

			if(foundCustomer){
				// Valid Tx Code Rejection
				switch(txCode){
					case 'a':
					case 'A':
						// Add service and rejection
						switch(txSubCode){
							case "tv":
								custData[pos][1] += txAmount;
									// Update Cost
									switch((int)txAmount){
										case 1:
											custCosts[pos] += priceList[0][1];
											break;
										case 2:
											custCosts[pos] += priceList[0][2];
											break;
										case 3:
											custCosts[pos] += priceList[0][3];
											break;
										case 4:
											custCosts[pos] += priceList[0][4];
											break;
										default:
											custCosts[pos] += priceList[0][0];
									} // switch txAmount
								break;
							case "ph":
								custData[pos][2] += txAmount;
									// Update Cost
									switch((int)txAmount){
										case 1:
											custCosts[pos] += priceList[1][1];
											break;
										case 2:
											custCosts[pos] += priceList[1][2];
											break;
										case 3:
											custCosts[pos] += priceList[1][3];
											break;
										case 4:
											custCosts[pos] += priceList[1][4];
											break;
										default:
											custCosts[pos] += priceList[1][0];
									} // switch txAmount
								break;
							case "in":
								custData[pos][3] += txAmount;
									// Update Cost
									switch((int)txAmount){
										case 1:
											custCosts[pos] += priceList[2][1];
											break;
										case 2:
											custCosts[pos] += priceList[2][2];
											break;
										case 3:
											custCosts[pos] += priceList[2][3];
											break;
										case 4:
											custCosts[pos] += priceList[2][4];
											break;
										default:
											custCosts[pos] += priceList[2][0];
									} // switch txAmount
								break;
							default:
								txError = true;
								errorMessage = "Invalid Tx sub code: " + txSubCode;
						} // switch txSubCode
						break;
					case 'd':
					case 'D':
						// Delete service and rejection
						switch(txSubCode){
							case "tv":
								custCosts[pos] = 0;
								custData[pos][1] = 0;
								break;
							case "ph":
								custCosts[pos] = 0;
								custData[pos][2] = 0;
									break;
							case "in":
								custCosts[pos] = 0;
								custData[pos][3] = 0;
								break;
							default:
								txError = true;
								errorMessage = "Invalid Tx sub code: " + txSubCode;
						} // switch txSubCode
						break;
					case 'c':
					case 'C':
						// Add service and rejection
						switch(txSubCode){
							case "per":
								custCosts[pos] += txAmount;
								break;
							case "fix":
								custCosts[pos] = txAmount;
								break;
							default:
								txError = true;
								errorMessage = "Invalid Tx sub code: " + txSubCode;
						} // switch txSubCode
						break;
					default:
					txError = true;
					errorMessage = "Invalid Tx code: " + txCode;
				} // switch txCode

				if(txError){
					txRejectCount++;
					outMediaRep.printf("%3d %4c %4s %7.2f - %25s %n", txCustNum, txCode, txSubCode, txAmount, errorMessage);
				}
				else{
					txAcceptCount++;
					System.out.printf("%3d %4c %4s %7.2f\n", txCustNum, txCode, txSubCode, txAmount);
				} // if determine error message

			}
			else{
				txRejectCount++;
				outMediaRep.printf("%3d %4c %4s %7.2f - Mismatched Employee Id %n", txCustNum, txCode, txSubCode, txAmount);
			} // if Found Customer

			txCustNum = inMediaTxFile.nextInt(); // subsequent read
		} // while SENTINEL_0

		// Footer
		txCount = txAcceptCount + txRejectCount;
		System.out.printf("\nTx: %2d Rej: %2d Acc: %2d\n", txCount, txRejectCount, txAcceptCount);

		// Output After Update
		// Headers
		System.out.println("\nCust   Customer     Tv  Phone   Inet      Cost        Customer");
		System.out.println("Num St District   Pack   Pack   Pack      Pack            Name");
		System.out.println("==============================================================");

		// Updated Arrays
		for(i = 0; i < custAcceptCount; ++i){
				System.out.printf("%3d %1c %9s", custData[i][0], custStatuses[i], custDistricts[i]);

				for(j = 1; j < INT_ARRAY_ROWS; j++)
				{
					System.out.printf(" %6d", custData[i][j]);
				} // inner for j

				System.out.printf(" %9.2f %15s\n",custCosts [i], custNames[i]);
		} // for i

		// Footer
		System.out.printf("\nCustomer Count: %3d  Rejected: %3d  Accepted: %3d\n", custCount, custRejectCount, custAcceptCount);

		// Prompt Customer name
		System.out.print("\nEnter Customer Name (Exit to end): ");
		findCustName = console.nextLine(); // initial read

		// search customer name
		while(!findCustName.equalsIgnoreCase(SENTINEL_EXIT)){
			foundCustomer = false;
			pos = -1;

			while (pos < custAcceptCount - 1 && foundCustomer == false){
				++pos;
				if (custNames[pos].equalsIgnoreCase(findCustName)){
					foundCustomer = true;
				} // if
			} // while

			if(!foundCustomer){
				System.out.println("  Sorry Customer name not found - please try again.");
			}
			else{
				System.out.print("  Select C/ost, D/istrict, N/ame, V/iew or Q/uit: ");
				option = console.next().charAt(0);

				switch(option){
					case 'c':
					case 'C':
						do{
							System.out.print("  Current Cost: " + custCosts[pos]);
							System.out.print("  Enter new Cost (0.01..200.00): ");
							custCost = console.nextDouble();
						} while(custCost < 0.01 || custCost > 200.00);
						custCosts[pos] = custCost;
						console.nextLine();
						break;
					case 'd':
					case 'D':
						do{
							System.out.print("  Enter District (sub string): ");
							subString = console.next();

							if(subString.compareTo(custDistricts[pos]) != 0){
									// Header
									System.out.println("\nCust   Customer     Tv  Phone   Inet      Cost        Customer");
									System.out.println("Num St District   Pack   Pack   Pack      Pack            Name");
									System.out.println("==============================================================");

									// Output
									System.out.printf("%3d %1c %9s", custData[pos][0], custStatuses[pos], custDistricts[pos]);

									for(j = 1; j < INT_ARRAY_ROWS; j++)
									{
										System.out.printf(" %6d", custData[pos][pos]);
									} // inner for j

									System.out.printf(" %9.2f %15s\n",custCosts [pos], custNames[pos]);
							} // if compare district

						} while(subString.length() < 1);
						console.nextLine();
						break;
					case 'n':
					case 'N':
						console.nextLine();
						do
						{
							System.out.println("  Current Name: " + custNames[pos]);
							System.out.print("  Enter new name (not blank): ");
							custName = console.nextLine();
						} while(custName.length() < 1);
						custNames[pos] = custName;
						break;
					case 'v':
					case 'V':
						// Headers
						System.out.println("\nCust   Customer     Tv  Phone   Inet      Cost        Customer");
						System.out.println("Num St District   Pack   Pack   Pack      Pack            Name");
						System.out.println("==============================================================");

						for(i = 0; i < custAcceptCount; ++i){
								System.out.printf("%3d %1c %9s", custData[i][0], custStatuses[i], custDistricts[i]);

								for(j = 1; j < INT_ARRAY_ROWS; j++)
								{
									System.out.printf(" %6d", custData[i][j]);
								} // inner for j

								System.out.printf(" %9.2f %15s\n",custCosts [i], custNames[i]);
						} // for i

						// Footer
						System.out.printf("\nCustomer Count: %3d  Rejected: %3d  Accepted: %3d\n", custCount, custRejectCount, custAcceptCount);

					case 'q':
					case 'Q':
						console.nextLine();
						break;
					default:
						System.out.println("  C/ost, D/istrict, N/ame, V/iew or Q/uit.");
						console.nextLine();
				} // switch option
			} // if found customer

			System.out.print("\nEnter Customer Name (Exit to end): ");
			findCustName = console.nextLine(); // subsequent read
		} // while SENTINEL_EXIT

		// Output updated arrays to new output file
		for(i = 0; i < custAcceptCount; ++i){
				outMediaFile.printf("%3d %1c %9s", custData[i][0], custStatuses[i], custDistricts[i]);

				for(j = 1; j < INT_ARRAY_ROWS; j++)
				{
					outMediaFile.printf(" %6d", custData[i][j]);
				} // inner for j

				outMediaFile.printf(" %9.2f %15s%n",custCosts [i], custNames[i]);
		} // for i

		outMediaFile.println(SENTINEL_0);

		// Close Files
		inMediaFile.close();
		inMediaTxFile.close();
		outMediaRep.close();
		outMediaFile.close();
    }  // main

} // WongBernardLabEx3