// EmployerPay super class - Bernard Wong

public class EmployerPay extends MobilePhone
{

//===  M e m b e r   V a r i a b l e s   ============================
	private int employerId;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public EmployerPay(){
		super();
		setEmployerId(0);
	}

	public EmployerPay(int number, String name, String provider, boolean is4G,
						int id, String countryName,
						int empId){
		super(number, name, provider, is4G , id, countryName);
		setEmployerId(empId);
	}

	//=== Accessor and Mutator=======================================
	public void setEmployerId(int empId){
		employerId = empId;
	} //setEmployerId

	public int getEmployerId(){
		return employerId;
	} //getEmployerId

	//=== Other Methods==============================================
	public String toString(){
		return super.toString() + " Emp: " + getEmployerId();
	} //toString

//===================================================================
} // EmployerPay