
/**
 *
 * @author Mindaugas
 */
public class LabEx4Test2 {
    public static void main(String[] args){
        
        Person p = new Person("Jhon", "Doe", 801217);
        
        Object[] arr = {
            new Person(),
            p,
            new InsurancePolicy(),
            new InsurancePolicy(11111, 110101, 111.11, p),
            new InvestmentGuaranteed(),
            new InvestmentGuaranteed(99889.00, 250101, 33333, 330101, 333.33, p, true),
            new UnitLinked(),
            new UnitLinked(20, 66666, 660101, 66.66, new Person("Porky", "Pig", 200220)),
            new TermUnitLinked(),
            new TermUnitLinked(560101, p, 20, 77777, 770101, 77.77)
        };
        
        for(Object obj : arr){
            System.out.println(obj);
        }
        
    }
}
