// AirTaxi - Marcus Walsh

public class AirTaxi extends Helicopter{
    // Member Variables
    public int maxPassengers;

//===================================================================
    // Constructors
//===================================================================
    public AirTaxi()
    {
		super();
		setAirTaxi(0);
    }
//===================================================================
    public AirTaxi(int id, String makeModel, boolean allWeather, double range, int pilotId, String pilotName, int pilotHours, int maxPass)
	{
		super.setHelicopter(id, makeModel, allWeather, range);
		super.setPilot(pilotId, pilotName, pilotHours);
		setAirTaxi(maxPass);
	}
//===================================================================
    public void setAirTaxi(int maxPass)
    {
        setMaxPassengers(maxPass);
    }
//===================================================================
    // Setters and getters
//===================================================================
    public void setMaxPassengers(int m)
    {
        maxPassengers = m;
    }
//===================================================================
    public int getMaxPassengers()
    {
        return maxPassengers;
    }
//===================================================================
    public String toString()
    {
		return super.toString() + " Pass: " + getMaxPassengers();
	}
//===================================================================
} // AirTaxi
