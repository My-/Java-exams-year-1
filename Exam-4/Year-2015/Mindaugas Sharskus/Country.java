// Mndaugas Sharskus
// 20/04/2017

public class Country{
    // Fields
    private int countryId;
    private String countryName;

    // Constructors
    public Country(int id, String name){
        setCountry(id, name);
    }
    public Country(){
        this(0, "noCountry");
    }

    // Seters & Getters
    public void setCountry(int id, String name){
        setCountryId(id);
        setCountryName(name);
    }

    public void setCountryId(int id){
        countryId = id;
    }
    public int getCountryId(){
        return countryId;
    }

    public void setCountryName(String name){
        countryName = name;
    }
    public String getCountryName(){
        return countryName;
    }

    @Override
    public String toString(){
        return String.format("%3d %-10s", getCountryId(), getCountryName());
    }
}
