// LabEx4Test1 simple object instances - Bernard Wong

public class WongBernardLabEx4Test1
{
    public static void main (String[] args)
    {
		// Header
		System.out.println("Ref  Number       Name   Provider   4G  Country Id/Name ");
		System.out.println("=============================================================================");

		// Test Country Class
		Country c1 = new Country();
		System.out.println("c1:                                     " + c1.toString());

		c1.setCountry(353, "Ireland");
		System.out.println("c1:                                     " + c1.toString());

		Country c2 = new Country(44, "Britain");
		System.out.println("c2:                                     " + c2.toString());
		System.out.println();

		// Test MobilePhone Class
		MobilePhone m1 = new MobilePhone();
		System.out.println("m1: " + m1.toString());

		m1.setMobilePhone(1111111, "Red fone", "Vodafone", true);
		m1.setCountry(353, "Ireland");
		System.out.println("m1: " + m1.toString());

		MobilePhone m2 = new MobilePhone(2222222, "Green fone", "Orange", false, 44, "Britain");
		System.out.println("\nm2: " + m2.toString());

		MobilePhone m3 = new MobilePhone(3333333, "Blue fone", "O2", false);
		System.out.println("\nm3: " + m3.toString());
		m3.setCountry(234, "Spain");
		System.out.println("m3: " + m3.toString());
		System.out.println();

		// Test EmployerPay Class
		EmployerPay e1 = new EmployerPay();
		System.out.println("e1: " + e1.toString());

		e1.setMobilePhone(4444444, "Grey fone", "Talk Talk", false);
		e1.setCountry(353, "Ireland");
		e1.setEmployerId(1234);
		System.out.println("e1: " + e1.toString());

		EmployerPay e2 = new EmployerPay(5555555, "Brown fone", "O2", false, 1, "USA", 3456);
		System.out.println("\ne2: " + e2.toString());
		System.out.println();

		// Test PayAsGo Class
		PayAsGo g1 = new PayAsGo();
		System.out.println("g1: " + g1.toString());

		g1.setMobilePhone(6666666, "Grey fone", "Vodafone", true);
		g1.setCountry(353, "Ireland");
		g1.setCreditBalance(99.99);
		System.out.println("g1: " + g1.toString());

		PayAsGo g2 = new PayAsGo(7777777, "White fone", "O2", true, 44, "Britain", 88.88);
		System.out.println("\ng2: " + g2.toString());
		System.out.println();

		// Test BillPay Class
		BillPay b1 = new BillPay();
		System.out.println("b1: " + b1.toString());

		b1.setMobilePhone(8888888, "Navy fone", "O2", false);
		b1.setCountry(1, "USA");
		b1.setBillPay(50, 55.55);
		System.out.println("b1: " + b1.toString());

		BillPay b2 = new BillPay(9999999, "Black fone", "Metear", true, 353, "Ireland",  300, 300.00);
		System.out.println("\nb2: " + b2.toString());

    }// main

} // WongBernardLabEx4Test1