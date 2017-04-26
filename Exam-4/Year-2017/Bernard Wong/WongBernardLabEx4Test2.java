// WongBernardLabEx4Test2 driver class using array of objects - Bernard Wong

public class WongBernardLabEx4Test2
{
    public static void main (String [] args)
    {
		final int MAX_BYKES = 9;
		int i;
		String className, bikePrefix;

		System.out.println("Bernard Wong - Lab Exam 4 2017");
		System.out.println("     Id   Manufact Model     Price");
		System.out.println("===============================================================================");

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

		// Output
		for(i = 0; i < bike.length; i++){
			className = bike[i].getClass().getName();

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

			System.out.printf("%4s %1s\n", bikePrefix, bike[i].toString());
		} //for
    } // main

} // WongBernardLabEx4Test2