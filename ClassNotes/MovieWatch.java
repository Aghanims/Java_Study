package ClassNotes;
public class MovieWatch
{
    public static void main(String[] args)
    {
        Movie MovieRental = new Movie();

        MovieRental.setMovieName("The Warriour Nun");
        MovieRental.setMPAArating("PG-13");

        MovieRental.getMovieInformation();

        MovieRental.addRating(5);
        MovieRental.addRating(5);
        MovieRental.addRating(5);
        MovieRental.addRating(4);
        MovieRental.addRating(3);
        MovieRental.addRating(3);
        MovieRental.addRating(12);

        MovieRental.getMovieRatings();

        Movie boughtMovie = new Movie();

        System.out.println();

        boughtMovie.setMovieName("The 3 Idiots");
        boughtMovie.setMPAArating("PG");

       boughtMovie.getMovieInformation();

        boughtMovie.addRating(99);
        boughtMovie.addRating(2);
        boughtMovie.addRating(1);
        boughtMovie.addRating(1);
        boughtMovie.addRating(4);
        boughtMovie.addRating(3);
        boughtMovie.addRating(3);

        boughtMovie.getMovieRatings();
        
        
    }
}