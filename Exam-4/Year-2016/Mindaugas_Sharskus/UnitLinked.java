

/**
 *
 * @author Mindaugas
 */
public class UnitLinked extends InsurancePolicy{
    // Fields
    private static final int DEFAULT_FOUND = 10;
    private static int fund = DEFAULT_FOUND;
    
    // Constructors
    public UnitLinked(int fund, int policyNo, int commenseDate,
            double premium, Person policyName) {
        
        super(policyNo, commenseDate, premium, policyName);
        this.fund = fund;
    }

    public UnitLinked() {
    }
    
    // Setters
    public void setFund(int fund) {
        this.fund = fund;
    }
    
    // Getters
    public int getFund() {
        return fund;
    }

    @Override
    public String toString() {
        return "UnitLinked{" + "fund=" + fund + '}';
    }
    
    
}
