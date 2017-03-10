// Mindaugas Sharskus

public class InvestmentGuaranteed extends InsurancePolicy{
  // Fields
  private double lumpSum;
  private int matureDate;

  // Constructers
  public InvestmentGuaranteed(double lumpSum, int matureDate,
              int policyNo, int commenseDate, double premium,
                          Person policyName, boolean isAlive){
    this.lumpSum = lumpSum;
    this.matureDate = matureDate;
    super(policyNo, commenseDate, premium, policyName, isAlive);
  }

  public InvestmentGuaranteed(){
    this.lumpSum = .0;
    this.matureDate = 0;
    super();
  }

  // Setters
  public void setInvestmentGuaranteed(double lumpSum, int matureDate,
              int policyNo, int commenseDate, double premium,
                          Person policyName, boolean isAlive){
    this.lumpSum = lumpSum;
    this.matureDate = matureDate;
    super.policyNo = policyNo;
    
  }
}
