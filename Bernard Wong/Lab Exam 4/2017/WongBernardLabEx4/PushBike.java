// PushBike sub class inherits Bike super class - Bernard Wong

public class PushBike extends Bike
{
//===  M e m b e r   V a r i a b l e s   ============================
	private String bikeDescription;
	private char bikeGender;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public PushBike(){
		super();
		setPushBike("noDesc", 'U');
	}

	public PushBike(int id, String manufacturer, String model, double price,
					String description, char gender){
		super(id, manufacturer, model, price);
		setPushBike(description, gender);
	}

	//=== Accessor and Mutator=======================================
	public void setPushBike(String description, char gender){
		setBikeDescription(description);
		setBikeGender(gender);
	} //setPushBike

	//===============================================================
	public void setBikeDescription(String description){
		bikeDescription = description;
	} //setBikeDescription

	public String getBikeDescription(){
		return bikeDescription;
	} //getBikeDescription

	//===============================================================
	public void setBikeGender(char gender){
		bikeGender = gender;
	} //setBikeGender

	public char getBikeGender(){
		return bikeGender;
	} //getBikeGender

	//=== Other Methods==============================================
	public String toString(){
		return super.toString() + " Desc: " + getBikeDescription() + " Gend: " + getBikeGender();
	} //toString
//===================================================================
} // PushBike