import java.net.*;
import java.io.*;

public class FinalAssignmentClient {
    
    //sends weight to server
    public static void sendHeight(Socket s, String height){
        try{
        PrintWriter data = new PrintWriter(s.getOutputStream());
        data.println(height);
        data.flush();
        }
        catch(Exception e){
            System.out.println("Could not send height");
        }

    }

    // weight in kg and height in meters
    //sends weight to server
    public static void sendWeight(Socket s, String weight){

        try {
            PrintWriter data = new PrintWriter(s.getOutputStream());
            data.println(weight);
            data.flush();
        }
        catch(Exception e){
            System.out.println("could not send weight");
        }

    }

    // gets the bmi from the server
    public static String getBMI(Socket s){
        try{
        InputStreamReader data = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(data);

        String bmi = br.readLine();
        System.out.print("BMI: " + bmi);
        }
        catch(Exception e){
            System.out.println("Could not read weight");

        }
        return bmi; 
    }
    
    public static void startClient(){
        try{ 

            Socket s = new Socket("localhost", 4999);
            sendWeight(s, "70");
            sendHeight(s, "1.8");
            getBMI(s);
            
        }
        catch(Exception e){
            System.out.println("Connection failed");
        }

    }
    
    public static void main(String[] args){

        startClient();

    }

}
