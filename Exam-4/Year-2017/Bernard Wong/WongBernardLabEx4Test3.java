// WongBernardLabEx4Test3 driver using a menu & an array of objects - Bernard Wong

import java.util.Scanner;

public class WongBernardLabEx4Test3
{
	public static Scanner console = new Scanner(System.in);

    public static void main(String [] args)
    {
		// Variables
		final int SENTINEL_0 = 0, MAX_BYKES = 9;
		int choice;

		// Define & Populate the object array here
		// object array
		Bike [] bike = new Bike[MAX_BYKES];

		bike[0] = new Bike(1111, "Aaaa", "Aaaa", 199.99);
		bike[1] = new Bike(2222, "Bbbb", "Bbbb", 299.99);
		bike[2] = new Bike(3333, 399.99);
		bike[3] = new TrikeBike(4444, "Dddd", "Dddd", 499.99, 100);
		bike[4] = new TrikeBike(5555, "Eeee", "Eeee", 599.99, 99);
		bike[5] = new PushBike(6666, "Ffff", "Ffff", 699.99, "Racing", 'M');
		bike[6] = new PushBike(7777, "Gggg", "Gggg", 799.99, "Mountain", 'F');
		bike[7] = new ElectricPushBike(8888, "Hhhh", "Hhhh", 899.99, "Sports", 'M', 77, 'E', 36);
		bike[8] = new ElectricPushBike(9999, "Iiii", "Iiii", 999.99, "Racing", 'F', 88, 'E', 18);

		choice = showMenu(); // initial read

		while (choice != SENTINEL_0) // Continue until 0/Exit sentinel encountered
		{
			switch (choice)
			{
				case 1:
					listAllBikes(bike);
					break;
				case 2:
					listTrikeBikes(bike);
					break;
				case 3:
					listPushBikes(bike);
					break;
				case 4:
					listElectricPushBikes(bike);
					break;
				case 5:
					listAllPushBikes(bike);
					break;
				case 6:
					listOrdinaryBikes(bike);
					break;
				case 7:
					increaseBikePrice(bike);
					break;
				case 8:
					increaseElectricBikeRange(bike);
					break;
				case 9:
					changeBikePrice(bike);
					break;
				case 10:
					changeElectricBikeRange(bike);
					break;
				case 11:
					changeElectricBikeEngineWarranty(bike);
					break;
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
        System.out.println("========================  Western Bikes Menu Options  =========================");
        System.out.println(" 1: List All Bikes        2: List Trike Bikes");
        System.out.println(" 3: List Push Bikes       4: List Electric Push Bikes");
        System.out.println(" 5: List All Push Bikes   6: List only Bikes");
       	System.out.println(" 7: Increase Bike Prices  8: Increase Electric Bike Ranges");
       	System.out.println(" 9: Change a Bike Price  10: Change an Electric Bike Range");
       	System.out.println("11: Set Engine Warranty   0: Quit");
        System.out.println();

        System.out.print("Enter option: ");
        choice = console.nextInt();
        return choice;
    } // showMenu

//===================================================================
 	public static void outputHeader()
    {
		System.out.println("\n     Id   Manufact Model     Price");
		System.out.println("===============================================================================");
	} // outputHeader

//===================================================================
 	public static String getBikePrefix(String className)
    {
		String bikePrefix;

			switch(className){
				case "Bike":
					bikePrefix = "Bike";
					break;
				case "TrikeBike":
					bikePrefix = "Trik";
					break;
				case "PushBike":
					bikePrefix = "Push";
					break;
				case "ElectricPushBike":
					bikePrefix = "Elec";
					break;
				default:
					bikePrefix = "XXXX";
			} // switch bikePrefix

		return bikePrefix;
	} //getBikePrefix

//===================================================================
 	public static void listAllBikes(Bike[] bike)
    {
		String bikePrefix;
		int i;
		outputHeader();

		for(i = 0; i < bike.length; i++){
			bikePrefix = getBikePrefix(bike[i].getClass().getName());
			System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());
		} //for
	} // listAllBikes

//===================================================================
 	public static void listTrikeBikes(Bike[] bike)
    {
		String bikePrefix;
		int i;
		outputHeader();

		for(i = 0; i < bike.length; i++){
			if(bike[i] instanceof TrikeBike){
				bikePrefix = getBikePrefix(bike[i].getClass().getName());
				System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());
			} // if instanceof
		} //for
	} // listTrikeBikes

//===================================================================
 	public static void listPushBikes(Bike[] bike)
    {
		String bikePrefix;
		int i;
		outputHeader();

		for(i = 0; i < bike.length; i++){
			if(bike[i] instanceof PushBike == true &&
					bike[i] instanceof ElectricPushBike == false){
				bikePrefix = getBikePrefix(bike[i].getClass().getName());
				System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());
			} // if instanceof
		} //for
	} // listPushBikes

//===================================================================
 	public static void listElectricPushBikes(Bike[] bike)
    {
		String bikePrefix;
		int i;
		outputHeader();

		for(i = 0; i < bike.length; i++){
			if(bike[i] instanceof ElectricPushBike){
				bikePrefix = getBikePrefix(bike[i].getClass().getName());
				System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());
			} // if instanceof
		} //for
	} // listElectricPushBikes

//===================================================================
 	public static void listAllPushBikes(Bike[] bike)
    {
		String bikePrefix;
		int i;
		outputHeader();

		for(i = 0; i < bike.length; i++){
			if(bike[i] instanceof PushBike){
				bikePrefix = getBikePrefix(bike[i].getClass().getName());
				System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());
			} // if instanceof
		} //for
	} // listAllPushBikes

//===================================================================
 	public static void listOrdinaryBikes(Bike[] bike)
    {
		String bikePrefix;
		int i;
		outputHeader();

		for(i = 0; i < bike.length; i++){
			if(!(bike[i] instanceof TrikeBike ||
				bike[i] instanceof PushBike ||
				bike[i] instanceof ElectricPushBike)){
				bikePrefix = getBikePrefix(bike[i].getClass().getName());
				System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());
			} // if instanceof
		} //for
	} // listOrdinaryBikes

//===================================================================
 	public static void increaseBikePrice(Bike[] bike)
    {
		String bikePrefix;
		int i, increaseCount = 0;
		double priceIncrease, totalPrice;

		System.out.print("  Enter Price Increase: ");
		priceIncrease = console.nextDouble();

		outputHeader();

		for(i = 0; i < bike.length; i++){
			bikePrefix = getBikePrefix(bike[i].getClass().getName());
			System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());

			// Increase Price
			totalPrice = bike[i].getBikePrice() + priceIncrease;
			bike[i].setBikePrice(totalPrice);
			increaseCount++;
			System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());
		} //for

		System.out.println("\n" + increaseCount + " bikes increased by " + priceIncrease);
	} // increaseBikePrice

//===================================================================
 	public static void increaseElectricBikeRange(Bike[] bike)
    {
		String bikePrefix;
		int i, increaseCount = 0;
		double rangeIncrease;

		System.out.print("  Enter Electric Bike Range % increase: ");
		rangeIncrease = console.nextDouble();

		outputHeader();

		for(i = 0; i < bike.length; i++){
			if(bike[i] instanceof ElectricPushBike){
				bikePrefix = getBikePrefix(bike[i].getClass().getName());
				System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());

				// Increase Range
				ElectricPushBike eb = (ElectricPushBike) bike[i]; // downcast
				eb.setBikeRange(rangeIncrease);
				increaseCount++;
				System.out.printf("%4s %1s\n", bikePrefix, eb.toString());
			} // if instanceof
		} //for

		System.out.println("\n" + increaseCount + " electric Bike ranges increased by: " + (rangeIncrease*100) + "%");
	} // increaseElectricBikeRange

//===================================================================
 	public static void changeBikePrice(Bike[] bike)
    {
		String bikePrefix;
		int bikeId, cnt = -1, foundPos = 0;
		double newPrice;
		boolean found = false;

		System.out.print("\n  Enter Bike Id: ");
		bikeId = console.nextInt();

		while(cnt < bike.length - 1 && found == false){
			cnt++;

			if(bike[cnt].getBikeId() == bikeId){
				foundPos = cnt;
				found = true;
			} // if
		} // while search

		if(found){
			System.out.print("\n  Enter new Price: ");
			newPrice = console.nextDouble();

			outputHeader();
			bikePrefix = getBikePrefix(bike[foundPos].getClass().getName());
			System.out.printf("%4s %1s\n", bikePrefix, bike[foundPos].toString());

			// Change Price
			bike[foundPos].setBikePrice(newPrice);
			System.out.printf("%4s %1s\n", bikePrefix, bike[foundPos].toString());
		}
		else{
			System.out.println("\n   Bike Id not found - try again");
		} // if.. else found
	} // changeBikePrice

//===================================================================
 	public static void changeElectricBikeRange(Bike[] bike)
    {
		String bikePrefix;
		int newRange, bikeId, cnt = -1, foundPos = 0;
		double rangeIncrease;
		boolean found = false;

		System.out.print("\n  Enter Bike Id: ");
		bikeId = console.nextInt();

		while(cnt < bike.length - 1 && found == false){
			cnt++;

			if(bike[cnt].getBikeId() == bikeId){
				foundPos = cnt;
				found = true;
			} // if
		} // while search

		if(found){
			if(bike[foundPos] instanceof ElectricPushBike){
				System.out.print("\n  Enter new Range (int, 0.0) or Range increase % (0, double): ");
				newRange = console.nextInt();
				rangeIncrease = console.nextDouble();

				outputHeader();
				bikePrefix = getBikePrefix(bike[foundPos].getClass().getName());
				System.out.printf("%4s %1s\n", bikePrefix, bike[foundPos].toString());

				// Change Price
				ElectricPushBike eb = (ElectricPushBike) bike[foundPos]; // downcast

				if(newRange > 0){
					eb.setBikeRange(newRange);
				}
				else{
					eb.setBikeRange(rangeIncrease);
				} // inner if.. else determine new or increase range

				System.out.printf("%4s %1s\n", bikePrefix, eb.toString());
			}
			else{
				System.out.println("\n   Not an Electric Push Bike - try again");
			} // inner if.. else instanceof
		}
		else{
			System.out.println("\n   Bike Id not found - try again");
		} // if.. else found
	} // changeElectricBikeRange

//===================================================================
 	public static void changeElectricBikeEngineWarranty(Bike[] bike)
    {
		String bikePrefix;
		int newWarranty, bikeId, cnt = -1, foundPos = 0;
		boolean found = false;

		System.out.print("\n  Enter Bike Id: ");
		bikeId = console.nextInt();

		while(cnt < bike.length - 1 && found == false){
			cnt++;

			if(bike[cnt].getBikeId() == bikeId){
				foundPos = cnt;
				found = true;
			} // if
		} // while search

		if(found){
			if(bike[foundPos] instanceof ElectricPushBike){
				System.out.print("\n  Enter new Engine Warranty: ");
				newWarranty = console.nextInt();

				outputHeader();
				bikePrefix = getBikePrefix(bike[foundPos].getClass().getName());
				System.out.printf("%4s %1s\n", bikePrefix, bike[foundPos].toString());

				// Change Engine Warranty
				ElectricPushBike eb = (ElectricPushBike) bike[foundPos]; // downcast

				eb.setEngine(eb.getEngine().charAt(0), newWarranty);

				System.out.printf("%4s %1s\n", bikePrefix, eb.toString());
			}
			else{
				System.out.println("\n   Not an Electric Push Bike - try again");
			} // inner if.. else instanceof
		}
		else{
			System.out.println("\n   Bike Id not found - try again");
		} // if.. else found
	} // changeElectricBikeEngineWarranty

//===================================================================
} // WongBernardLabEx4Test3