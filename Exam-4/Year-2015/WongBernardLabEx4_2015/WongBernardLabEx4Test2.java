// LabEx4Test2 driver class using array of objects - Bernard Wong

public class WongBernardLabEx4Test2
{
    public static void main (String[] args)
    {
		// Variables
		final int MOBILE_PHONES = 9;
		int i;
		String className;

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

		// Header
		System.out.println(" Class Name  Number Phone Name Provider    4G  Country Name ");
		System.out.println("===============================================================================");

		// Output
		for(i = 0; i < phone.length; i++){
			className = phone[i].getClass().getName();

			System.out.printf("%-11s %1s\n", className, phone[i].toString());
		} //for
    } // main

} // WongBernardLabEx4Test2