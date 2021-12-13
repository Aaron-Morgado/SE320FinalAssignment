import java.net.*;
import java.io.*;
import java.util.*;

public class FinalAssignmentSever {
    

    //opens server for listening and hands clients to threads to be handled
    public static void startServer(){

        try {
            ServerSocket ss = new ServerSocket(4999);
            ss.setReuseAddress(true);

            while(true){

                Socket client = ss.accept();
                System.out.println("Client connected");
                //creates thread
                ClientHandler clientStock = new ClientHandler(client);
                //starts thread
                new Thread(clientStock).start();
              

            }
           
        }
        catch (Exception e){
            System.out.println("error");
        }

    }
    
    public static void main(String[] args){

        startServer();

    }

}
private static class ClientHandler implements Runnable {
    private final Socket clientSocket;

    // Constructor
    public ClientHandler(Socket socket)
    {
        this.clientSocket = socket;
    }

    //gets the weight from the client
    public static String getWeight(Socket s){
        try{
        InputStreamReader data = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(data);

        String weight = br.readLine();
        System.out.print("weight: " + weight);
        }
        catch(Exception e){
            System.out.println("Could not read weight");

        }
        return weight; 
    }

    //gets the height from the client
    public static String getHeight(Socket s){
        try{
            InputStreamReader data = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(data);
    
            String height = br.readLine();
            System.out.print("height: " + height);
            }
            catch(Exception e){
                System.out.println("Could not read weight");
    
            }

            return height;

    }

    //sends bmi to client
    public static void sendBMI(Socket s, Double bmi){

        String newBMI = bmi.toString();

        try{
            PrintWriter data = new PrintWriter(s.getOutputStream());
            data.println(newBMI);
            data.flush();
            }
            catch(Exception e){
                System.out.println("Could not send bmi");
            }

    }

    public void run()
    {
        try {
                
            int  weight = Integer.parseInt(getWeight(clientSocket));
            double height = Double.parseDouble(getHeight(clientSocket));
            double bmi = weight / (height * height);
            sendBMI(clientSocket, bmi);
          
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

