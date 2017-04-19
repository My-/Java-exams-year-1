
// Mindaugas Sharskus



public class InvestmentGuaranteed extends InsurancePolicy{
  // Fields
  private double lumpSum;
  private int matureDate;

  // Constructers
  public InvestmentGuaranteed(double lumpSum, int matureDate,
              int policyNo, int commenseDate, double premium,
                          Person policyName, boolean isAlive){
    super();
    super.setInsurancePolicy(policyNo, commenseDate, premium, policyName, isAlive);
    this.lumpSum = lumpSum;
    this.matureDate = matureDate;

  }

  public InvestmentGuaranteed(){
    super();
    this.lumpSum = .0;
    this.matureDate = 0;

  }

  // Setters
  public void setInvestmentGuaranteed(double lumpSum, int matureDate,
              int policyNo, int commenseDate, double premium,
                          Person policyName, boolean isAlive){

    this.lumpSum = lumpSum;
    this.matureDate = matureDate;
    super.setInsurancePolicy(policyNo, commenseDate, premium, policyName, isAlive);

  }

    public void setLumpSum(double lumpSum) {
        this.lumpSum = lumpSum;
    }

    public void setLumpSum(int lumpSum){
        this.lumpSum -= lumpSum;
    }

    public void setMatureDate(int matureDate) {
        this.matureDate = matureDate;
    }

    //Getters

    public double getLumSum(){
         return lumpSum;
    }

    public int getMatureDate(){
         return matureDate;
    }

    @Override
    public String toString(){

          String s = super.toString() + String.format("Lum: %9.2f Mat:%-15s", getLumpSum(), getMatureDate());
          return s;
    }


}
