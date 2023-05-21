package CSC201.UnitFour;

public class ElectronicsDriver 
{
    public static void main(String[] args) 
    {
        Computer Predator = new Computer("PH315-54-760S", 5.07, "Acer", 1279.99, 512, "Windows", 16);
        Camera Sony = new Camera("a7III", 1.95, "Sony", 2198, 25.3, "Full-frame", "Mirrorless");
        Speaker JBL = new Speaker("JBL CLIP 3", 0.60, "JBL", 39.95, "Bluetooth", 10, "Stereo");

        Predator.ComputerDetails();
        System.out.println();
        Sony.CameraDetails();
        System.out.println();
        JBL.SpeakerDetails();

    }
}
