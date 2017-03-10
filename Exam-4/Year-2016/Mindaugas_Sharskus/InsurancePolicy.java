// Mindaugas Sharskus

public class InsurancePolicy{
  //  Fields
  private int policyNo;
  private double premium;
  private Person policyName;
  private int commenseDate;
  private boolean alive;

  //  Constructors
  public InsurancePolicy(int policyNo, int commenseDate,
                      double premium, Person policyName){
    this.policyNo = policyNo;
    this.premium = premium;
    this.policyName = policyName;
    this.commenseDate = commenseDate;
    this.alive = true;
  }

  public InsurancePolicy(){
    this(0, 999999, .0, null);
  }

  // Methods
  // Setters
  public void setInsurancePolicy(int policyNo, int commenseDate,
              double premium, Person policyName, boolean isAlive){
    this.policyNo = policyNo;
    this.premium = premium;
    this.policyName = policyName;
    this.commenseDate = commenseDate;
    this.alive = isAlive;
  }

  public void setInsPolicyNo(int policyNo){
    this.policyNo = policyNo;
  }

  public void setCommeneceDate(int commenseDate){
    this.commenseDate = commenseDate;
  }

  public void setPremium(double premium){
    this.premium = premium;
  }
  public void setPremium(int premium){
    this.premium += this.premium * premium *.01;
  }

  public void setIsAlive(boolean b){
    alive = b;
  }

  public void setPolicyName(Person person){
    policyName = person;
  }

  // Getters
  public int getPolicyNo(){
    return policyNo;
  }

  public int getCommenceDate(){
    return commenseDate;
  }

  public double getPremium(){
    return premium;
  }

  public boolean getIsAlive(){
    return alive;
  }

  public Person getPolicyName(){
    return policyName;
  }

  // Other
  @Override
  public String toString(){
    return "Insurance Policy:";
  }
}
