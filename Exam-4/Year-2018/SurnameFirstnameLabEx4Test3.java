// ??? driver using a menu & an array of objects - Your name here

import java.util.Scanner;

public class SurnameFirstNameLabEx4Test3 // to be renamed
{
    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args)
    {
        final int HELICOPTERS = 9;

        int i, choice, cnt, findHelicopterId, findPosition, changeCount;
        boolean found;

        // call populate object array method here

        choice = showMenu(); // Initial read

        while (choice != 0) // Continue until 0/End sentinel encountered
        {
            switch (choice)
            {
                case 1:
                    outputHeader();
                    break;

                default:
                    System.out.println("Invalid choice (must be 1..12 or 0/End)\n" );
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
        System.out.println("          Corrib Helicopter Menu Options - 0/End");
        System.out.println("=====================================================================");
        System.out.println(" 1: List Helicopters              2: List Air Ambulances");
        System.out.println(" 3: List Air Taxis                4: List Air Cargo");
        System.out.println(" 5: List Only Helicopters         6: List All Weather Non-Helicopters");
        System.out.println(" 7: List Pilot Hours Range        8: Increase Helicopter Range");
        System.out.println(" 9: Increase Air Cargo Capacity  10: Set Helicopter Make/Model");
        System.out.println("11: Add Air Taxi Passengers      12: Rename Air Ambulance Pilot");
        System.out.println();

        System.out.print("Enter option: ");
        choice = console.nextInt();

        return choice;
    } // showMenu
//===================================================================
    public static void outputHeader()
    {
        System.out.println();
        System.out.println("Class   Id  Make/Model AW     Range  Pilot        Hours ");
        System.out.println("============================================================================");
    } // outputHeader
//===================================================================


} // class
