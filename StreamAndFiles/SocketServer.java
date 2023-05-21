package StreamAndFiles;

import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;

//Network Server Program
public class SocketServer 
{
    public static void main(String[] args) 
    {
        String s;
        Scanner inputStream = null;
        PrintWriter outputStream = null;
        ServerSocket serverSocket = null;

        try
        {
            //Wait for connection on port 6789
            System.out.println("Waiting for connection.");
            serverSocket = new ServerSocket(6789);
            Socket socket = serverSocket.accept();

            //connection made; setup streams
            inputStream = new Scanner(new InputStreamReader(socket.getInputStream()));
            outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream()));

            //read a line from the client
            s = inputStream.nextLine();

            //output text to the client
            outputStream.println("Well, " + s + " is fine programming language!");
            outputStream.flush();
            System.out.println("Closing connection from " + s);
            
            inputStream.close();
            outputStream.close();

        }
        catch(Exception e)
        {
            //If any error occurs, display it
            System.out.println("Error " + e);
        }

    }
}
