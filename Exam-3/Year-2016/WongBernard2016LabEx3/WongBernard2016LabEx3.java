// WongBernard2016LabEx3 - Bernard Wong
// Corrib Water HR Employee Record Maintenance

import java.io.*;
import java.util.*;

public class WongBernard2016LabEx3
{
    public static void main(String[] args) throws FileNotFoundException
    {
		// Constants
		final int MAX_EMPLOYEES = 75, INT_ARRAY_ROWS = 7, SENTINEL_99999 = 99999;
		final String SENTINEL_QUIT = "QUIT";

		// File Objects
		Scanner inEmployeeFile = new Scanner(new FileReader("EmployeeMaster.dat"));
		Scanner inEmployeeTxFile = new Scanner(new FileReader("EmployeeTransactions.dat"));

		PrintWriter outEmployeeRep = new PrintWriter("EmployeeRejected.dat");
		PrintWriter outEmployeeFile = new PrintWriter("EmployeeNewMaster.dat");

		// 1/2 dim Arrays
		int[][] empCosts = new int[MAX_EMPLOYEES][INT_ARRAY_ROWS];
		char[] empStatuses = new char[MAX_EMPLOYEES];
		String[] empDepartments = new String[MAX_EMPLOYEES];
		String[] empNames = new String[MAX_EMPLOYEES];

		// Employee Master File Variables (to supplement arrays)
		int empId;
		char empStatus;
		String empRest;

		// Employee Tx File Variables/File Layout
		int txEmpId;
		String txCode;
		int txAmount;

		// Other Variables
		int empAcceptCount = -1, empRejectCount = 0, txAcceptCount = 0, txRejectCount = 0;
		int i, j, pos, empHolidays = 0, empSalary, noNameCount = 0;
		int empCount, txCount, column;
		boolean foundEmployee, txError;
		String findEmployeeName, errorMessage="", empName="";
		char option;
		Scanner console = new Scanner(System.in);

		// Headers
		System.out.println("Bernard Wong - Employee Records - Lab Ex 3 - Feb 2016");
		System.out.println("====================================================================");
		System.out.println("Emp          Over    Car   Sale   Over   Hols  Month        Employee");
		System.out.println("Id St Dept  Night     Km   Comm   Time   Left Salary            Name");
		System.out.println("====================================================================");

		// Employee Arrays
		empId =  inEmployeeFile.nextInt(); // initial read
		while(empId != SENTINEL_99999)
		{

			empStatus = inEmployeeFile.next().charAt(0);
			if(empStatus == 'x' || empStatus == 'X')
			{
				empRejectCount++;
				empRest = inEmployeeFile.nextLine();
				outEmployeeFile.printf("%3d %1s ", empId, empStatus);
				outEmployeeFile.println(empRest);
			}
			else
			{
				++empAcceptCount;
				empStatuses [empAcceptCount] = empStatus;
				empCosts [empAcceptCount][0] = empId;
				empDepartments [empAcceptCount] = inEmployeeFile.next().toLowerCase();

				System.out.printf("%3d %1c %4s", empCosts[empAcceptCount][0], empStatuses[empAcceptCount], empDepartments[empAcceptCount]);

				for(j = 1; j < INT_ARRAY_ROWS; j++)
				{
					empCosts[empAcceptCount][j] = inEmployeeFile.nextInt();
					System.out.printf("%7d", empCosts[empAcceptCount][j]);
				} // for

				empNames [empAcceptCount] = inEmployeeFile.nextLine().trim();
				System.out.printf("%16s", empNames[empAcceptCount]);

				System.out.println();
			}
			empId =  inEmployeeFile.nextInt(); // subsequent read
		} // while SENTINEL_99999 EOF

		// Footer
		empAcceptCount++;
		empCount = empRejectCount + empAcceptCount;
		System.out.printf("\nEmployee Count: %3d  Rejected: %3d  Accepted: %3d\n", empCount, empRejectCount, empAcceptCount);


		// Output/Verify Tx File (without rejected Tx)
		System.out.println("\nEmp   Tx      Tx\n Id Code  Amount\n================");

		txEmpId = inEmployeeTxFile.nextInt(); // initial read
		while(txEmpId != SENTINEL_99999)
		{
			txAcceptCount++;
			txCode = inEmployeeTxFile.next().toLowerCase();
			txAmount = inEmployeeTxFile.nextInt();

			System.out.printf("%3d %4s %7d\n", txEmpId, txCode, txAmount);

			txEmpId = inEmployeeTxFile.nextInt(); // subsequent read
		}

		// Footer
		txCount = txAcceptCount + txRejectCount;
		System.out.printf("\nTx: %2d Rej: %2d Acc: %2d\n", txCount, txRejectCount, txAcceptCount);

		// while ReProcess Tx File (inner while search) & Rejection Report
		outEmployeeRep.println("Mismatched Rejected Tx Report");
		outEmployeeRep.println("=============================");
		outEmployeeRep.println("Emp   Tx      Tx");
		outEmployeeRep.println(" Id Code  Amount");
		outEmployeeRep.println("================");
		System.out.println("\nEmp   Tx      Tx\n Id Code  Amount\n================");

		// Reopen Tx File
		inEmployeeTxFile.close();
		inEmployeeTxFile = new Scanner(new FileReader("EmployeeTransactions.dat"));

		// Reset
		txCount = 0;
		txAcceptCount = 0;

		txEmpId = inEmployeeTxFile.nextInt(); // initial read
		while(txEmpId != SENTINEL_99999)
		{
			txCode = inEmployeeTxFile.next().toLowerCase();
			txAmount = inEmployeeTxFile.nextInt();
			pos = -1;
			foundEmployee = false;
			txError = false;

			// Employee Id Rejection
			while (pos < empAcceptCount - 1 && foundEmployee == false)
			{
				++pos;
				if (empCosts[pos][0] == txEmpId){
					foundEmployee = true;
				}
				else if (empCosts[pos][0] > txEmpId){
					break;
				} // if
			} // while

			if (foundEmployee)
			{
				// Valid Tx Code Rejection
				switch(txCode)
				{
					case "nite":
						empCosts[pos][1] += txAmount;
						break;
					case "km":
						empCosts[pos][2] += txAmount;
						break;
					case "comm":
						if(!empDepartments[pos].equalsIgnoreCase("sale"))
						{
							txError = true;
							errorMessage = "Commission only for Sales";
						}
						else
						{
							empCosts[pos][3] += txAmount;
						} // if commision only for sales rejection

						break;
					case "otim":
						empCosts[pos][4] += txAmount;
						break;
					case "hols":
						empCosts[pos][5] += txAmount;
						break;
					case "sal":
						empCosts[pos][6] += txAmount;
						break;
					case "ret":
						empStatuses[pos] = 'R';
						break;
					case "dept":
						switch(txAmount)
						{
							case 1:
								empDepartments[pos] = "Sale";
								break;
							case 2:
								empDepartments[pos] = "Admn";
								break;
							case 3:
								empDepartments[pos] = "IT";
								break;
							case 4:
								empDepartments[pos] = "Dist";
								break;
						} // inner switch change department
						break;
					default:
						txError = true;
						errorMessage = "Invalid Tx Code";
				} // switch

				if(txError)
				{
					txRejectCount++;
					outEmployeeRep.printf("%3d %4s %7d - %25s %n", txEmpId, txCode, txAmount, errorMessage);
				}
				else
				{
					txAcceptCount++;
					System.out.printf("%3d %4s %7d\n", txEmpId, txCode, txAmount);
				} // if determine error message

			}
			else
			{
				txRejectCount++;
				outEmployeeRep.printf("%3d %4s %7d - Mismatched Employee Id %n", txEmpId, txCode, txAmount);
			} // if found employee

			txEmpId = inEmployeeTxFile.nextInt(); // subsequent read
		} // while

		// Footer
		txCount = txAcceptCount + txRejectCount;
		System.out.printf("\nTx: %2d Rej: %2d Acc: %2d\n", txCount, txRejectCount, txAcceptCount);

		// Output After Update
		// Headers
		System.out.println("\nEmp          Over    Car   Sale   Over   Hols  Month        Employee");
		System.out.println("Id St Dept  Night     Km   Comm   Time   Left Salary            Name");
		System.out.println("====================================================================");

		// Employee Arrays
		for(i = 0; i < empAcceptCount; ++i)
		{
				System.out.printf("%3d %1c %4s", empCosts[i][0], empStatuses[i], empDepartments[i]);

				for(j = 1; j < INT_ARRAY_ROWS; j++)
				{
					System.out.printf("%7d", empCosts[i][j]);
				} // inner for j

				System.out.printf("%16s\n", empNames[i]);
		} // for i

		// Footer
		System.out.printf("\nEmployee Count: %3d  Rejected: %3d  Accepted: %3d\n\n", empCount, empRejectCount, empAcceptCount + 1);

		// Prompt employee name
		System.out.print("Enter Employee Name (Quit to end): ");
		findEmployeeName = console.nextLine(); // initial read

		// search employee name
		while(!findEmployeeName.equalsIgnoreCase(SENTINEL_QUIT))
		{
			foundEmployee = false;
			pos = -1;

			while (pos < empAcceptCount - 1 && foundEmployee == false)
			{
				++pos;
				if (empNames[pos].equalsIgnoreCase(findEmployeeName)){
					foundEmployee = true;
				} // if
			} // while

			if(!foundEmployee)
			{
				System.out.println("Sorry Employee name not found - please try again.");
			}
			else
			{
				System.out.print("  Select D/isplay, H/olidays, N/ame or eXit: ");
				option = console.next().charAt(0);

				switch(option)
				{
					case 'h':
					case 'H':
						do
						{
							System.out.println("  Current Holidays: " + empCosts[pos][5]);
							System.out.print("Enter new Holidays (5..30): ");
							empHolidays = console.nextInt();
						} while(empHolidays < 5 || empHolidays > 30);
						empCosts[pos][5] = empHolidays;
						console.nextLine();
						break;
					case 'n':
					case 'N':
						console.nextLine();
						do
						{
							System.out.println("  Current Name: " + empNames[pos]);
							System.out.print("Enter new name (not blank): ");
							empName = console.nextLine();
						} while(empName.length() < 1);
						empNames[pos] = empName;
						break;
					case 'd':
					case 'D':
						// Headers
						System.out.println("\nEmp          Over    Car   Sale   Over   Hols  Month        Employee");
						System.out.println("Id St Dept  Night     Km   Comm   Time   Left Salary            Name");
						System.out.println("====================================================================");

						// Employee Arrays
						for(i = 0; i < empAcceptCount; ++i)
						{
								System.out.printf("%3d %1c %4s", empCosts[i][0], empStatuses[i], empDepartments[i]);

								for(j = 1; j < INT_ARRAY_ROWS; j++)
								{
									System.out.printf("%7d", empCosts[i][j]);
								} // inner for j

								System.out.printf("%16s\n", empNames[i]);
						} // for i

						// Footer
						System.out.printf("\nEmployee Count: %3d  Rejected: %3d  Accepted: %3d\n\n", empCount, empRejectCount, empAcceptCount + 1);
						console.nextLine();
						break;
					case 'x':
					case 'X':
						console.nextLine();
						break;
					default:
						System.out.println("  Sorry must enter: D/isplay, H/olidays, N/ame or eXit.");
						console.nextLine();
				} // switch

			} // if

			System.out.print("Enter Employee Name (Quit to end): ");
			findEmployeeName = console.nextLine(); // subsequent read
		} // while SENTINEL_QUIT EOF

		// Output updated arrays to new output file
		for(i = 0; i < empAcceptCount; ++i)
		{
			outEmployeeFile.printf("%3d %1c %4s", empCosts[i][0], empStatuses[i], empDepartments[i]);

				for(j = 1; j < INT_ARRAY_ROWS; j++)
				{
					outEmployeeFile.printf("%7d", empCosts[i][j]);
				} // inner for j

			outEmployeeFile.printf("%16s%n", empNames[i]);

		} // for

		outEmployeeFile.println(SENTINEL_99999);

		// Close Files
		inEmployeeFile.close();
		inEmployeeTxFile.close();
		outEmployeeRep.close();
		outEmployeeFile.close();
    }  // main
} // WongBernard2016LabEx3