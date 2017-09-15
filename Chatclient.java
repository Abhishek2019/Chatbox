/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc 20
 */
public class Chatclient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        
        try {
            Socket s=new Socket("localhost",9000);
            
             while(true)
             {
           
                  String str=sc.nextLine();
            
            DataOutputStream output=new DataOutputStream(s.getOutputStream());
            output.writeUTF(str);
            
            DataInputStream input=new DataInputStream(s.getInputStream());
            System.out.println(""+input.readUTF());
            
            
            
             }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Chatclient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
