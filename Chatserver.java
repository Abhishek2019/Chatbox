
package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc 20
 */
public class Chatserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Scanner sc=new Scanner(System.in);
        try {
            
            ServerSocket serverSocket = new ServerSocket(9000);
            Socket clientSocket = serverSocket.accept();
            
            System.out.println("Listening...");
            while(true)
            {
            DataInputStream input=new DataInputStream(clientSocket.getInputStream());
            String no=input.readUTF();
            int x=Integer.parseInt(no)*8;
            
            System.out.println(""+x);
            
            String str=""+x;
            
            DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());
            output.writeUTF(str);
            }
        } catch (IOException ex) {
            Logger.getLogger(Chatserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
