package CSC201.UnitFour;
//Part of Problem#1
public class Basketball extends Sport 
{
    private int popularity;
    private String league;
    private String founded;

    public Basketball()
    {
        this("Unknown", 0 , "N/A", "Unknown");
    }

    public Basketball(String name, int popularity, String league, String founded)
    {
        super(name);
        this.popularity = popularity;
        this.league = league;
        this.founded = founded;
    }

    public String getFounded()
    {
        return founded;
    }
    public int getPopularity()
    {
        return popularity;
    }
    public String getLeague()
    {
        return league;
    }
    
    public void setFounded(String founded)
    {
        this.founded = founded;
    }
    public void setPopularity(int popularity)
    {
        this.popularity = popularity;
    }
    public void setLeague(String league)
    {
        this.league = league;
    }

    public void statistics()
    {
        super.statistics();
        System.out.println("Founded: " + getFounded());
        System.out.println("Popularity: " + getPopularity() + " followers");
        System.out.println("League: " + getLeague());
    }
}
