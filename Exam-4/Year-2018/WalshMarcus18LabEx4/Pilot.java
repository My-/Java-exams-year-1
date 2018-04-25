// Pilot - Marcus Walsh

public class Pilot {
    // Member Variables
    private int pilotId;
    private String pilotName;
    private int pilotHours;

//===================================================================
    // Constructors
//===================================================================
    public Pilot()
    {
        setPilot(0, "noPilot", 0);
    }
//===================================================================
    public Pilot(int id, String name, int hours)
    {
        setPilot(id, name, hours);
    }
//===================================================================
    public void setPilot(int id, String name, int hours)
    {
        setPilotId(id);
        setPilotName(name);
        setPilotHours(hours);
    }
//===================================================================
    // Setters and getters
//===================================================================
    public void setPilotId(int p)
    {
        pilotId = p;
    }
//===================================================================
    public int getPilotId()
    {
        return pilotId;
    }
//===================================================================
    public void setPilotName(String p)
    {
        pilotName = p;
    }
//===================================================================
    public String getPilotName()
    {
        return pilotName;
    }
//===================================================================
    public void setPilotHours(int p)
    {
        pilotHours = p;
    }
//===================================================================
    public int getPilotHours()
    {
        return pilotHours;
    }
//===================================================================
    public String toString()
    {
        return String.format("%3d %-8s %5d", getPilotId(), getPilotName(), getPilotHours());
    }
//===================================================================
} // Pilot
