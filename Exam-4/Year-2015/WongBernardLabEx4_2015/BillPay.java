// BillPay super class - Bernard Wong

public class BillPay extends MobilePhone
{

//===  M e m b e r   V a r i a b l e s   ============================
	private static final double DEFAULT_MINUTES = 100.00;
	private int textsLeft;
	private double minutesLeft;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public BillPay(){
		super();
		setBillPay(0, DEFAULT_MINUTES);
	}

	public BillPay(int number, String name, String provider, boolean is4G,
						int id, String countryName,
						int text, double min){
		super(number, name, provider, is4G , id, countryName);
		setBillPay(text, min);
	}

	//=== Accessor and Mutator=======================================
	public void setBillPay(int text, double min){
		setTextsLeft(text);
		setMinutesLeft(min);
	} //setCreditBalance

	//===============================================================
	public void setTextsLeft(int text){
		textsLeft = text;
	} //setTextsLeft

	public int getTextsLeft(){
		return textsLeft;
	} //getTextsLeft

	//===============================================================
	public void setMinutesLeft(double min){
		minutesLeft = min;
	} //setMinutesLeft

	public double getMinutesLeft(){
		return minutesLeft;
	} //getMinutesLeft

	//=== Other Methods==============================================
	public String toString(){
		return super.toString() + " Txt: " + getTextsLeft() + " Min: " + getMinutesLeft();
	} //toString

//===================================================================
} // BillPay