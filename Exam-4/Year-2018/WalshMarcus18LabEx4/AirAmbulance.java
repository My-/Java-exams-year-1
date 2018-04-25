// AirAmbulance - Marcus Walsh

public class AirAmbulance extends Helicopter
{
//===================================================================
    public AirAmbulance()
    {
        super();
    }
//===================================================================
    public AirAmbulance(int id, String makeModel, boolean allWeather, double range, int pilotId, String pilotName, int pilotHours)
    {
        super(id, makeModel, allWeather, range, pilotId, pilotName, pilotHours);
    }
//===================================================================
    public String toString()
    {
        return super.toString();
    }
//===================================================================
} // AirAmbulance
