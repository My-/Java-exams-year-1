// ElectricPushBike sub cluss inherits PushBike class - Bernard Wong

public class ElectricPushBike extends PushBike
{
//===  M e m b e r   V a r i a b l e s   ============================
	private static final int DEFAULT_RANGE = 50;
	private int bikeRange;
	private Engine engine;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public ElectricPushBike(){
		super();
		setBikeRange(DEFAULT_RANGE);
		engine = new Engine();
	}

	public ElectricPushBike(int id, String manufacturer, String model, double price,
					String description, char gender,
					int range,
					char type, int monthWarranty){
		super(id, manufacturer, model, price, description, gender);
		setBikeRange(range);
		engine = new Engine(type, monthWarranty);
	}

	//=== Accessor and Mutator=======================================
	public void setBikeRange(int range){
		bikeRange = range;
	} //setBikeRange

	public void setBikeRange(double range){
		bikeRange *= (1 + range);
	} //setBikeRange ( overload )

	public int getBikeRange(){
		return bikeRange;
	} //getBikeRange

	//===============================================================
	public void setEngine(char type, int monthWarranty){
		engine.setEngine(type, monthWarranty);
	} //setEngine

	public String getEngine(){
		return engine.toString();
	} //getEngine

	//=== Other Methods==============================================
	public String toString(){
		return super.toString() + " Range: " + getBikeRange() + " Eng: " + getEngine();
	} //toString
//===================================================================
} // ElectricPushBike