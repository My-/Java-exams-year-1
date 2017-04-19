// Mindaugas Sharskus

public class InsurancePolicy{
  //  Fields
  private int insPolicyNo;
  private double insPremium;
  private Person insPolicyName;
  private int insCommenceDate;
  private boolean insAlive;

  //  Constructors
  public InsurancePolicy(int insPolicyNo, int insCommenceDate, double insPremium, boolean alive,
                         String firstName, String lastName){

      setInsurancePolicy(insPolicyNo, insCommenceDate, insPremium, alive);
      setInsPolicyName(firstName, lastName);
  }

  public InsurancePolicy(int insPolicyNo, int insCommenceDate, double insPremium, boolean alive){
      setInsurancePolicy(insPolicyNo, insCommenceDate, insPremium, alive);
      insPolicyName = new Person();
  }

  // Getters

    public void setInsurancePolicy(int insPolicyNo, int insCommenceDate, double insPremium, boolean alive){
        setInsPolicyNo(insPolicyNo);
        setInsCommenceDate(insCommenceDate);
        setInsPremium(insPremium);
        setInsAlive(alive);


    }
    public int getInsPolicyNo() {
        return insPolicyNo;
    }

    public double getInsPremium() {
        return insPremium;
    }

    public Person getInsPolicyName() {
        return insPolicyName;
    }

    public int getCommenceDate() {
        return insCommenceDate;
    }

    public boolean isInsAlive() {
        return insAlive;
    }


    public void setInsPolicyNo(int insPolicyNo) {
        this.insPolicyNo = insPolicyNo;
    }

    public void setInsPremium(double insPremium) {
        this.insPremium = insPremium;
    }

    public void setPremium(int premium) {
        this.insPremium += this.insPremium * premium * 0.01;
    }

    public void setInsPolicyName(String firstName, String lastName) {
        insPolicyName = new Person(firstName, lastName);
    }

    public void setInsCommenceDate(int insCommenceDate) {
        this.insCommenceDate = insCommenceDate;
    }

    public void setInsAlive(boolean insAlive) {
        this.insAlive = insAlive;
    }

    @Override
    public String toString() {
        //return "InsurancePolicy{" + "insPolicyNo=" + insPolicyNo + ", insPremium=" + insPremium + ", insPolicyName=" + insPolicyName + ", insCommenceDate=" + insCommenceDate + ", insAlive=" + insAlive + '}';
        char alive = 'F';

		if (isInsAlive()) {
			alive = 'T';
		}

		String s = String.format("%5d %6d %7.2f %1c %-15s ", getInsPolicyNo(), getCommenceDate(), getInsPremium(),
				alive, getInsPolicyName());

		return s;
    }


}
