// Marcus Walsh - Lab Exam 3
// Corrib Water Customer Usage Maintenance

// imports
import java.util.Scanner;
import java.io.*;

public class WalshMarcus18LabEx3
{
    public static void main(String[] args)
                  throws FileNotFoundException
    {
		// Constants
		final int MAX_CUSTOMERS = 70,
			SENTINAL = -1,
			NUM_COLS = 5;
		final String SENTINAL_QUIT = "quit";
		final int QUARTERS = 4;

		// File Objects
		Scanner inWaterFile = new Scanner(new FileReader("WaterMaster.dat"));
		Scanner inWaterTxFile = new Scanner(new FileReader("WaterTx.dat"));
		PrintWriter outMismatchedRep = new PrintWriter("WaterRejected.dat");

		// File Variables
		int custNum;
		char custType;
		String custRegion;
		char custStatus;
		int txCustNum;
		String txCode;
		int txQuarter;
		int txAmount;
		String txName;

		// 1/2 dim Arrays
		char[] custTypes = new char[MAX_CUSTOMERS];
		String[] custRegions = new String[MAX_CUSTOMERS];
		char[] custStatuses = new char[MAX_CUSTOMERS];
		String[] custName = new String[MAX_CUSTOMERS];
		int[][] custDetails = new int[MAX_CUSTOMERS][NUM_COLS];
		int[][] custDetailsNoTx = new int[MAX_CUSTOMERS][NUM_COLS];

		// Other Variables
		Scanner console = new Scanner(System.in);
		int i,j;
		int acceptCount = 0, rejectCount = 0;
		int txAcceptCount = 0, txRejectCount = 0;
		char option;
		String findName;
		boolean found;
		boolean txValid;
		String newName;
		int custCount;
		int txCount;
		String errorMessage="";
		int newRegion;
		int newId;
        int acceptCountNoTx;

		// while/for Read Master File & Populate arrays
		custNum = inWaterFile.nextInt();

		while (custNum != SENTINAL)
		{
			custType = inWaterFile.next().toLowerCase().charAt(0);
			custRegion = inWaterFile.next().toLowerCase();
			custStatus = inWaterFile.next().toLowerCase().charAt(0);

			if (custStatus != 'a')
			{
				inWaterFile.nextLine();
				rejectCount++;
			}
			else
			{
				custDetails[acceptCount][0] = custNum;
				custTypes[acceptCount] = custType;
				custRegions[acceptCount] = custRegion;
				custStatuses[acceptCount] = custStatus;

				for (i = 0; i < QUARTERS; i++)
				{
					custDetails[acceptCount][(i+1)] = inWaterFile.nextInt();
				}

				custName[acceptCount] =  inWaterFile.nextLine().trim();
				acceptCount++;
			}
			custNum = inWaterFile.nextInt();
		} // while

		System.out.println("Marcus Walsh - Water Maintenance - Lab Ex 3 - Feb 2018");
		System.out.println("=================================================================");

		custCount = acceptCount + rejectCount;

		System.out.println("Customer Count:  " + custCount + "  Rejected:  " + rejectCount + "  Accepted:  " + acceptCount);

		// Nested fors/Output/Verify Master File arrays

		System.out.println("\nCust Cust Cust   Cust    Q1    Q2    Q3    Q4       Cust");
		System.out.println(" Num Stat Type Region Usage Usage Usage Usage       Name");
		System.out.println("=================================================================");

        acceptCountNoTx = acceptCount;
		for (i = 0; i < acceptCount; i++)
		{
			System.out.printf("%4d %4s %4s %6s",
				custDetails[i][0], custTypes[i], custStatuses[i], custRegions[i]);

			for (j = 1; j <= QUARTERS; j++)
			{
                custDetailsNoTx[i][j] = custDetails[i][j];
				System.out.printf(" %5d", custDetails[i][j]);
			}

			System.out.printf(" %15s%n", custName[i].trim());
		} // for


		// while/Output/Verify Tx File (without rejected Tx)

		System.out.println("Cust    Tx  Tx   Tx New");
		System.out.println(" Num  Code Qtr  Amt Name");
		System.out.println("================================");

		txCustNum = inWaterTxFile.nextInt();

		while (txCustNum != SENTINAL)
		{
			txCode = inWaterTxFile.next().toLowerCase();
			txQuarter = inWaterTxFile.nextInt();
			txAmount = inWaterTxFile.nextInt();
			txName = inWaterTxFile.nextLine().toLowerCase();

			System.out.printf("%4d %3s %4d %4d %15s%n",
				txCustNum, txCode, txQuarter, txAmount, txName);
			txAcceptCount++;
			txCustNum = inWaterTxFile.nextInt();
		} // while

		txCount = txAcceptCount + txRejectCount;
		System.out.println("\nTx:  " + txCount + " Reject:  " + txRejectCount + " Accept:  " + txAcceptCount);

		txAcceptCount = 0;
		inWaterTxFile.close();
		inWaterTxFile = new Scanner(new FileReader("WaterTx.dat"));

		// while/Output/Verify Tx File (with rejected Tx)

		System.out.println("\nCust    Tx  Tx   Tx New");
		System.out.println(" Num  Code Qtr  Amt Name");
		System.out.println("================================");
		outMismatchedRep.println("Mismatched Reject Tx Report");
		outMismatchedRep.println("===========================\n");
		outMismatchedRep.println("Cust    Tx  Tx   Tx New");
		outMismatchedRep.println(" Num  Code Qtr  Amt Name");
		outMismatchedRep.println("================================");

		txCustNum = inWaterTxFile.nextInt();

		while (txCustNum != SENTINAL)
		{
			txCode = inWaterTxFile.next().toLowerCase();
			txQuarter = inWaterTxFile.nextInt();
			txAmount = inWaterTxFile.nextInt();
			txName = inWaterTxFile.nextLine().trim();

			found = false;
			i = -1;

			while (i < acceptCount && !found)
			{
				i++;
				if (txCustNum == custDetails[i][0])
				{
					found = true;
				}

			}

			if (!found)
			{
				errorMessage = " - Mismatched Customer Id";
				txValid = false;
			}
			else
			{
				txValid = true;
				switch (txCode)
				{
					case "set":
						if (txQuarter > 4 || txQuarter < 1)
						{
							errorMessage = " - Invalid Quarter : " + txQuarter;
							txValid = false;
							break;
						}
						custDetails[i][txQuarter] = txAmount;
						break;
					case "add":
						if (txQuarter > 4 || txQuarter < 1)
						{
							errorMessage = " - Invalid Quarter : " + txQuarter;
							txValid = false;
							break;
						}
						custDetails[i][txQuarter] += txAmount;
						break;
					case "sub":
						if (txQuarter > 4 || txQuarter < 1)
						{
							errorMessage = " - Invalid Quarter : " + txQuarter;
							txValid = false;
							break;
						}
						custDetails[i][txQuarter] -= txAmount;
						custDetails[i][txQuarter] = Math.max(0, custDetails[i][txQuarter]);
						break;
					case "nil":
						for (j = 1; j <= QUARTERS; j++)
						{
							custDetails[i][j] = 0;
						}
						break;
					case "fix":
						for (j = 1; j <= QUARTERS; j++)
						{
							custDetails[i][j] = txAmount;
						}
						break;
					case "reg":
						switch ((int) txQuarter)
						{
							case 1:
								custRegions[i] = "north";
								break;
							case 2:
								custRegions[i] = "south";
								break;
							case 3:
								custRegions[i] = "east";
								break;
							case 4:
								custRegions[i] = "west";
								break;
							default:
								errorMessage = " - Invalid Quarter : " + txQuarter;
								txValid = false;

						}
						break;

					case "nme":
						if (txName.length() < 1 || txName.length() > 30)
						{
							errorMessage = " - Invalid Name must be 1..30 Long:";
							txValid = false;
							break;
						}

						custName[i] = txName;
						break;
					case "st":
						if (txQuarter == 1)
						{
							custStatuses[i] = 's';
						}
						else if (txQuarter == 2)
						{
							custStatuses[i] = 'x';
						}
						else
						{
							errorMessage = " - Invalid Status: must be 1/Suspended or 2/Ex-Customer";
							txValid = false;
						}
						break;
					default:
						errorMessage = " - Invalid Tx Code : " + txCode;
						txValid = false;
				} // switch
			}// if

			if (txValid)
			{
				txAcceptCount++;
				System.out.printf("%4d %3s %4d %4d %15s%n",
					txCustNum, txCode, txQuarter, txAmount, txName);
			}
			else
			{
				txRejectCount++;
				outMismatchedRep.printf("%4d %3s %4d %4d %15s %s%n",
					txCustNum, txCode, txQuarter, txAmount, txName, errorMessage);
			}

			txCustNum = inWaterTxFile.nextInt();
		} // while

		txCount = txAcceptCount + txRejectCount;
		System.out.println("\nTx:  " + txCount + " Reject:  " + txRejectCount + " Accept:  " + txAcceptCount);

		// Nested fors/Output/Verify Master File arrays

		System.out.println("Cust Cust Cust   Cust    Q1    Q2    Q3    Q4       Cust");
		System.out.println(" Num Stat Type Region Usage Usage Usage Usage       Name");
		System.out.println("=================================================================");

		for (i = 0; i < acceptCount; i++)
		{
			System.out.printf("%4d %4s %4s %6s",
				custDetails[i][0], custTypes[i], custStatuses[i], custRegions[i]);

			for (j = 1; j <= QUARTERS; j++)
			{

				System.out.printf(" %5d", custDetails[i][j]);
			}

			System.out.printf(" %15s%n", custName[i].trim());
		} // for

		System.out.print("Enter Customer Name (or Quit): ");
		findName = console.nextLine().trim();

		while (!findName.equalsIgnoreCase(SENTINAL_QUIT))
		{
			found = false;
			i = -1;

			while (i < (acceptCount-1) && !found)
			{
				i++;
				if (custName[i].equalsIgnoreCase(findName))
				{
					found = true;
				}
			}

			if (!found)
			{
				System.out.println("  Sorry Customer name no found - please try again.");
			}
			else
			{
				System.out.print("Select A/dd, N/ame, R/egion, S/earch, V/iew, or eXit: ");
				option = console.next().toLowerCase().charAt(0);
				console.nextLine();

				switch (option)
				{
					case 'a':
						do
						{
						System.out.print("Enter new Customer Id & Name (1..30): ");
						newId = console.nextInt();
						console.nextLine();
						System.out.print("Enter new Name (1..30): ");
						newName = console.nextLine().trim();
						}
						while (newName.length() < 1 || newName.length() > 30);


						custName[acceptCount] = newName;
						custDetails[acceptCount][0] = newId;

						custTypes[acceptCount] = 'a';
						custRegions[acceptCount] = "north";
						custStatuses[acceptCount] = 'a';


						for (i = 0; i < QUARTERS; i++)
						{
							custDetails[acceptCount][(i+1)] = 0;
						}

						acceptCount++;
						break;
					case 'n':
						System.out.println("Current Name: " + custName[i]);
						System.out.print("Enter new Name (1..30): ");
						newName = console.nextLine().trim();

						if (newName.length() < 1 || newName.length() > 30)
						{
							errorMessage = " - Invalid Name must be 1..30 Long:";
							txValid = false;
							break;
						}

						custName[i] = newName;
						break;
					case 'r':
						do
						{
							System.out.println("Current Region: " + custRegions[i]);
							System.out.print("Enter new Region (1/North, 2/South, 3/East, 4/West): ");
							newRegion = console.nextInt();
						}
						while (newRegion < 1 || newRegion > 4);

						console.nextLine();

						switch ((int) newRegion)
						{
							case 1:
								custRegions[i] = "north";
								break;
							case 2:
								custRegions[i] = "south";
								break;
							case 3:
								custRegions[i] = "east";
								break;
							case 4:
								custRegions[i] = "west";
								break;
						}
						break;
					case 's':
						System.out.print("Enter partial search Name: ");
						findName = console.nextLine().trim();
						i = -1;

						System.out.println("Cust Cust Cust   Cust    Q1    Q2    Q3    Q4       Cust");
						System.out.println(" Num Stat Type Region Usage Usage Usage Usage       Name");
						System.out.println("=================================================================");

						while (i < (acceptCount-1))
						{
							i++;
							if (custName[i].contains(findName))
							{
								System.out.printf("%4d %4s %4s %6s",
									custDetails[i][0], custTypes[i], custStatuses[i], custRegions[i]);
								for (j = 1; j <= QUARTERS; j++)
								{

									System.out.printf(" %5d", custDetails[i][j]);
								}

								System.out.printf(" %15s%n", custName[i].trim());
							}
						}
						break;
					case 'v':
						System.out.println("Cust Cust Cust   Cust    Q1    Q2    Q3    Q4       Cust");
						System.out.println(" Num Stat Type Region Usage Usage Usage Usage       Name");
						System.out.println("=================================================================");
						System.out.printf("%4d %4s %4s %6s",
							custDetails[i][0], custTypes[i], custStatuses[i], custRegions[i]);
						for (j = 1; j <= QUARTERS; j++)
						{
							System.out.printf(" %5d", custDetails[i][j]);
						}

						System.out.printf(" %15s%n", custName[i].trim());
						break;
					case 'x':
						break;
					default:
				} // switch
			}
			System.out.print("Enter Customer Name (or Quit): ");
			findName = console.nextLine();
		} // while

		// Nested fors/Output/Verify Master File arrays

		System.out.println("\nCust Cust Cust   Cust    Q1    Q2    Q3    Q4       Cust");
		System.out.println(" Num Stat Type Region Usage Usage Usage Usage       Name");
		System.out.println("=================================================================");

		for (i = 0; i < acceptCount; i++)
		{
			System.out.printf("%4d %4s %4s %6s",
				custDetails[i][0], custTypes[i], custStatuses[i], custRegions[i]);

			for (j = 1; j <= QUARTERS; j++)
			{

				System.out.printf(" %5d", custDetails[i][j]);
			}

			System.out.printf(" %15s%n", custName[i].trim());
		} // for

		// Compare arrays

		System.out.println("\nQuarter Before Use  After Use   Cust ID            Name");
		System.out.println("=========================================================");

		for (i = 0; i < acceptCountNoTx; i++)
		{
			for (j = 1; j <= QUARTERS; j++)
			{
				custDetailsNoTx[i][j] = custDetails[i][j];
				System.out.printf("%7d %10d %10d %9d %15s%n",
					j, custDetails[i][j], custDetailsNoTx[i][j], custDetails[i][0], custName[i]);
			}
		} // for

		outMismatchedRep.close();
    }  // main

} // WalshMarcusLabEx3
