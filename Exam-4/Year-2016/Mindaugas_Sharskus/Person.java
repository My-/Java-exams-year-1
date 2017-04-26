// Mindaugas Sharskus

public class Person{

  //  Fields
  private String firstName;
  private String lastName;
  private int dateOfBirth;  //yymmdd

  //  Constructors
  public Person(String firstName, String lastName, int dateOfBirth){
    setPerson(firstName, lastName, dateOfBirth);
  }
  public Person(String firstName, String lastName){
    setPerson(firstName, lastName, 999999);
  }

  public Person(){
    setPerson("noName", "noSurname", 999999); // Gerry style
    //this("noName", "noSurname", 999999);
  }

  //  Setters
    public void setPerson(String firstName, String lastName, int dob){
      setFirstName(firstName);
      setLastName(lastName);
      setDateOfBirth(dob);
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public void setDateOfBirth(int dob){
    this.dateOfBirth = dob;
  }

  //  Getters
  public String getFirstName(){
    return this.firstName;
  }

  public String getLastName(){
    return this.lastName;
  }

  public int getDateOfBirth(){
    return this.dateOfBirth;
  }

  // Other
  @Override
  public String toString(){
    //return "Person: "+ this.firstName +" "+ this.lastName +" "+ this.dateOfBirth;
    String s = String.format("%-14s ", getFirstName() + " " + getLastName());
	return s;
  }
}
