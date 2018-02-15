// Person - Bernard Wong

public class Person
{
//===  M e m b e r   V a r i a b l e s   ============================
	private String firstName;
	private String lastName;
	private int dateOfBirth;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public Person(){
		setPerson("noFirst", "noLast");
	}

	public Person(String first, String last){
		setPerson(first, last);
	}

	//=== Accessor and Mutator=======================================
	public void setPerson(String first, String last){
		setFirstName(first);
		setLastName(last);
	} //setPerson

	//===============================================================
	public void setFirstName(String first){
		firstName = first;
	} //setFirstName

	public String getFirstName(){
		return firstName;
	} //getFirstName

	//===============================================================
	public void setLastName(String last){
		lastName = last;
	} //setLastName

	public String getLastName(){
		return lastName;
	} //getLastName

	//===============================================================
	public void setDateOfBirth(int dob){
		dateOfBirth = dob;
	} //setDateOfBirth

	public int getDateOfBirth(){
		return dateOfBirth;
	} //getDateOfBirth

	//=== Other Methods==============================================
	public String toString(){
		return getFirstName() + " " + getLastName();
	} //toString

//===================================================================
} // Person