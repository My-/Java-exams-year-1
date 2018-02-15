// Comments here

import java.io.*;
import java.util.*;

public class LastNameFirstNameLabEx3
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


		// Employee Master File Variables (to supplement arrays)
		int empId;
		char empStatus;
		String empRest;

		// Employee Tx File Variables/File Layout
		int txEmpId;
		String txCode;
		int txAmount;

		// Other Variables
		int empAcceptCount, empRejectCount = 0, txAcceptCount = 0, txRejectCount = 0;
		int i, j, pos, empHolidays = 0, empSalary, noNameCount = 0;
		boolean foundEmployee, txError;
		String findEmployeeName, errorMessage, empName="";
		char option;
		Scanner console = new Scanner(System.in);

		// Headers
		System.out.println("Your Name - Employee Records - Lab Ex 3 - Feb 2016");
		System.out.println("====================================================================");
		System.out.println("Emp          Over    Car   Sale   Over   Hols  Month        Employee");
		System.out.println("Id St Dept  Night     Km   Comm   Time   Left Salary            Name");
		System.out.println("====================================================================");


		// Output/Verify Tx File (without rejected Tx)
		System.out.println("\nEmp   Tx      Tx\n Id Code  Amount\n================");


		// while ReProcess Tx File (inner while search) & Rejection Report
		outEmployeeRep.println("Mismatched Rejected Tx Report");
		outEmployeeRep.println("=============================");
		outEmployeeRep.println("Emp   Tx      Tx");
		outEmployeeRep.println(" Id Code  Amount");
		outEmployeeRep.println("================");

		// Output/Verify Tx File (with rejected Tx)
		System.out.println("\nEmp   Tx      Tx\n Id Code  Amount\n================");


    }  // main
} // LastNameFirstNameLabEx3