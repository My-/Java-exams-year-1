// WongBernardLabEx4Test2 - Bernard Wong

public class WongBernardLabEx4Test2
{
    public static void main (String [] args)
    {
		// Variables
		final int MAX_POLICY = 9;
		int i;
		String policyName, policyPrefix;

		// Header
		System.out.println("Bernard WOng - Lab Exam 4 2016 Object Array\n");
		System.out.println("Ref Policy   Comm Premium A Insured Name");
		System.out.println("===============================================================================");

		// Arrays
		InsurancePolicy [] policy = new InsurancePolicy[MAX_POLICY];

		policy[0] = new InsurancePolicy(11111, 110101, 111.11, true, "Yogi", "Bear");
		policy[1] = new InsurancePolicy(22222, 220101, 22.22, false, "Micky", "Mouse");
		policy[2] = new InvestmentGuaranteed(33333, 330101, 333.33, true, "Wile", "Coyote", 200000, 250101);
		policy[3] = new InvestmentGuaranteed(44444, 440101, 44.44, false, "Winnie", "ThePooh", 100000, 201231);
		policy[4] = new UnitLinked(55555, 550101, 5.55, true, "Daffy", "Duck", 10);
		policy[5] = new UnitLinked(66666, 660101, 666.66, false, "Porky", "Pig", 20);
		policy[6] = new TermUnitLinked(77777, 770101, 77.77, true, "Betty", "Boop", 20, 440101, "Gerry", "Agnew");
		policy[7] = new TermUnitLinked(88888, 880101, 8.88, false, "Tweety", "Bird", 22, 560101, "Mary", "Murphy");
		policy[8] = new TermUnitLinked(99999, 990101, 9.99, false,"Bart", "Simpson", 30, 330101, "Paddy", "Reilly");

		// Output
		for(i = 0; i < policy.length; i++){
			policyName = policy[i].getClass().getName();

			switch(policyName){
				case "InsurancePolicy":
					policyPrefix = "Ord";
					break;
				case "InvestmentGuaranteed":
					policyPrefix = "IG";
					break;
				case "UnitLinked":
					policyPrefix = "UL";
					break;
				case "TermUnitLinked":
					policyPrefix = "TUL";
					break;
				default:
					policyPrefix = "XXX";
			} // switch policyPrefix

			System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
		} //for
    }

} // WongBernardLabEx4Test2