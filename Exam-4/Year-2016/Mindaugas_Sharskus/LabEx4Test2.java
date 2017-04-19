
/**
 *
 * @author Mindaugas
 */
public class LabEx4Test2 {
    public static void main(String[] args){

        Person p = new Person("Jhon", "Doe", 801217);

        InsurancePolicy[] arr = {
             new InsurancePolicy(11111, 110101, 111.11, true, "Yogi", "Bear");
             new InsurancePolicy(22222, 220101, 22.22, false, "Micky", "Mouse");
             new InvestmentGuaranteed(33333, 330101, 333.33, true, "Wile", "Coyote", 200000, 250101);
             new InvestmentGuaranteed(44444, 440101, 44.44, false, "Winnie", "ThePooh", 100000, 201231);
             new UnitLinked(55555, 550101, 5.55, true, "Daffy", "Duck", 10);
             new UnitLinked(66666, 660101, 666.66, false, "Porky", "Pig", 20);
             new TermUnitLinked(77777, 770101, 77.77, true, "Betty", "Boop", 20, 440101, "Gerry", "Agnew");
             new TermUnitLinked(88888, 880101, 8.88, false, "Tweety", "Bird", 22, 560101, "Mary", "Murphy");
             new TermUnitLinked(99999, 990101, 9.99, false, "Bart", "Simpson", 30, 330101, "Paddy", "Reilly");
        };

        for(InsurancePolicy ip : arr){
            System.out.println(ip);
        }

    }
}
