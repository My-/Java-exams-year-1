// WongBernardLabEx4Test1 - Bernard Wong

public class WongBernardLabEx4Test1
{
    public static void main (String[] args)
    {
		// Header
		System.out.println("Bernard Wong - Lab Exam 4 2016\n");
		System.out.println("Ref Policy  Comm Premium A Insured Name");
		System.out.println("===============================================================================");

		// Test Person Class
		Person p1 = new Person();
		System.out.println("p1:                Person: " + p1.toString());

		p1.setPerson("Pink", "Panther");
		System.out.println("p1:                Person: " + p1.toString());

		Person p2 = new Person("Woody", "Woodpecker");
		System.out.println("p2:                Person: " + p2.toString());
		System.out.println();

		// Test InsurancePolicy Class
		InsurancePolicy i1 = new InsurancePolicy();
		System.out.println("i1: " + i1.toString());

		i1.setInsurancePolicy(11111, 110101, 111.11, true);
		i1.setInsPolicyName("Yogi", "Bear");
		System.out.println("i1: " + i1.toString());

		InsurancePolicy i2 = new InsurancePolicy(22222, 220101, 22.22, false, "Micky", "Mouse");
		System.out.println("i2: " + i2.toString());

		System.out.println("\ni2.setInsPremium(10)"); // Test overloaded
		i2.setInsPremium(10);
		System.out.println("i2: " + i2.toString());
		System.out.println();

		// Test InvestmentGuaranteed Class
		InvestmentGuaranteed g1 = new InvestmentGuaranteed();
		System.out.println("g1: " + g1.toString());

		g1.setInsurancePolicy(33333, 330101, 333.33, true);
		g1.setInsPolicyName("Wile", "Coyote");
		g1.setInvestmentGuaranteed(200000, 250101);
		System.out.println("g1: " + g1.toString());

		InvestmentGuaranteed g2 = new InvestmentGuaranteed(44444, 440101, 44.44, false, "Winnie", "ThePooh", 100000, 201231);
		System.out.println("g2: " + g2.toString());

		System.out.println("\ng2.setIgLumpSum(111)"); // Test overload
		g2.setIgLumpSum(111);
		System.out.println("g2: " + g2.toString());
		System.out.println();

		// Test UnitLinked Class
		UnitLinked u1 = new UnitLinked();
		System.out.println("u1: " + u1.toString());

		u1.setInsurancePolicy(55555, 550101, 5.55, true);
		u1.setInsPolicyName("Daffy", "Duck");
		u1.setUlFund(10);
		System.out.println("u1: " + u1.toString());

		UnitLinked u2 = new UnitLinked(66666, 660101, 666.66, false, "Porky", "Pig", 20);
		System.out.println("u2: " + u2.toString());
		System.out.println();

		// Test TermUnitLinked Class
		TermUnitLinked t1 = new TermUnitLinked();
		System.out.println("t1: " + t1.toString());

		t1.setInsurancePolicy(77777, 770101, 77.77, true);
		t1.setInsPolicyName("Betty", "Boop");
		t1.setUlFund(20);
		t1.setTulMatureDate(440101);
		t1.setTulLifeInsuredName("Gerry", "Agnew");
		System.out.println("t1: " + t1.toString());

		TermUnitLinked t2 = new TermUnitLinked(88888, 880101, 8.88, false, "Tweety", "Bird", 22, 560101, "Mary", "Murphy");
		System.out.println("t2: " + t2.toString());

		TermUnitLinked t3 = new TermUnitLinked(99999, 990101, 9.99, false,"Bart", "Simpson", 30, 330101);
		System.out.println("t3: " + t3.toString());

		t3.setTulLifeInsuredName("Paddy", "Reilly");
		System.out.println("t3: " + t3.toString());
		System.out.println();

    }// main

} // WongBernardLabEx4Test1