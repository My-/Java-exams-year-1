// WongBernardLabEx4Test3 - Bernard Wong

import java.util.Scanner;

public class WongBernardLabEx4Test3
{
	public static Scanner console = new Scanner(System.in);
	public static final int MAX_POLICY = 9;

    public static void main(String [] args)
    {
		final int SENTINEL_0 = 0;
		int choice;

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

		choice = showMenu(); // Initial read

		while (choice != SENTINEL_0) // Continue until 0/Exit sentinel encountered
		{
			switch (choice)
			{
				case 1:
					listAllPolicies(policy);
					break;
				case 2:
					listInvestmentGuaranteed(policy);
					break;
				case 3:
					listUnitLinked(policy);
					break;
				case 4:
					listTermUnitLinked(policy);
					break;
				case 5:
					listAllUnitLinked(policy);
					break;
				case 6:
					listOrdinaryPolicies(policy);
					break;
				case 7:
					increaseInsurancePremium(policy);
					break;
				case 8:
					changeUlFund(policy);
					break;
				case 9:
					changeUlPolicyPremium(policy);
					break;
				case 10:
					break;
				case 11:
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
        System.out.println("====================  Corrib Insurances Menu Options  ======================");
        System.out.println(" 1: List All Insurance policies     2: List Investment Guaranteed policies");
        System.out.println(" 3: List Unit Linked policies       4: List Term Unit Linked policies");
        System.out.println(" 5: List All Unit Linked policies   6: List ordinary Insurance policies");
       	System.out.println(" 7: Increase Insurance Premiums     8: Change Unit Linked Fund");
       	System.out.println(" 9: Change the UL Policy Premium   10: Change Investment Guaranteed Lump Sum");
       	System.out.println("11: Change the Insured Name         0: Quit");
        System.out.println();

        System.out.print("Enter option: ");
        choice = console.nextInt();
        return choice;
    } //showMenu

//===================================================================
 	public static void outputHeader()
    {
		System.out.println();
		System.out.println("Ref Policy   Comm Premium A Insured Name");
		System.out.println("===============================================================================");
	} //outputHeader

//===================================================================
 	public static String getPolicyPrefix(String policyName)
    {
		String policyPrefix;

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

		return policyPrefix;
	} //getPolicyPrefix

//===================================================================
 	public static void listAllPolicies(InsurancePolicy[] policy)
    {
		String policyPrefix;
		int i;
		outputHeader();

		for(i = 0; i < policy.length; i++){
			policyPrefix = getPolicyPrefix(policy[i].getClass().getName());
			System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
		} //for
	} //listAllPolicies

//===================================================================
 	public static void listInvestmentGuaranteed(InsurancePolicy[] policy)
    {
		String policyPrefix;
		int i;
		outputHeader();

		for(i = 0; i < policy.length; i++){
			if(policy[i] instanceof InvestmentGuaranteed){
				policyPrefix = getPolicyPrefix(policy[i].getClass().getName());
				System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
			} // if
		} //for
	} //listInvestmentGuaranteed

//===================================================================
 	public static void listUnitLinked(InsurancePolicy[] policy)
    {
		String policyPrefix;
		int i;
		outputHeader();

		for(i = 0; i < policy.length; i++){
			if(policy[i] instanceof UnitLinked == true
				&& policy[i] instanceof TermUnitLinked == false){
				policyPrefix = getPolicyPrefix(policy[i].getClass().getName());
				System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
			} // if
		} //for
	} //listUnitLinked

//===================================================================
 	public static void listTermUnitLinked(InsurancePolicy[] policy)
    {
		String policyPrefix;
		int i;
		outputHeader();

		for(i = 0; i < policy.length; i++){
			if(policy[i] instanceof TermUnitLinked){
				policyPrefix = getPolicyPrefix(policy[i].getClass().getName());
				System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
			} // if
		} //for
	} //listTermUnitlinked

//===================================================================
 	public static void listAllUnitLinked(InsurancePolicy[] policy)
    {
		String policyPrefix;
		int i;
		outputHeader();

		for(i = 0; i < policy.length; i++){
			if(policy[i] instanceof UnitLinked){
				policyPrefix = getPolicyPrefix(policy[i].getClass().getName());
				System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
			} // if
		} //for
	} //listAllUnitLinked

//===================================================================
 	public static void listOrdinaryPolicies(InsurancePolicy[] policy)
    {
		String policyPrefix;
		int i;
		outputHeader();

		for(i = 0; i < policy.length; i++){
			if(!(policy[i] instanceof InvestmentGuaranteed ||
				policy[i] instanceof UnitLinked ||
				policy[i] instanceof TermUnitLinked)){
				policyPrefix = getPolicyPrefix(policy[i].getClass().getName());
				System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
			} // if
		} //for
	} //listOrdinaryPolicies

//===================================================================
 	public static void increaseInsurancePremium(InsurancePolicy[] policy)
    {
		String policyPrefix;
		int i, increaseRate, increaseCount = 0;

		System.out.print("  Enter Premium Increase %: ");
		increaseRate = console.nextInt();
		outputHeader();

		for(i = 0; i < policy.length; i++){
				policyPrefix = getPolicyPrefix(policy[i].getClass().getName());
				System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
				policy[i].setInsPremium(increaseRate);
				System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
				increaseCount++;
		} //for

		System.out.println("\n" + increaseCount + " policy premiums increased by " + increaseRate + "%");
	} //increaseInsurancePremium

//===================================================================
 	public static void changeUlFund(InsurancePolicy[] policy)
    {
		String policyPrefix;
		int i, oldUlFund, newUlFund, changeCount = 0;

		System.out.print("  Enter Old & New Ul Fund No: ");
		oldUlFund = console.nextInt();
		newUlFund = console.nextInt();
		outputHeader();

		for(i = 0; i < policy.length; i++){
			if(policy[i] instanceof UnitLinked){
				policyPrefix = getPolicyPrefix(policy[i].getClass().getName());
				System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
				UnitLinked ul = (UnitLinked) policy[i];

				if(oldUlFund == ul.getUlFund()){
					ul.setUlFund(newUlFund);
					changeCount++;
					System.out.printf("%3s %1s\n", policyPrefix, policy[i].toString());
				} // if find ulFund

			} // if
		} //for

		System.out.println("\n" + changeCount + " existing UL fund: " + oldUlFund + " changed to: " + newUlFund);
	} //changeUlFund

//===================================================================
 	public static void changeUlPolicyPremium(InsurancePolicy[] policy)
    {
		String policyPrefix;
		double newPremium;
		int i, policyNum, count, foundPos, incPremium;
		boolean found, loop = false;

		while(loop == false){
			count = -1;
			foundPos = 0;
			found = false;
			System.out.print("\n  Enter Policy Number: ");
			policyNum = console.nextInt();

			while(count < policy.length - 1 && found == false){
				count++;

				if(policy[count].getInsPolicyNo() == policyNum){
					found = true;
					foundPos = count;
				} // if
			} // while

			if(found){
				if(!(policy[foundPos] instanceof UnitLinked)){
					loop = false;
					System.out.println("\n   Not a Unit Linked policy - try again");
					continue;
				}else{
					loop = true;
				} // if

				System.out.print("\n  Enter new Premium or Premium increase % (double & int): ");
				newPremium = console.nextDouble();
				incPremium = console.nextInt();

				outputHeader();

				policyPrefix = getPolicyPrefix(policy[foundPos].getClass().getName());
				System.out.printf("%3s %1s\n", policyPrefix, policy[foundPos].toString());

				if(newPremium > 0){
					policy[foundPos].setInsPremium(newPremium);
				}
				else{
					policy[foundPos].setInsPremium(incPremium);
				} // if

				System.out.printf("%3s %1s\n", policyPrefix, policy[foundPos].toString());
			}
			else{
				System.out.println("\n   Policy Number not found - try again");
			} // if
		} // while

	} //changeUlPolicyPremium

} // WongBernardLabEx4Test3