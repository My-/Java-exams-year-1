
/**
 *
 * @author Mindaugas
 */
public class LabEx4Test1 {
    
    public static void main(String[] args){
        
        // Test Person class
        System.out.println();
        Person p1 = new Person();
        Person p2 = new Person("Jhon", "Doe", 801217);
        System.out.println("p1: "+ p1);
        System.out.println("p2: "+ p2);
        p1.setFirstName("Buble");
        System.out.println("p1: "+ p1);
        
        // Test IsurancePolicy class
        System.out.println();
        InsurancePolicy ip1 = new InsurancePolicy();
        InsurancePolicy ip2 = new InsurancePolicy(11111, 110101, 111.11, p2);
        System.out.println("ip1: "+ ip1);
        System.out.println("ip2: "+ ip2);
        ip2.setPremium(10);
        System.out.println("ip2: "+ ip2);
        
        // Test InvestmentGuaranteed class
        System.out.println();
        InvestmentGuaranteed ig1 = new InvestmentGuaranteed();
        InvestmentGuaranteed ig2 = new InvestmentGuaranteed(99889.00, 250101, 33333, 330101, 333.33, p2, true);
        System.out.println("ig1: "+ ig1);
        System.out.println("ig2: "+ ig2);
        
        // Test UnitLinked class
        System.out.println();
        UnitLinked ul1 = new UnitLinked();
        UnitLinked ul2 = new UnitLinked(20, 66666, 660101, 66.66, new Person("Porky", "Pig", 200220));
        System.out.println("ul1: "+ ul1);
        System.out.println("ul2: "+ ul2);
        
        // Test TermUnitLinked
        System.out.println();
        TermUnitLinked t1 = new TermUnitLinked();
        TermUnitLinked t2 = new TermUnitLinked(560101, p1, 20, 77777, 770101, 77.77);
        System.out.println("t1: "+ t1);
        System.out.println("t2: "+ t2);
        
    }
}
