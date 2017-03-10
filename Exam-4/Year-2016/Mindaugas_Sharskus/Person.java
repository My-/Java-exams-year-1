// Mindaugas Sharskus

public class Person{

  //  Fields
  private String firstName;
  private String lastName;
  private int dob;  //yymmdd

  //  Constructors
  /**
  * Constructor to create Person object
  *
  * @param firstName - Person first name.
  * @param lastName - Person last name.
  * @param dob - Persons date of birth (yymmdd)
  */
  public Person(String firstName, String lastName, int dob){
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
  }

  /**
  * Default constructor to create Person object
  * This constructor creates object:
  *     firstName = ""
  *     lastName = ""
  *     dob = 0
  */
  public Person(){
    this("noName", "noSurname", 999999);
  }

  //  Setters
    public void setPerson(String firstName, String lastName, int dob){
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public void setDateOfBirth(int yymmdd){
    this.dob = yymmdd;
  }

  //  Getters
  public String getFirstName(){
    return this.firstName;
  }

  public String getLastName(){
    return this.lastName;
  }

  public int getDateOfBirth(){
    return this.dob;
  }

  // Other
  @Override
  public String toString(){
    return "Person: "+ this.firstName +" "+ this.lastName +" "+ this.dob;
  }
}
