// Corrib Helicopters driver class using array of objects - Marcus Walsh

public class WalshMarcusLabEx4Test2
{
    public static void main (String[] args)
    {
		final int HELICOPTERS = 9;
		Helicopter [] heliArr = new Helicopter[HELICOPTERS];
		String prefix;

		heliArr[0] = new Helicopter(1111, "Red Heli", true, 10001.1, 101, "Pilot A", 1001);
		heliArr[1] = new Helicopter(2222, "Green Heli", false, 20002.2, 202, "Pilot B", 2002);
		heliArr[2] = new Helicopter(3333, "Blue Heli", true, 30003.3, 303, "Pilot C", 3003);
		heliArr[3] = new AirAmbulance(4444, "Orange Heli", true, 40004.4, 404, "Pilot D", 4004);
		heliArr[4] = new AirAmbulance(5555, "Brown Heli", false, 50005.5, 505, "Pilot E", 5005);
		heliArr[5] = new AirTaxi(6666, "Grey Heli", true, 60006.6, 606, "Pilot F", 6006, 7);
		heliArr[6] = new AirTaxi(7777, "White Heli", true, 70007.7, 707, "Pilot G", 7007, 8);
		heliArr[7] = new AirCargo(8888, "Purple Heli", false, 80008.8, 808, "Pilot H", 8008, 8.8, 888);
		heliArr[8] = new AirCargo(9999, "Black Heli", true, 90009.9, 909, "Pilot I", 9009, 9.9, 999);

		System.out.println("Marcus Walsh: Lab Ex 4 April 2018 \n");
		System.out.println("Type    Id  Make/Model AW     Range   Id Pilot    Hours");
		System.out.println("==========================================================================");


		for (int i = 0; i < HELICOPTERS; i++)
		{
			if (heliArr[i] instanceof AirCargo)
			{
				prefix = "Cargo";
			}
			else if (heliArr[i] instanceof AirTaxi)
			{
				prefix = "Taxi ";
			}
			else if (heliArr[i] instanceof AirAmbulance)
			{
				prefix = "Ambul";
			}
			else
			{
				prefix = "Heli ";
			}
			System.out.println(prefix + " " +heliArr[i].toString());
		} // for
    } // main

} // class