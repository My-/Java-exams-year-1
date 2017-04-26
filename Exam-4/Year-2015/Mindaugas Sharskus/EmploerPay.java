
public class EmploerPay extends MobilePhone{
    // Fields
    private int emploerId;

    // Constructors
    public EmploerPay(int mobileNumber, String mobileName, String mobileProvider, boolean mobile4G, Country country,
            int emploerId){
        super(mobileNumber, mobileName, mobileProvider, mobile4G, country);
        setEmploerPay(emploerId);
    }
    public EmploerPay(){
        super();
        setEmploerPay(0);

}

    // Setters & Getters

    // Full parameter setter
    public void setEmploerPay(int emploerId){
        setEmploerId(emploerId);
    }

    // Setters & Getters
    public void setEmploerId(int emploerId){
        this.emploerId = emploerId;
    }
    public int getEmploerId(){
        return emploerId;
    }

    @Override
    public String toString(){
        return "EmploerPay: "+ getEmploerId();
    }
}
