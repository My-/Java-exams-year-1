// MobilePhone super class - Bernard Wong

public class MobilePhone
{

//===  M e m b e r   V a r i a b l e s   ============================
	private int mobileNumber;
	private String mobileName;
	private String mobileProvider;
	private boolean mobile4G;
	private Country country;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public MobilePhone(){
		setMobilePhone(0, "noName", "noProv", false);
		country = new Country();
	}

	public MobilePhone(int number, String name, String provider, boolean is4G){
		setMobilePhone(number, name, provider, is4G);
		country = new Country();
	}

	public MobilePhone(int number, String name, String provider, boolean is4G,
						int id, String countryName){
		setMobilePhone(number, name, provider, is4G);
		country = new Country(id, countryName);
	}

	//=== Accessor and Mutator=======================================
	public void setMobilePhone(int number, String name, String provider, boolean is4G){
		setMobileNumber(number);
		setMobileName(name);
		setMobileProvider(provider);
		setMobile4G(is4G);
	} //setCountry

	//===============================================================
	public void setMobileNumber(int number){
		mobileNumber = number;
	} //setMobileNumber

	public int getMobileNumber(){
		return mobileNumber;
	} //getMobileNumber

	//===============================================================
	public void setMobileName(String name){
		mobileName = name;
	} //setMobileName

	public String getMobileName(){
		return mobileName;
	} //getMobileName

	//===============================================================
	public void setMobileProvider(String provider){
		mobileProvider = provider;
	} //setMobileProvider

	public String getMobileProvider(){
		return mobileProvider;
	} //getMobileProvider

	//===============================================================
	public void setMobile4G(boolean is4G){
		mobile4G = is4G;
	} //setMobile4G

	public boolean getMobile4G(){
		return mobile4G;
	} //getMobile4G

	//===============================================================
	public void setCountry(int id, String countryName){
		country.setCountry(id, countryName);
	} //setCountryName

	public String getCountry(){
		return country.toString();
	} //getCountryName


	//=== Other Methods==============================================
	public String toString(){
		String s, got4G;

		if(getMobile4G()){
			got4G = "true";
		}
		else{
			got4G = "false";
		} // if

		s = String.format("%7d %10s %9s %5s  %15s"
			,getMobileNumber(),getMobileName(), getMobileProvider(), got4G, getCountry());

		return s;
	} //toString

//===================================================================
} // MobilePhone