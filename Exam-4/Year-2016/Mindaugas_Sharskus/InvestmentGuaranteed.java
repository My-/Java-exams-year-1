
// Mindaugas Sharskus



public class InvestmentGuaranteed extends InsurancePolicy{
  // Fields
  private double igLumpSum;
  private int igMatureDate;

  // Constructers
  public InvestmentGuaranteed(double lumpSum, int matureDate,
              int policyNo, int commenseDate, double premium,
                          Person policyName, boolean isAlive){
    super();
    super.setInsurancePolicy(policyNo, commenseDate, premium, policyName, isAlive);
    this.igLumpSum = lumpSum;
    this.igMatureDate = matureDate;

  }

  public InvestmentGuaranteed(){
    super();
    this.igLumpSum = .0;
    this.igMatureDate = 0;

  }

  // Setters
  public void setInvestmentGuaranteed(double lumpSum, int matureDate,
              int policyNo, int commenceDate, double premium,
                          Person policyName, boolean isAlive){

    setIgLumpSum(lumpSum);
    setIgMatureDate(matureDate);
    super(policyNo, commenceDate, premium, policyName, isAlive);

  }

    public void setIgLumpSum(double igLumpSum) {
        this.igLumpSum = igLumpSum;
    }

    public void setLumpSum(int lumpSum){
        this.igLumpSum -= lumpSum;
    }

    public void setIgMatureDate(int igMatureDate) {
        this.igMatureDate = igMatureDate;
    }

    //Getters

    public double getLumSum(){
         return igLumpSum;
    }

    public int getIgMatureDate(){
         return igMatureDate;
    }

    @Override
    public String toString(){

          String s = super.toString() + String.format("Lum: %9.2f Mat:%-15s", getLumpSum(), getIgMatureDate());
          return s;
    }


}
