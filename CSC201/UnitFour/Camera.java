package CSC201.UnitFour;

public class Camera extends Electronics
{
    private double maxRes;
    private String sensor;
    private String viewfinder;
    
    public Camera()
    {
        this("N/A", 0, "manufacturer", 0, 0, "N/a", "N/A");
    }
    public Camera(String model, double weight, String manufacturer, double cost, double maxRes, String sensor, String viewfinder)
    {
        super(model, weight, manufacturer, cost);
        this.maxRes = maxRes;
        this.sensor = sensor;
        this.viewfinder = viewfinder;
    }

    public double getMaxRes()
    {
        return maxRes;
    }
    public String getSensor()
    {
        return sensor;
    }
    public String getViewfinder()
    {
        return viewfinder;
    }

    public void setMaxRes(double maxRes)
    {
        this.maxRes = maxRes;
    }
    public void setSensor(String sensor)
    {
        this.sensor = sensor;
    }
    public void setViewfinder(String viewfinder)
    {
        this.viewfinder = viewfinder;
    }

    public void CameraDetails()
    {
        description();
        System.out.println("Max Resolution: " + getMaxRes() + " Megapixel");
        System.out.println("Sensor type: " + getSensor());
        System.out.println("Viewfinder: " + getViewfinder());
    }
}
