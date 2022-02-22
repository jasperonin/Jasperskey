package MainPackage;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Server {
    
        
        Server()
        {
            String info[] = new String[2];
            ServerSocket server = null;
            Socket client;
            InetAddress addr;
            
            try{
                addr=InetAddress.getLocalHost(); 
                server = new ServerSocket(8080);
                info[0]=addr.toString();
            }
            catch(IOException ie){
                System.out.println("Cannot Open Socket");
                System.exit(1);
            }
            new ServerWindowThread().start();
            info[1]=Integer.toString(server.getLocalPort());
            ServerWindow.getWelcomeMessage(info);
     
        }
}



        


class ServerWindowThread extends Thread
{
    public void run()
    {
        ServerWindow sw = new ServerWindow();
    }
}
