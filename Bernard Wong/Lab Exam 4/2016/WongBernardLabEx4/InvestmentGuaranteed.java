// InvestmentGuaranteed - Bernard Wong

public class InvestmentGuaranteed extends InsurancePolicy
{
//===  M e m b e r   V a r i a b l e s   ============================
	private double igLumpSum;
	private int igMatureDate;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public InvestmentGuaranteed(){
		super();
		setInvestmentGuaranteed(0.00, 999999);
	}

	public InvestmentGuaranteed(int policyNo, int commenceDate, double premium, boolean alive,
							String first, String last,
							double lumpSum, int matureDate){
		super(policyNo, commenceDate, premium, alive, first, last);
		setInvestmentGuaranteed(lumpSum, matureDate);
	}

	//=== Accessor and Mutator=======================================
	public void setInvestmentGuaranteed(double lumpSum, int matureDate){
		setIgLumpSum(lumpSum);
		setIgMatureDate(matureDate);
	} //setInvestmentGuaranteed

	//===============================================================
	public void setIgLumpSum(double lumpSum){
		igLumpSum = lumpSum;
	} //setIgLumpSum

	public void setIgLumpSum(int lumpSum){
		igLumpSum -= lumpSum;
	} //setIgLumpSum

	public double getIgLumpSum(){
		return igLumpSum;
	} //getIgLumpSum

	//===============================================================
	public void setIgMatureDate(int matureDate){
		igMatureDate = matureDate;
	} //setIgMatureDate

	public int getIgMatureDate(){
		return igMatureDate;
	} //getIgMatureDate

	//=== Other Methods==============================================
	public String toString(){
		String s = super.toString() +
					String.format("Lum: %9.2f  Mat: %-15s", getIgLumpSum(), getIgMatureDate());
		return s;
	} //toString

//===================================================================
} // InvestmentGuaranteed