package CSC201.Project;

public class Food extends Product
{
    private String expirationDate;
    private float calories;
    private String servingSize;

    public Food()
    {
        this("N/A", 0,"N/A", 0, "N/A");
    }

    public Food(String name, int price, String expirationDate, float calories, String servingSize)
    {   
        super(name, price);
        this.expirationDate = expirationDate;
        this.calories = calories;
        this.servingSize = servingSize;
    }

    public String getExpirationDate()
    {
        return expirationDate;
    }

    public float getCalories()
    {
        return calories;
    }

    public String getServingSize()
    {
        return servingSize;
    }

    public void setExpirationDate(String newExpirationDate)
    {
        expirationDate = newExpirationDate;
    }

    public void setCalories(float newCalories)
    {
        calories = newCalories;
    }

    public void setServingSize(String newServingSize)
    {
        servingSize = newServingSize;
    }

    public String toString()
    {
        return super.toString() + "\n" +
                "Expiration Date: " + getExpirationDate() + "\n" +
                "Calories: " + getCalories() + "\n" +
                "Serving Size: " + getServingSize();    
    }

}
