
import java.util.Scanner;


/**
 *
 * @author Mindaugas
 */
public class LabEx4Test3 {
    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args){

        Person p = new Person("Jhon", "Doe", 801217);

        InsurancePolicy[] policies = {
            new InsurancePolicy(),
            new InsurancePolicy(11111, 110101, 111.11, p),
            new InvestmentGuaranteed(),
            new InvestmentGuaranteed(99889.00, 250101, 33333, 330101, 333.33, p, true),
            new UnitLinked(),
            new UnitLinked(20, 66666, 660101, 66.66, new Person("Porky", "Pig", 200220)),
            new TermUnitLinked(),
            new TermUnitLinked(560101, p, 20, 77777, 770101, 77.77)};

        int choice = -1;    // dummy initialization

        do{
            choice = showMenu();

            switch(choice){
                case 1:
                    //1: List All Insurance policies
                    listAllPolicies(policies);
                    break;
                case 2:
                    //2: List Investment Guaranteed policies
                    listGuaranteedPolicies(policies);
                    break;
                case 3:
                    //3: List Unit Linked policies
                    listLinkedPolicies(policies);
                    break;
                case 4:
                    //4: List Term Unit Linked policies
                    listTermUnitLinkedPolicies(policies);
                    break;
                case 5:
                    //5: List All Unit Linked policies
                    listAllUnitLinkedPolicies(policies);
                    break;
                case 6:
                    //6: List ordinary Insurance policies
                    listOrdinaryInsurancePolicies(policies);
                    break;
                case 7:
                    //7: Increase Insurance Premiums
                    increaseInsurancePremiums();
                    break;
                case 8:
                    //8: Change Unit Linked Fund
                    changeUnitLinkedFund();
                    break;
                case 9:
                    //9: Change the UL Policy Premium
                    changeULPolicyPremium();
                    break;
                case 10:
                    //10: Change Investment Guaranteed Lump Sum
                    changeInvestmentGuaranteedLumpSum();
                    break;
                case 11:
                    changeInsuredName();
                    break;
                default:
                    System.out.println("default. do smth");
            }

        }while(choice != 0);
    }

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
    }

    private static void listAllPolicies(InsurancePolicy[] ipa) {
        for(InsurancePolicy ip : ipa)
            System.out.println(ip);
    }

    private static void listPolicies(InsurancePolicy[] ipa, String policy){
        for(InsurancePolicy ip : ipa)
            if(ip.getClass().getName().equals(policy))
                System.out.println(ip);
    }

    private static void listGuaranteedPolicies(InsurancePolicy[] ipa) {
        listPolicies(ipa, "InvestmentGuaranteed");
    }

    private static void listLinkedPolicies(InsurancePolicy[] ipa) {
        listPolicies(ipa, "UnitLinked");
    }

    private static void listTermUnitLinkedPolicies(InsurancePolicy[] ipa) {
        listPolicies(ipa, "TermUnitLinked");
    }

    private static void listAllUnitLinkedPolicies(InsurancePolicy[] ipa) {
        listPolicies(ipa, "TermUnitLinked");
        listPolicies(ipa, "UnitLinked");
    }

    private static void listOrdinaryInsurancePolicies(InsurancePolicy[] ipa) {
        for(InsurancePolicy ip : ipa)
            if(ip.getClass().getName().equals("InsurancePolicy"))
                System.out.println(ip);
    }

    private static void increaseInsurancePremiums() {
        System.out.print("Enter Premium Increase %: ");
        int inPrem = console.nextInt();

    }

    private static void changeUnitLinkedFund() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void changeULPolicyPremium() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void changeInvestmentGuaranteedLumpSum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void changeInsuredName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
