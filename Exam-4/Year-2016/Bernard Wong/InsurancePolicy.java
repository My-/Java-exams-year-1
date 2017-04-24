// InsurancePolicy - Bernard Wong

public class InsurancePolicy
{
//===  M e m b e r   V a r i a b l e s   ============================
	private int insPolicyNo;
	private int insCommenceDate;
	private double insPremium;
	private boolean insAlive;
	private Person insPolicyName;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public InsurancePolicy(){
		setInsurancePolicy(0, 999999, 0.00, false);
		insPolicyName = new Person();
	}

	public InsurancePolicy(int policyNo, int commenceDate, double premium, boolean alive,
							String first, String last){
		setInsurancePolicy(policyNo, commenceDate, premium, alive);
		insPolicyName = new Person(first, last);
	}

	//=== Accessor and Mutator=======================================
	public void setInsurancePolicy(int policyNo, int commenceDate, double premium, boolean alive){
		setInsPolicyNo(policyNo);
		setInsCommenceDate(commenceDate);
		setInsPremium(premium);
		setInsAlive(alive);
	} //setPerson

	//===============================================================
	public void setInsPolicyNo(int policyNo){
		insPolicyNo = policyNo;
	} //setInsPolicyNo

	public int getInsPolicyNo(){
		return insPolicyNo;
	} //getInsPolicyNo

	//===============================================================
	public void setInsCommenceDate(int commenceDate){
		insCommenceDate = commenceDate;
	} //setInsCommenceDate

	public int getInsCommenceDate(){
		return insCommenceDate;
	} //getInsCommenceDate

	//===============================================================
	public void setInsPremium(double premium){
		insPremium = premium;
	} //setInsPremium

	public void setInsPremium(int premium){
		insPremium += insPremium * premium/100;
	} //setInsPremium (overload)

	public double getInsPremium(){
		return insPremium;
	} //getDateOfBirth

	//===============================================================
	public void setInsAlive(boolean alive){
		insAlive = alive;
	} //setInsAlive

	public boolean getInsAlive(){
		return insAlive;
	} //getInsAlive

	//===============================================================
	public void setInsPolicyName(String first, String last){
		insPolicyName.setPerson(first, last);
	} //setInsPolicyName

	public String getInsPolicyName(){
		return insPolicyName.toString();
	} //getInsPolicyName

	//=== Other Methods==============================================
	public String toString(){
		char alive;
		String s;

		if(getInsAlive()){
			alive = 'T';
		}
		else{
			alive = 'F';
		} // InsAlive character

		s = String.format("%5d %6d %7.2f %1c %-15s ", getInsPolicyNo(), getInsCommenceDate(), getInsPremium(), alive,getInsPolicyName());
		return s;
	} //toString

//===================================================================
} // InsurancePolicy