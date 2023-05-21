package StreamAndFiles;

import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//Network Client Program
public class SocketClient 
{
    public static void main(String[] args) 
    {
        String s;
        Scanner inputStream = null;
        PrintWriter outputStream = null;
        
        try
        {
            //Connecting to server on same machine, port 6789 (refer t0 "SocketServer.java")
            Socket clientSocket = new Socket("localhost", 6789); //we use "localhost" as the name of the machine; since we are using one computer
            
            //Setup streams to send/recieve data
            inputStream = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
            outputStream = new PrintWriter(new DataOutputStream(clientSocket.getOutputStream()));

            //Send "Java" to the Server
            outputStream.println("Java");
            outputStream.flush();//we should flush stream if we want data to be sent

            //Read everything from the server until no more lines and output it to the screen
            while(inputStream.hasNextLine())
            {
                s = inputStream.nextLine();
                System.out.println(s);
            }

            //closing stream
            inputStream.close();
            outputStream.close();
        }
        catch(Exception e)
        {
            //If any exception occurs, display it
            System.out.println("Error " + e);
        }
    }
}
