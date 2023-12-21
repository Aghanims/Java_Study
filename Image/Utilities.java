package Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Program that reads a file for loading (setting values of all pixels on an image) from an existing file, and
 * saving (reading values of all pixel from an image and sending the values to file).
 * 
 * @author Richmond D. Gonzales
 */
public final class Utilities
{
    /**
     * Reads a PGB image from a file and creates an object Image with type short.
     * It calls the constructor of the Image to instantiate and Image object.
     * Once the data structure is established, it stores the vaue of each pixel.
     * 
     * @param pgmFile to be used for assigning values for height and width of the image, as well as values on all pixels.
     * @return an Image object of type short with the declared values on each pixels.
     */
    public static Image<Short> loadImage(String pgmFile)
    {
        Scanner inputStream = (Scanner) null;
        
        try
        {
            inputStream = new Scanner(new File(pgmFile));
        }
        catch(FileNotFoundException e) 
        {
            System.out.println("Error opening the file: " + pgmFile);
            System.exit(0);
        }
        
        //read the first line and verify the type is P2
        if(!inputStream.nextLine().equals("P2"))
            throw new RuntimeException();

        //read the second line and extract the width and the height of the image
        int width = Integer.parseInt(inputStream.next());
        int height = Integer.parseInt(inputStream.next());
        Image<Short> image = new Image<Short>(width, height);
        
        //read the third line but don't use it 
        inputStream.next();
 
        //iterate 2d doubly-linked list and assign values from the file that will represent as the pixel.
        Iterator<Node<Short>> loop = image.iterator();
        while(loop.hasNext())
            loop.next().setValue(Short.parseShort(inputStream.next()));
        
        inputStream.close();

        //return back the modified image.
        return image;
    }

    /**
     * Opens or creates a textfile that prints details about the image in a [ProjectName, height width, range, all pixel values] format.
     * 
     * @param image reference to be extracted of details.
     * @param pgmFile textfile to be opend or created which is where the details will be printed.
     */
    public static void saveImage(Image<Short> image, String pgmFile)
    {
        PrintWriter outputStream = null;

        try 
        {
            outputStream = new PrintWriter(pgmFile);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file: " + pgmFile);
            System.exit(0);
        }

        //Write P2 which is the type of the image.
        outputStream.println("P2");

        //Write the width and the height of the image separated by a single space.
        outputStream.println(image.getWidth() + " " + image.getHeight());

        //write 255
        outputStream.println("255");

        //Run an enhanced-for loop to get all the nodes from the image object and write their pixel value to the file
        for(Node<Short> pixel : image)
            outputStream.print(pixel.getValue() + " ");
        
        //don't forget to close the file.
        outputStream.close();
    }

    /**
     * For testing image if it is succesfully loaded and saved.
     * 
     * @param args for accepting arguments on command line; currently not used.
     */
    public static void main(String[] args) 
    {
        Image<Short> image = loadImage("test_image.pgm");

        //loadImage("test_image.pgm");
        saveImage(image, "random.pgm");
    }
}
