// UnitLinked - Bernard Wong

public class UnitLinked extends InsurancePolicy
{
//===  M e m b e r   V a r i a b l e s   ============================
	private static final int DEFAULT_FUND = 10;
	private int ulFund;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public UnitLinked(){
		super();
		setUlFund(DEFAULT_FUND);
	}

	public UnitLinked(int policyNo, int commenceDate, double premium, boolean alive,
							String first, String last,
							int fund){
		super(policyNo, commenceDate, premium, alive, first, last);
		setUlFund(fund);
	}

	//=== Accessor and Mutator=======================================
	public void setUlFund(int fund){
		ulFund = fund;
	} //setUlFund

	public int getUlFund(){
		return ulFund;
	} //getUlFund

	//=== Other Methods==============================================
	public String toString(){
		String s = super.toString() + "Fun: " + getUlFund();
		return s;
	} //toString

//===================================================================
} // UnitLinked