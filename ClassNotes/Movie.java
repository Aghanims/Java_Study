package ClassNotes;
public class Movie 
{  
    private String movieName;
    private String MPAArating;
    private int terribleRating, badRating, OKRating, goodRating, greatRating;

    //Acceccors 
    public String getMovieName()
    {
        return movieName;
    }

    public String getMPAArating()
    {
        return MPAArating;
    }

    //Mutators
    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }

    public void setMPAArating(String MPAArating)
    {
        this.MPAArating = MPAArating;
    }

    public void addRating(int scaleFromOneToFive)
    {
        if(scaleFromOneToFive == 1)
        {
            terribleRating = terribleRating + 1;
        }
        else if(scaleFromOneToFive == 2)
        {
            badRating = badRating + 1;
        }
        else if(scaleFromOneToFive == 3)
        {
            OKRating = OKRating + 1;
        }
        else if(scaleFromOneToFive == 4)
        {
            goodRating = goodRating + 1;
        }
        else if(scaleFromOneToFive == 5)
        {
            greatRating = greatRating + 1;
        }
        else
        {
             System.out.println("You entered \"" + scaleFromOneToFive + "\", Number should not exceed numbers from 1 - 5" );    
        }
    }

    public void getMovieRatings()
    {
        System.out.println("Terrible: " + terribleRating);
        System.out.println("Bad: " + badRating);
        System.out.println("OK: " + OKRating);
        System.out.println("Good: " + goodRating);
        System.out.println("Great: " + greatRating);
    }

    public void getMovieInformation()
    {
        System.out.println("Movie Title: " + movieName);
        System.out.println("MPAA rating: " + MPAArating);
    }
}

