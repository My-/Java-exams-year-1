// Engine inner class - Bernard Wong

public class Engine
{
//===  M e m b e r   V a r i a b l e s   ============================
	private static final int DEFAULT_WARRANTY = 36;
	private char engineType;
	private int engineMonthsWarranty;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public Engine(){
		setEngine('?', DEFAULT_WARRANTY);
	}

	public Engine(char type, int monthWarranty){
		setEngine(type, monthWarranty);
	}

	//=== Accessor and Mutator=======================================
	public void setEngine(char type, int monthWarranty){
		setEngineType(type);
		setEngineMonthsWarranty(monthWarranty);
	} //setEngine

	//===============================================================
	public void setEngineType(char type){
		engineType = type;
	} //setEngineType

	public char getEngineType(){
		return engineType;
	} //getEngineType

	//===============================================================
	public void setEngineMonthsWarranty(int monthWarranty){
		engineMonthsWarranty = monthWarranty;
	} //setEngineMonthsWarranty

	public int getEngineMonthsWarranty(){
		return engineMonthsWarranty;
	} //getEngineMonthsWarranty

	//=== Other Methods==============================================
	public String toString(){
		String s = getEngineType() + "" + getEngineMonthsWarranty();
		return s;
	} //toString

//===================================================================
} // Engine