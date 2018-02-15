// WongBernardLabEx4Test1 simple object instances - Bernard Wong

public class WongBernardLabEx4Test1
{
    public static void main (String[] args)
    {
		// Header
		System.out.println("Bernard Wong - Lab Exam 4 2017");
		System.out.println("===============================================================================");

		// Test Engine Class
		Engine eng1 = new Engine();
		System.out.println("eng1: Eng: " + eng1.toString());

		eng1.setEngine('P', 12);
		System.out.println("eng1: Eng: " + eng1.toString());

		Engine eng2 = new Engine('D', 24);
		System.out.println("eng2: Eng: " + eng2.toString());

//=========================================================================
		System.out.println();
		System.out.println("    Id   Manufact Model     Price");
		System.out.println("===============================================================================");

		// Test Bike Class
		Bike b1 = new Bike();
		System.out.println("b1: " + b1.toString());

		b1.setBike(1111, "Aaaa", "Aaaa", 199.99);
		System.out.println("b1: " + b1.toString());

		Bike b2 = new Bike(2222, "Bbbb", "Bbbb", 299.99);
		System.out.println("b2: " + b2.toString());

		Bike b3 = new Bike(3333, 399.99);
		System.out.println("b3: " + b3.toString());

		System.out.println("b3.setBikeModel():");
		b3.setBikeModel(); // overload
		System.out.println("b3: " + b3.toString());

		System.out.println("Bike b4 = Bike b1; // copy constructor");
		Bike b4 = new Bike(b1);
		System.out.println("b4: " + b4.toString());
//=========================================================================
		// Test TrikeBike Class
		TrikeBike t1 = new TrikeBike();
		System.out.println("t1: " + t1.toString());

		t1.setBike(4444, "Dddd", "Dddd", 499.99);
		t1.setTrikeWheelSize(100);
		System.out.println("t1: " + t1.toString());

		TrikeBike t2 = new TrikeBike(5555, "Eeee", "Eeee", 599.99, 99);
		System.out.println("t2: " + t2.toString());
//=========================================================================
		// Test PushBike Class
		PushBike p1 = new PushBike();
		System.out.println("p1: " + p1.toString());

		p1.setBike(6666, "Ffff", "Ffff", 699.99);
		p1.setPushBike("Racing", 'M');
		System.out.println("p1: " + p1.toString());

		PushBike p2 = new PushBike(7777, "Gggg", "Gggg", 799.99, "Mountain", 'F');
		System.out.println("p2: " + p2.toString());
//=========================================================================
		// Test ElectricPushBike Class
		ElectricPushBike e1 = new ElectricPushBike();
		System.out.println("e1: " + e1.toString());

		e1.setBike(8888, "Hhhh", "Hhhh", 899.99);
		e1.setPushBike("Sports", 'M');
		e1.setBikeRange(77);
		e1.setEngine('E', 36);
		System.out.println("e1: " + e1.toString());

		ElectricPushBike e2 = new ElectricPushBike(9999, "Iiii", "Iiii", 999.99, "Racing", 'F', 88, 'E', 18);
		System.out.println("e2: " + e2.toString());

		System.out.println("e2.setBikeRange(0.10):");
		e2.setBikeRange(0.10); // overloaded
		System.out.println("e2: " + e2.toString());
	}// main

} // WongBernardLabEx4Test1