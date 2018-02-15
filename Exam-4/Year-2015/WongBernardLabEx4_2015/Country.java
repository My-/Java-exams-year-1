// Country super class - Bernard Wong

public class Country
{

//===  M e m b e r   V a r i a b l e s   ============================
	private int countryId;
	private String countryName;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public Country(){
		setCountry(0, "noCountry");
	}

	public Country(int id, String name){
		setCountry(id, name);
	}

	//=== Accessor and Mutator=======================================
	public void setCountry(int id, String name){
		setCountryId(id);
		setCountryName(name);
	} //setCountry

	//===============================================================
	public void setCountryId(int id){
		countryId = id;
	} //setCountryId

	public int getCountryId(){
		return countryId;
	} //getCountryId

	//===============================================================
	public void setCountryName(String name){
		countryName = name;
	} //setCountryName

	public String getCountryName(){
		return countryName;
	} //getCountryName

	//=== Other Methods==============================================
	public String toString(){
		return String.format("%3d %-11s", getCountryId(),getCountryName());
	} //toString

//===================================================================
} // Country