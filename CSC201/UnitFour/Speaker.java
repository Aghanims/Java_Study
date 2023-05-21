package CSC201.UnitFour;

public class Speaker extends Electronics
{
    private String connectivity;
    private float maxPlayTime;
    private String outputMode;

    public Speaker()
    {
        this("N/A", 0, "N/A", 0, "N/A", 0, "N/A");
    }
    public Speaker(String model, double weight, String manufacturer, double cost, String connectivity, float maxPlayTime, String outputmode)
    {
        super(model, weight, manufacturer, cost);
        this.connectivity = connectivity;
        this.maxPlayTime = maxPlayTime;
        this.outputMode = outputmode;
    }

    public String getConnectivity()
    {
        return connectivity;
    }
    public float getMaxPlayTime()
    {
        return maxPlayTime;
    }
    public String getOutputMode()
    {
        return outputMode;
    }
    
    public void setConnectivity(String connectivity)
    {
        this.connectivity = connectivity;
    }
    public void setMaxPlayTime(float maxPlayTime)
    {
        this.maxPlayTime = maxPlayTime;
    }
    public void setOutputMode(String outputMode)
    {
        this.outputMode = outputMode;
    }

    public void SpeakerDetails()
    {
        description();
        System.out.println("Connectivity: " + getConnectivity());
        System.out.println("Max Playtime: " + getMaxPlayTime() +  " hrs");
        System.out.println("Output mode: " + getOutputMode());
    }
}
