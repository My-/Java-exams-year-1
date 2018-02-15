// TrikeBike sub class inherits Bike super class - Bernard Wong

public class TrikeBike extends Bike
{
//===  M e m b e r   V a r i a b l e s   ============================
	private static final int DEFAULT_WHEEL = 70;
	private int trikeWheelSize;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public TrikeBike(){
		super();
		setTrikeWheelSize(DEFAULT_WHEEL);
	}

	public TrikeBike(int id, String manufacturer, String model, double price,
					int wheelsize){
		super(id, manufacturer, model, price);
		setTrikeWheelSize(wheelsize);
	}

	//=== Accessor and Mutator=======================================
	public void setTrikeWheelSize(int wheelsize){
		trikeWheelSize = wheelsize;
	} //setTrikeWheelSize

	public int getTrikeWheelSize(){
		return trikeWheelSize;
	} //getTrikeWheelSize

	//=== Other Methods==============================================
	public String toString(){
		return super.toString() + " Wheel: " + getTrikeWheelSize();
	} //toString

//===================================================================
} // TrikeBike