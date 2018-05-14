// Helicopter - Marcus Walsh

public class Helicopter {
    // Member Variables
    private int helicopterId;
    private String heliMakeModel;
    private boolean heliAllWeather;
    private double heliRange;
    private Pilot pilot;

//===================================================================
    // Constructors
//===================================================================
    public Helicopter()
    {
        setHelicopter(0, "noMakeModel", false, 0.00);
        pilot = new Pilot();
    }
//===================================================================
    public Helicopter(int id, String makeModel, boolean allWeather, double range)
    {
        setHelicopter(id, makeModel, allWeather, range);
        pilot = new Pilot();
    }
//===================================================================
    public Helicopter(int id, String makeModel, boolean allWeather, double range, int pilotId, String pilotName, int pilotHours)
    {
        setHelicopter(id, makeModel, allWeather, range);
        pilot = new Pilot(pilotId, pilotName, pilotHours);
    }
//===================================================================
    public void setHelicopter(int id, String makeModel, boolean allWeather, double range)
    {
        setHelicopterId(id);
        setHeliMakeModel(makeModel);
        setHeliAllWeather(allWeather);
        setHeliRange(range);
    }
//===================================================================
    // Setters and getters
//===================================================================
    public void setHelicopterId(int h)
    {
        helicopterId = h;
    }
//===================================================================
    public int getHelicopterId()
    {
        return helicopterId;
    }
//===================================================================
    public void setHeliMakeModel(String h)
    {
        heliMakeModel = h;
    }
//===================================================================
    public String getHeliMakeModel()
    {
        return heliMakeModel;
    }
//===================================================================
    public void setHeliAllWeather(boolean h)
    {
        heliAllWeather = h;
    }
//===================================================================
    public boolean getHeliAllWeather()
    {
        return heliAllWeather;
    }
//===================================================================
    public void setHeliRange(double h)
    {
        heliRange = h;
    }
//===================================================================
    public void setHeliRange(int h)
    {
        double newRange = getHeliRange() + (getHeliRange()* (h/100.0));
        setHeliRange(newRange);
    }
//===================================================================
    public double getHeliRange()
    {
        return heliRange;
    }
//===================================================================
    public void setPilot(int id, String name, int hours)
    {
        pilot.setPilot(id, name, hours);
    }
//===================================================================
    public String getPilot()
    {
        return pilot.toString();
    }
//===================================================================
    public Pilot getPilot(int i)
    {
        return pilot;
    }
//===================================================================
    public String toString()
    {
        char aw;
        if (getHeliAllWeather())
        {
            aw = 'T';
        }
        else
        {
            aw = 'F';
        }
        return String.format("%4d %11s %2s %9.2f  %s", getHelicopterId(), getHeliMakeModel(), aw, getHeliRange(), pilot.toString());
    }
//===================================================================
} // Helicopter
