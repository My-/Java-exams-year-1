// Bike super class - Bernard Wong

public class Bike
{
//===  M e m b e r   V a r i a b l e s   ============================
	private int bikeId;
	private String bikeManufacturer;
	private String bikeModel;
	private double bikePrice;

//===  M e m b e r   M e t h o d s  =================================
	//=== Constructors===============================================
	public Bike(){
		setBike(0, "noManu", "noModel", 0.00);
	} // default

	public Bike(int id, String manufacturer, String model, double price){
		setBike(id, manufacturer, model, price);
	} // all parameter

	public Bike(int id, double price){
		setBike(id, "noManu", "noModel", price);
	} // semi parameter

	public Bike(Bike bike){
		setBike(bike.getBikeId(), bike.getBikeManufacturer(), bike.getBikeModel(), bike.getBikePrice());
	} // copy constructor

	//=== Accessor and Mutator=======================================
	public void setBike(int id, String manufacturer, String model, double price){
		setBikeId(id);
		setBikeManufacturer(manufacturer);
		setBikeModel(model);
		setBikePrice(price);
	} //setCountry

	//===============================================================
	public void setBikeId(int id){
		bikeId = id;
	} //setBikeId

	public int getBikeId(){
		return bikeId;
	} //getBikeId

	//===============================================================
	public void setBikeManufacturer(String manufacturer){
		bikeManufacturer = manufacturer;
	} //setBikeManufacturer

	public String getBikeManufacturer(){
		return bikeManufacturer;
	} //getBikeManufacturer

	//===============================================================
	public void setBikeModel(String model){
		bikeModel = model;
	} //setBikeModel

	public void setBikeModel(){
		bikeModel = "#new#";
	} //setBikeModel (overload)

	public String getBikeModel(){
		return bikeModel;
	} //getBikeModel

	//===============================================================
	public void setBikePrice(double price){
		bikePrice = price;
	} //setBikePrice

	public double getBikePrice(){
		return bikePrice;
	} //getBikePrice

	//=== Other Methods==============================================
	public String toString(){
		String s;

		s = String.format("%4d %-8s %-8s %6.2f", getBikeId(), getBikeManufacturer(), getBikeModel() , getBikePrice());

		return s;
	} //toString

//===================================================================
} // Bike