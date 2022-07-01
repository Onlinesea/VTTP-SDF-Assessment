package myApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Client 
{
    public static void main( String[] args ) throws StreamCorruptedException
    {
       try {
            //Connecting to the server on port 80 with the IP address of "68.183.239.26"
            Socket sock = new Socket("68.183.239.26", 80);
            System.out.println("Connected....");

            OutputStream os = sock.getOutputStream(); 
            ObjectOutputStream oos = new ObjectOutputStream(os);
            InputStream is = sock.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            //Read the input from the socket
            String input = ois.readUTF();

            //Split the inputs 
            String[] inputs = input.split(" ", 2);
            String requestId = inputs[0];
            String[] numberListStrings = inputs[1].split(",");
            int[] numberArr = new int[numberListStrings.length];
            int sum = 0;

            //Add up all the numbers within the List
            for(int i = 0; i<numberArr.length;i++){
                numberArr[i]=Integer.parseInt(numberListStrings[i]);
                sum += numberArr[i]; 
            }
            
            //Perform the operation 
            float answer = sum/(float)numberArr.length;

            String name = "Chen Xinhai";
            String validEmail = "chenxinhai10@gmail.com";

            //Write all the information and send over
            oos.writeUTF(requestId);
            oos.writeUTF(name);
            oos.writeUTF(validEmail);
            oos.writeFloat(answer);
            oos.flush();

            //Receive the result from the server

            boolean result = ois.readBoolean();
            if (result){
                System.out.println("Successful");
            }else{
                String error = ois.readUTF();
                System.out.println("Failed " + error);

            }

            //Close all the InputStreams and socket 
            ois.close(); 
            is.close();
            oos.close();
            os.close(); 
        
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
