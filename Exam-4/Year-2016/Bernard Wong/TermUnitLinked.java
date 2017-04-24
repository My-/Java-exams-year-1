// TermUnitLinked - Bernard Wong

public class TermUnitLinked extends UnitLinked
{
//===  M e m b e r   V a r i a b l e s   ============================
	private int tulMatureDate;
	private Person tulLifeInsuredName;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public TermUnitLinked(){
		super();
		setTulMatureDate(999999);
		tulLifeInsuredName = new Person();
	}

	public TermUnitLinked(int policyNo, int commenceDate, double premium, boolean alive,
							String first, String last,
							int fund,
							int matureDate){
		super(policyNo, commenceDate, premium, alive, first, last, fund);
		setTulMatureDate(matureDate);
		tulLifeInsuredName = new Person();
	}

	public TermUnitLinked(int policyNo, int commenceDate, double premium, boolean alive,
							String first, String last,
							int fund,
							int matureDate, String tulFirst, String tulLast){
		super(policyNo, commenceDate, premium, alive, first, last, fund);
		setTulMatureDate(matureDate);
		tulLifeInsuredName = new Person(tulFirst, tulLast);
	}

	//=== Accessor and Mutator=======================================
	public void setTulMatureDate(int matureDate){
		tulMatureDate = matureDate;
	} //setTulMatureDate

	public int getTulMatureDate(){
		return tulMatureDate;
	} //getTulMatureDate

	//===============================================================
	public void setTulLifeInsuredName(String tulFirst, String tulLast){
		tulLifeInsuredName.setPerson(tulFirst, tulLast);
	} //setTulLifeInsuredName

	public String getTulLifeInsuredName(){
		return tulLifeInsuredName.toString();
	} //getTulLifeInsuredName

	//=== Other Methods==============================================
	public String toString(){
		String s = super.toString() +
					String.format("  Lif: %-15s %6d",  getTulLifeInsuredName(), getTulMatureDate());
		return s;
	} //toString

//===================================================================
} // TermUnitLinked