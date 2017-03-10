// Mindaugas Sharskus

public class InsurancePolicy{
  //  Fields
  private int policyNo;
  private double premium;
  private Person policyName;
  private int commenseDate;
  private boolean alive;

  //  Constructors
  public InsurancePolicy(int policyNo, int commenseDate, double premium,
          Person policyName){
      
    this.policyNo = policyNo;
    this.premium = premium;
    this.policyName = policyName;
    this.commenseDate = commenseDate;
    this.alive = true;
  }

  public InsurancePolicy(){
    this(0, 0, .0, new Person());
  }
  
  // Getters

    public int getPolicyNo() {
        return policyNo;
    }

    public double getPremium() {
        return premium;
    }

    public Person getPolicyName() {
        return policyName;
    }

    public int getCommenseDate() {
        return commenseDate;
    }

    public boolean isAlive() {
        return alive;
    }
    
    // Setters
    public void setInsurancePolicy(int policyNo, int commenseDate, double premium, Person policyName, boolean alive){
        this.policyNo = policyNo;
        this.commenseDate = commenseDate;
        this.premium = premium;
        this.policyName = policyName;
        this.alive = alive;
    }
    
    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }
    
    public void setPremium(int premium) {
        this.premium += this.premium * premium * 0.01;
    }

    public void setPolicyName(Person policyName) {
        this.policyName = policyName;
    }

    public void setCommenseDate(int commenseDate) {
        this.commenseDate = commenseDate;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" + "policyNo=" + policyNo + ", premium=" + premium + ", policyName=" + policyName + ", commenseDate=" + commenseDate + ", alive=" + alive + '}';
    }
  
    
}
