
public class MobilePhone{
    // Fields
    private int mobileNumber;
    private String mobileName;
    private String mobileProvider;
    private boolean mobile4G;
    private Country country;

    // Constructors
    public MobilePhone(int mobileNumber, String mobileName, String mobileProvider, boolean mobile4G, Country country){
        setMobilePhone(mobileNumber, mobileName, mobileProvider, mobile4G, country);
    }
    public MobilePhone(){
        this(0, "nomobileName", "nomobileProvider", false, new Country());

}

    // Setters & Getters

    // Full parameter setter
    public void setMobilePhone(int mobileNumber, String mobileName, String mobileProvider, boolean mobile4G, Country country){
        setMobileNumber(mobileNumber);
        setMobileName(mobileName);
        setMobileProvider(mobileProvider);
        setMobile4G(mobile4G);
        setCountry(country);
    }

    // Setters & Getters
    public void setMobileNumber(int mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    public int getMobileNumber(){
        return mobileNumber;
    }

    public void setMobileName(String mobileName){
        this.mobileName = mobileName;
    }
    public String getMobileName(){
        return mobileName;
    }

    public void setMobileProvider(String mobileProvider){
        this.mobileProvider = mobileProvider;
    }
    public String getMobileProvider(){
        return mobileProvider;
    }

    public void setMobile4G(boolean mobile4G){
        this.mobile4G = mobile4G;
    }
    public boolean getMobile4G(){
        return mobile4G;
    }

    public void setCountry(Country country){
        this.country = country;
    }
    public Country getCountry(){
        return country;
    }

    @Override
    public String toString(){
        return "MobilePhone: "+ getMobileNumber() +" "+ getMobileName() +" "+ getMobileProvider() +" "+ getMobile4G() +" "+ getCountry();
    }
}
