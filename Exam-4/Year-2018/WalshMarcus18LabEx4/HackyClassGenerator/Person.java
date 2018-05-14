
public class Person {
    // Member Variables
    public String firstName;
    public String lastName;
    public int dateOfBirth;

    // Constructors
    
    public Person()
    {
    }

    public Person(String firstName, String lastName, int dateOfBirth)
    {
    }

    public void setPerson(String firstName, String lastName, int dateOfBirth)
    {
        setFirstName("setFirstName");
        setLastName("setLastName");
        setDateOfBirth("setDateOfBirth");
    }
    
    // Setters and getters
    
    public void setFirstName(String f)
    {
        firstName = f;
    }

    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String l)
    {
        lastName = l;
    }

    public String getLastName()
    {
        return lastName;
    }
    
    public void setDateOfBirth(int d)
    {
        dateOfBirth = d;
    }

    public int getDateOfBirth()
    {
        return dateOfBirth;
    }

}
