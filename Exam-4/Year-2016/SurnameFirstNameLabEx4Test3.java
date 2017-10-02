// ClassName - your name here

import java.util.Scanner;

public class SurnameFirstNameLabEx4Test3
{
	public static Scanner console = new Scanner(System.in);
	public static final int MAX_POLICY = 9;

    public static void main(String [] args)
    {
		final int SENTINEL_0 = 0;
		int choice;


		// Define & Populate the object array here


		choice = showMenu(); // Initial read

		while (choice != SENTINEL_0) // Continue until 0/Exit sentinel encountered
		{
			switch (choice)
			{


				default:
					System.out.println("Invalid choice (must be 1..11 or 0/End)\n" );
			} // switch

			System.out.println();
			choice = showMenu(); // subsequent read
		} // while
    }// main

//===================================================================
 	public static int showMenu()
    {
		int choice;
		System.out.println();
        System.out.println("====================  Corrib Insurances Menu Options  ======================");
        System.out.println(" 1: List All Insurance policies     2: List Investment Guaranteed policies");
        System.out.println(" 3: List Unit Linked policies       4: List Term Unit Linked policies");
        System.out.println(" 5: List All Unit Linked policies   6: List ordinary Insurance policies");
       	System.out.println(" 7: Increase Insurance Premiums     8: Change Unit Linked Fund");
       	System.out.println(" 9: Change the UL Policy Premium   10: Change Investment Guaranteed Lump Sum");
       	System.out.println("11: Change the Insured Name         0: Quit");
        System.out.println();

        System.out.print("Enter option: ");
        choice = console.nextInt();
        return choice;
    }
//===================================================================
 	public static void outputHeader()
    {
		System.out.println();
		System.out.println("Ref Policy   Comm Premium A Insured Name");
		System.out.println("===============================================================================");
	}
//===================================================================
} // SurnameFirstNameLabEx4Test3