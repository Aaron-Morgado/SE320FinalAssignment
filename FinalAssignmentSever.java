import java.net.*;
import java.io.*;

public class FinalAssignmentSever {
    
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

    //
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

    //starts server and performs communication with client
    public static void startServer(){

        try {
            ServerSocket ss = new ServerSocket(4999);
            Socket s = ss.accept();

            System.out.println("Client connected");
            int  weight = Integer.parseInt(getWeight(s));
            double height = Double.parseDouble(getHeight(s));
            double bmi = weight / (height * height);
            sendBMI(s, bmi);
           
        }
        catch (Exception e){
            System.out.println("error");
        }

    }
    
    public static void main(String[] args){

        startServer();

    }

}
