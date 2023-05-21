package CSC201.UnitFour;

public class BooksData 
{
    public static void main(String[] args) 
    {
        Novel book1 = new Novel("Fantasy", "Arthur Leywin", "TurtleMe", "Beginning After the End", 260);
        Textbook book2 = new Textbook("CSC201", 8, "Pearson", 1016, "JAVA An Introduction to Problem Solving & Programming", "Walter Savitch");
        Magazine book3 = new Magazine(22, "Critics Choice Awards 2022", "Annika Lautens", "Fashion", "03/14/2022", "NOT All Runaway Gowns are Meant for the Red Carpet", "Fashion Magazine");

        book1.Magazinedescription();
        System.out.println();
        book2.TextbookDescription();
        System.out.println();
        book3.MagazineDescription();
    }    
}
