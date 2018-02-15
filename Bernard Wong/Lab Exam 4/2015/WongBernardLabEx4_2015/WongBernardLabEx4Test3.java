// LabEx4Test3 driver using a menu & an array of objects - Bernard Wong

import java.util.Scanner;

public class WongBernardLabEx4Test3
{
	public static Scanner console = new Scanner(System.in);

    public static void main(String[] args)
    {
		final int MOBILE_PHONES = 9;

		int choice;

		// object array
		MobilePhone [] phone = new MobilePhone[MOBILE_PHONES];

		phone[0] = new MobilePhone(1111111, "Red fone", "Vodafone", true, 353, "Ireland");
		phone[1] = new MobilePhone(2222222, "Green fone", "Orange", false, 44, "Britain");
		phone[2] = new MobilePhone(3333333, "Blue fone", "O2", false, 234, "Spain");
		phone[3] = new EmployerPay(4444444, "Grey fone", "Talk Talk", false, 353, "Ireland", 1234);
		phone[4] = new EmployerPay(5555555, "Brown fone", "O2", false, 1, "USA", 3456);
		phone[5] = new PayAsGo(6666666, "Grey fone", "Vodafone", true, 353, "Ireland", 99.99);
		phone[6] = new PayAsGo(7777777, "White fone", "O2", true, 44, "Britain", 88.88);
		phone[7] = new BillPay(8888888, "Navy fone", "O2", false, 1, "USA", 50, 55.55);
		phone[8] = new BillPay(9999999, "Black fone", "Metear", true, 353, "Ireland",  300, 300.00);

		choice = showMenu(); // Initial read

		while (choice != 0) // Continue until 0/Exit sentinel encountered
		{
			switch (choice)
			{
				case 1:
					listAllPhones(phone);
					break;
				case 2:
					listEmployerPay(phone);
					break;
				case 3:
					listPayAsGo(phone);
					break;
				case 4:
					listBillPay(phone);
					break;
				case 5:
					onlyMobilePhones(phone);
					break;
				case 6:
					findEmployerId(phone);
					break;
				case 7:
					increaseProviderTexts(phone);
					break;
				case 8:
					renameCountry(phone);
					break;
				case 9:
					increaseCredit(phone);
					break;
				default:
					System.out.println("Invalid choice (must be 1..9 or 0/End)\n" );
			} // switch

			System.out.println();

			choice = showMenu(); // subsequent read

		} // while

    }// main

//==========================================================================================
 	public static int showMenu()
    {
		int choice;
		System.out.println();
        System.out.println("              Tribes Mobile Phone Menu Options");
        System.out.println("============================================================");
        System.out.println("1: List All Mobile Phones     2: List Employer Pay Phones");
        System.out.println("3: List Pay As Go Phones      4: List Bill Pay Phones");
        System.out.println("5: List Only Mobile Phones    6: Query Employer Pay Phones");
       	System.out.println("7: Inc Mobile Provider Texts  8: Rename Mobile Phone Country");
       	System.out.println("9: Increase Pay As Go Credit  0: Quit");
        System.out.println();

        System.out.print("Enter option: ");
        choice = console.nextInt();

        return choice;
    } // showMenu

//==========================================================================================
 	public static void outputHeader()
    {
		System.out.println();
		System.out.println(" Class Name  Number Phone Name  Provider    4G  Country Name ");
		System.out.println("===============================================================================");
	} //outputHeader

//==========================================================================================
 	public static void listAllPhones(MobilePhone[] phone)
    {
		String className;
		int i;
		outputHeader();

		for(i = 0; i < phone.length; i++){
			className = phone[i].getClass().getName();

			System.out.printf("%-11s %1s\n", className, phone[i].toString());
		} //for
	} //listAllPhones

//==========================================================================================
 	public static void listEmployerPay(MobilePhone[] phone)
    {
		String className;
		int i;
		outputHeader();

		for(i = 0; i < phone.length; i++){
			if(phone[i] instanceof EmployerPay){
				className = phone[i].getClass().getName();

				System.out.printf("%-11s %1s\n", className, phone[i].toString());
			} // if

		} //for
	} //listEmployerPay

//==========================================================================================
 	public static void listPayAsGo(MobilePhone[] phone)
    {
		String className;
		int i;
		outputHeader();

		for(i = 0; i < phone.length; i++){
			if(phone[i] instanceof PayAsGo){
				className = phone[i].getClass().getName();

				System.out.printf("%-11s %1s\n", className, phone[i].toString());
			} // if

		} //for
	} //listPayAsGo

//==========================================================================================
 	public static void listBillPay(MobilePhone[] phone)
    {
		String className;
		int i;
		outputHeader();

		for(i = 0; i < phone.length; i++){
			if(phone[i] instanceof BillPay){
				className = phone[i].getClass().getName();

				System.out.printf("%-11s %1s\n", className, phone[i].toString());
			} // if

		} //for
	} //listBillPay

//==========================================================================================
 	public static void onlyMobilePhones(MobilePhone[] phone)
    {
		String className;
		int i;
		outputHeader();

		for(i = 0; i < phone.length; i++){
			if(!(phone[i] instanceof EmployerPay ||
				phone[i] instanceof PayAsGo ||
				phone[i] instanceof BillPay)){
				className = phone[i].getClass().getName();

				System.out.printf("%-11s %1s\n", className, phone[i].toString());
			} // if

		} //for
	} //onlyMobilePhones

//==========================================================================================
 	public static void findEmployerId(MobilePhone[] phone)
    {
		String className;
		int findId, cnt = -1, foundPos = 0;
		boolean found = false;

		System.out.print("\n  Enter Employer Id: ");
		findId = console.nextInt();

		while(cnt < phone.length - 1 && found == false){
			cnt++;

			if(phone[cnt] instanceof EmployerPay){
				EmployerPay ep = (EmployerPay) phone[cnt]; // downcast

				if(ep.getEmployerId() == findId){
					foundPos = cnt;
					found = true;
				} // nested if
			} // if
		} // while

		if(found){
			outputHeader();
			className = phone[foundPos].getClass().getName();
			System.out.printf("%-11s %1s\n", className, phone[foundPos].toString());
		}
		else{
			System.out.println("\nNo qualifying Mobile Phones selected - try again");
		} // if.. else

	} //findEmployerId

//==========================================================================================
 	public static void increaseProviderTexts(MobilePhone[] phone)
    {
		String className, findProvider;
		int cnt = -1, foundPos = 0;
		boolean found = false;

		System.out.print("\n  Enter Provider Name: ");
		findProvider = console.next();

		while(cnt < phone.length - 1 && found == false){
			cnt++;

			if(phone[cnt] instanceof BillPay){
				BillPay bp = (BillPay) phone[cnt]; // downcast

				if(bp.getMobileProvider().equalsIgnoreCase(findProvider)){
					foundPos = cnt;
					found = true;
				} // nested if
			} // if
		} // while

		if(found){
			outputHeader();
			className = phone[foundPos].getClass().getName();
			System.out.printf("%-11s %1s\n", className, phone[foundPos].toString());

			// Increase Texts Lefts
			BillPay bp = (BillPay) phone[foundPos]; // downcast
			bp.setTextsLeft((int)(bp.getTextsLeft() * 1.75));
			System.out.printf("%-11s %1s\n", className, phone[foundPos].toString());
		}
		else{
			System.out.println("\nNo qualifying Mobile Phones selected - try again");
		} // if.. else

	} //increaseProviderTexts

//==========================================================================================
 	public static void renameCountry(MobilePhone[] phone)
    {
		String className, newCountry;
		int newId, findMobileNo, cnt = -1, foundPos = 0;
		boolean found = false;

		System.out.print("\n  Enter Mobile Number: ");
		findMobileNo = console.nextInt();

		while(cnt < phone.length - 1 && found == false){
			cnt++;

			if(phone[cnt].getMobileNumber() == findMobileNo){
				foundPos = cnt;
				found = true;
			} // if

		} // while

		if(found){
			outputHeader();
			className = phone[foundPos].getClass().getName();
			System.out.printf("%-11s %1s\n", className, phone[foundPos].toString());

			// Change Country Id and Name
			System.out.print("\n  Enter new Country Id & Name (int & String): ");
			newId = console.nextInt();
			newCountry = console.next();

			phone[foundPos].setCountry(newId, newCountry);
			System.out.printf("\n%-11s %1s\n", className, phone[foundPos].toString());
		}
		else{
			System.out.println("\n   Mobile Number not found - try again");
		} // if.. else

	} //renameCountry

//==========================================================================================
 	public static void increaseCredit(MobilePhone[] phone)
    {
		String className;
		int creditIncrease, findMobileNo, cnt = -1, foundPos = 0;
		double newCredit;
		boolean found = false;

		System.out.print("\n  Enter Mobile Number: ");
		findMobileNo = console.nextInt();

		while(cnt < phone.length - 1 && found == false){
			cnt++;

			if(phone[cnt].getMobileNumber() == findMobileNo){
				foundPos = cnt;
				found = true;
			} // if

		} // while

		if(found){
			if(phone[foundPos] instanceof PayAsGo){
				outputHeader();
				className = phone[foundPos].getClass().getName();
				System.out.printf("%-11s %1s\n", className, phone[foundPos].toString());

				// Increase Credit
				System.out.print("\n  Enter new Credit or Credit increase (double & int): ");
				newCredit = console.nextDouble();
				creditIncrease = console.nextInt();

				PayAsGo pg = (PayAsGo) phone[foundPos]; // downcast
				if(newCredit > 0){
					pg.setCreditBalance(newCredit);
				}
				else{
					pg.setCreditBalance(creditIncrease);
				} // nested if.. else determine new or increase credit
				System.out.printf("\n%-11s %1s\n", className, phone[foundPos].toString());
			}
			else{
				System.out.println("\n   Mobile Number  not a Pay as Go phone - try again");
			} // nested if.. else
		}
		else{
			System.out.println("\n   Mobile Number not found - try again");
		} // if.. else

	} //increaseCredit
//==========================================================================================
} // WongBernardLabEx4Test3