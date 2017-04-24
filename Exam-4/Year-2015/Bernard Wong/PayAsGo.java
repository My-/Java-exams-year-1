// PayAsGo super class - Bernard Wong

public class PayAsGo extends MobilePhone
{

//===  M e m b e r   V a r i a b l e s   ============================
	private double creditBalance;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public PayAsGo(){
		super();
		setCreditBalance(0.0);
	}

	public PayAsGo(int number, String name, String provider, boolean is4G,
						int id, String countryName,
						double balance){
		super(number, name, provider, is4G , id, countryName);
		setCreditBalance(balance);
	}

	//=== Accessor and Mutator=======================================
	public void setCreditBalance(double balance){
		creditBalance = balance;
	} //setCreditBalance

	public void setCreditBalance(int balance){
		creditBalance += balance;
	} //setCreditBalance ( overload )

	public double getCreditBalance(){
		return creditBalance;
	} //getCreditBalance

	//=== Other Methods==============================================
	public String toString(){
		return super.toString() + "Cred: " + getCreditBalance();
	} //toString

//===================================================================
} // PayAsGo