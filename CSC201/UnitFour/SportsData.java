package CSC201.UnitFour;
//Part of Problem#1
public class SportsData 
{
    public static void main(String[] args) 
    {
        Baseball sport1 = new Baseball("Baseball", 8200000, "MLB", "1876, Cincinnati, OH");
        Basketball sport2 = new Basketball("Basketball", 65300000, "NBA", "June 6, 1946, New York, NY");

        sport1.statistics();
        System.out.println();
        sport2.statistics();
    }    
}
