
public class AirCargo extends Helicopter {
    // Member Variables
    public static final double DEFAULT_CAPACITY = 3.3;
    public static final int DEFAULT_WEIGHT = 101;
    public double maxCapacity;
    public int maxWeight;

//===================================================================
    // Constructors
//===================================================================
    public AirCargo()
    {
		super();
		setAirCargo(DEFAULT_CAPACITY, DEFAULT_WEIGHT);
    }
//===================================================================
    public AirCargo(int id, String makeModel, boolean allWeather, double range, int pilotId, String pilotName, int pilotHours, double capacity, int weight)
	{
		super(id, makeModel, allWeather, range, pilotId, pilotName, pilotHours);
		setAirCargo(capacity, weight);
	}
//===================================================================
    public void setAirCargo(double capacity, int weight)
    {
        setMaxCapacity(capacity);
        setMaxWeight(weight);
    }
//===================================================================
    // Setters and getters
//===================================================================
    public void setMaxCapacity(double m)
    {
        maxCapacity = m;
    }
//===================================================================
    public double getMaxCapacity()
    {
        return maxCapacity;
    }
//===================================================================
    public void setMaxWeight(int m)
    {
        maxWeight = m;
    }
//===================================================================
    public int getMaxWeight()
    {
        return maxWeight;
    }
//===================================================================
    public String toString()
    {
		return super.toString() + String.format(" Cap: %.2f  Wght: %d", getMaxCapacity(), getMaxWeight());
	}
//===================================================================
	public AirCargo exportAirCargo()
	{
		Pilot p1 = getPilot(1);
		AirCargo a1 = new AirCargo(super.getHelicopterId(), super.getHeliMakeModel(), super.getHeliAllWeather(), super.getHeliRange(), p1.getPilotId(), p1.getPilotName(), p1.getPilotHours(), getMaxCapacity(),  getMaxWeight());
		return a1;
	}
//===================================================================
} // AirCargo