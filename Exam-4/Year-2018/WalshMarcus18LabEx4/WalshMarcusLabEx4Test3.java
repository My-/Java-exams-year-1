// Corrib Helicopters driver using a menu & an array of objects - Marcus Walsh

import java.util.Scanner;

public class WalshMarcusLabEx4Test3 // to be renamed
{
	public static Scanner console = new Scanner(System.in);

	public static final int HELICOPTERS = 9;

    public static void main(String[] args)
    {


		int i, choice, cnt, findHelicopterId, findPosition, changeCount;
		boolean found;
		double increaseAmount;
		int increasePercent;
		int heliId;
		String prefix;

		Helicopter [] heliArr = new Helicopter[HELICOPTERS];
		populateArray(heliArr);

		choice = showMenu(); // Initial read

		while (choice != 0) // Continue until 0/End sentinel encountered
		{
			switch (choice)
			{
				case 1:
					outputHeader();
					listAllHelicopters(heliArr);
					break; // case 1

				case 2:
					outputHeader();
					listAirAmbulances(heliArr);
					break; // case 2

				case 3:
					outputHeader();
					listAirTaxis(heliArr);
					break; // case 3

				case 4:
					outputHeader();
					listAirCargos(heliArr);
					break; // case 4

				case 5:
					outputHeader();
					listOnlyHelicopters(heliArr);
					break; // case 5

				case 6:
					outputHeader();
					listAwNonHelicopters(heliArr);
					break; // case 6

				case 7:
					System.out.print("  Enter Pilot Hours Range (int, int): ");
					int pilotMin = console.nextInt();
					int pilotMax = console.nextInt();

					outputHeader();
					cnt = listPilotHrsRange(heliArr, pilotMin, pilotMax);

					System.out.println(cnt + " Pilots in range " + pilotMin + " to " + pilotMax + "hours");
					break; // case 7

				case 8:
					System.out.print("  Enter Range increase amount(double, 0) or Range percent % increase (0.00, int): ");
					increaseAmount = console.nextDouble();
					increasePercent = console.nextInt();

					outputHeader();
					cnt = increaseHelicopterRange(heliArr, increaseAmount, increasePercent);

					System.out.println(cnt + " Helicopters ranges changed");
					break; // case 8

				case 9:
					System.out.print("  Enter Air Caro Capacity increase %: ");
					increasePercent = console.nextInt();

					outputHeader();
					cnt = increaseCargoCapacity(heliArr, increasePercent);

					System.out.println(cnt + " Air Cargo Capacity changed");
					break; // case 9

				case 10:
					findPosition = -1;
					System.out.print("  Enter Helicopter Id: ");
					heliId = console.nextInt();

					while (findPosition == -1)
					{
						findPosition = findHeliById(heliArr, heliId);

						if (findPosition != -1)
						{
							console.nextLine();
							System.out.print("  Enter new Make/Model: ");
							String newMakeModel = console.nextLine().trim();

							prefix = getPrefix(heliArr[findPosition]);
							outputHeader();
							System.out.println(prefix + " " + heliArr[findPosition].toString());
							heliArr[findPosition].setHeliMakeModel(newMakeModel);
							System.out.println(prefix + " " + heliArr[findPosition].toString());
						}
						else
						{
							System.out.println("  Helicopter Id not found  - please try again");
							System.out.print("  Enter Helicopter Id: ");
							heliId = console.nextInt();
						}
					}
					break; // case 10

				case 11:
					findPosition = -1;
					System.out.print("  Enter Helicopter Id: ");
					heliId = console.nextInt();

					while (findPosition == -1)
					{
						findPosition = findHeliById(heliArr, heliId);

						if (findPosition != -1)
						{
							if (!(heliArr[findPosition] instanceof AirTaxi))
							{
								System.out.println("  Not an Air Taxi - please try again");
							}
							else
							{
								AirTaxi t1 = (AirTaxi) heliArr[findPosition];

								System.out.print("  Enter passengers to be added: ");
								int passengersAdded = console.nextInt();

								outputHeader();
								System.out.println("Taxi  " + t1.toString());
								int currentPassengers = t1.getMaxPassengers();
								t1.setMaxPassengers(currentPassengers + passengersAdded);
								System.out.println("Taxi  " + t1.toString());
							}
						}
						else
						{
							System.out.println("  Helicopter Id not found  - please try again");
							System.out.print("  Enter Helicopter Id: ");
							heliId = console.nextInt();
						}
					}
					break; // case 11

				case 12:
					findPosition = -1;
					System.out.print("  Enter Helicopter Id: ");
					heliId = console.nextInt();

					while (findPosition == -1)
					{
						findPosition = findHeliById(heliArr, heliId);

						if (findPosition != -1)
						{
							if (!(heliArr[findPosition] instanceof AirAmbulance))
							{
								System.out.println("  Not an Air Ambulance - please try again");
							}
							else
							{
								console.nextLine();

								Pilot p1 = heliArr[findPosition].getPilot(1);

								System.out.print("  Enter new Pilot Name (not blank): ");
								String newName = console.nextLine().trim();

								outputHeader();
								System.out.println("Ambul " + heliArr[findPosition].toString());

								heliArr[findPosition].setPilot(p1.getPilotId(), newName, p1.getPilotHours());

								System.out.println("Ambul " + heliArr[findPosition].toString());
							}
						}
						else
						{
							System.out.println("  Helicopter Id not found  - please try again");
							System.out.print("  Enter Helicopter Id: ");
							heliId = console.nextInt();
						}
					}
					break; // case 12
				default:
					System.out.println("Invalid choice (must be 1..12 or 0/End)\n" );
			} // switch

			System.out.println();
			choice = showMenu(); // subsequent read

		} // while

    }// main

	public static int findHeliById(Helicopter[] heliArr, int heliId)
	{
		boolean found = false;
		int findPosition = -1;

		while (!found && findPosition < (HELICOPTERS-1))
		{
			findPosition++;

			if (heliArr[findPosition].getHelicopterId() == heliId)
			{
				found = true;
			}
		}

		if (!found)
		{
			findPosition = -1;
		}

		return findPosition;
	}

    public static int increaseCargoCapacity(Helicopter[] heliArr, int increasePercent)
	{
		int count = 0;
		double currentMaxCapacity;
		double newMaxCapacity;

		for (int i=0; i < HELICOPTERS; i++)
		{

			if (heliArr[i] instanceof AirCargo)
			{
				AirCargo c1 = (AirCargo) heliArr[i];
				count++;
				System.out.println("Cargo " + c1.toString());

				currentMaxCapacity = c1.getMaxCapacity();
				newMaxCapacity = currentMaxCapacity + (currentMaxCapacity * (increasePercent/100.0));
				c1.setMaxCapacity(newMaxCapacity);

				System.out.println("Cargo " + c1.toString());
			}
		}

		return count;
	}

    public static int increaseHelicopterRange(Helicopter[] heliArr, double increaseAmount, int increasePercent)
    {
		int count = 0;
		String prefix;

		for (int i=0; i < HELICOPTERS; i++)
		{
			count++;

			prefix = getPrefix(heliArr[i]);

			System.out.println(prefix + " " + heliArr[i].toString());

			if (increasePercent == 0)
			{
				heliArr[i].setHeliRange(increaseAmount);
			}
			else
			{
				heliArr[i].setHeliRange(increasePercent);
			}

			System.out.println(prefix + " " + heliArr[i].toString());
		}

		return count;
	}

    public static int listPilotHrsRange(Helicopter[] heliArr, int pilotMin, int pilotMax)
    {
		int count = 0;
		String prefix;

		for (int i=0; i < HELICOPTERS; i++)
		{
			Pilot p1 = heliArr[i].getPilot(1);
			int pilotHrs = p1.getPilotHours();

			if (pilotHrs > pilotMin && pilotHrs < pilotMax)
			{
				count++;
				prefix = getPrefix(heliArr[i]);
				System.out.println(prefix + " " + heliArr[i].toString());
			}
		}
		return count;
	}

    public static void listAwNonHelicopters(Helicopter[] heliArr)
    {
		for (int i=0; i < HELICOPTERS; i++)
		{
			if ((heliArr[i] instanceof AirCargo) || (heliArr[i] instanceof AirTaxi) || (heliArr[i] instanceof AirAmbulance))
			{
				if (heliArr[i].getHeliAllWeather())
				{
					System.out.println("Heli  " + heliArr[i].toString());
				}
			}
		}
	}

    public static void listOnlyHelicopters(Helicopter[] heliArr)
    {
		for (int i=0; i < HELICOPTERS; i++)
		{
			if (!(heliArr[i] instanceof AirCargo) && !(heliArr[i] instanceof AirTaxi) && !(heliArr[i] instanceof AirAmbulance))
			{
				System.out.println("Heli  " + heliArr[i].toString());
			}
		}
	}

    public static void listAirCargos(Helicopter[] heliArr)
    {
		for (int i=0; i < HELICOPTERS; i++)
		{
			if (heliArr[i] instanceof AirCargo)
			{
				System.out.println("Cargo " + heliArr[i].toString());
			}
		}
	}

    public static void listAirTaxis(Helicopter[] heliArr)
    {
		for (int i=0; i < HELICOPTERS; i++)
		{
			if (heliArr[i] instanceof AirTaxi)
			{
				System.out.println("Taxi  " + heliArr[i].toString());
			}
		}
	}

    public static void listAirAmbulances(Helicopter[] heliArr)
    {
		for (int i=0; i < HELICOPTERS; i++)
		{
			if (heliArr[i] instanceof AirAmbulance)
			{
				System.out.println("Ambul " + heliArr[i].toString());
			}
		}
	}

    public static void listAllHelicopters(Helicopter[] heliArr)
    {
		String prefix;

		for (int i=0; i < HELICOPTERS; i++)
		{
			prefix = getPrefix(heliArr[i]);
			System.out.println(prefix + " " +heliArr[i].toString());
		}
	}

	public static String getPrefix(Helicopter h1)
	{
		String prefix;

		if (h1 instanceof AirCargo)
		{
			prefix = "Cargo";
		}
		else if (h1 instanceof AirTaxi)
		{
			prefix = "Taxi ";
		}
		else if (h1 instanceof AirAmbulance)
		{
			prefix = "Ambul";
		}
		else
		{
			prefix = "Heli ";
		}

		return prefix;
	}

    public static void populateArray(Helicopter[] heliArr)
    {
		heliArr[0] = new Helicopter(1111, "Red Heli", true, 10001.1, 101, "Pilot A", 1001);
		heliArr[1] = new Helicopter(2222, "Green Heli", false, 20002.2, 202, "Pilot B", 2002);
		heliArr[2] = new Helicopter(3333, "Blue Heli", true, 30003.3, 303, "Pilot C", 3003);
		heliArr[3] = new AirAmbulance(4444, "Orange Heli", true, 40004.4, 404, "Pilot D", 4004);
		heliArr[4] = new AirAmbulance(5555, "Brown Heli", false, 50005.5, 505, "Pilot E", 5005);
		heliArr[5] = new AirTaxi(6666, "Grey Heli", true, 60006.6, 606, "Pilot F", 6006, 7);
		heliArr[6] = new AirTaxi(7777, "White Heli", true, 70007.7, 707, "Pilot G", 7007, 8);
		heliArr[7] = new AirCargo(8888, "Purple Heli", false, 80008.8, 808, "Pilot H", 8008, 8.8, 888);
		heliArr[8] = new AirCargo(9999, "Black Heli", true, 90009.9, 909, "Pilot I", 9009, 9.9, 999);

	}
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