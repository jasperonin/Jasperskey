package MainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import javax.swing.JTextArea;

/**
 *
 * @author JasperOnin
 */

public class Utilities {

    /** Execute line command and get back its result */
    public static void executeCmd(JTextArea textarea, String cmd)
    {
        String line="";
        try 
        {    
            Process command = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader
                (command.getInputStream()));
            while ((line = in.readLine()) != null)
                    textarea.append("\n" + line);   
            in.close();                
        }      
            catch (IOException ioEx) {} 
    }
 public static void executeNetSh() throws InterruptedException
         
    {
        String name ="block_me";
        try 
            { 
                Process p=Runtime.getRuntime().exec("cmd /c netsh advfirewall firewall add rule dir= in protocol=TCP localport=135 name = name action=block"); 
                p.waitFor(); 
                BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
                String line=reader.readLine();
                Process p2=Runtime.getRuntime().exec("cmd /c wf.msc"); 
                p2.waitFor(); 
                BufferedReader reader2; 
            reader2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                String line2=reader2.readLine();
    while(line!=null && line2!=null) 
        { 
            System.out.println(line);
            System.out.println(line2);
            line=reader.readLine(); 
            line2=reader.readLine();
        } 

       } 
catch(IOException e1) {} 
    }    
       
   
    public static void ExecuteProcess (String process)
    {
        try 
        {          
            Process p = Runtime.getRuntime().exec(process);
            p.waitFor();
        }      
            catch (Exception Ex) {}             
    }    
    
    
    /** Convert string to integer*/
    public static int StrToInt(String str){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());            
            return -1;
        }
    }      
    
    public static boolean ValidMachine(String machine)
    {        
        return Pattern.matches("/*(\\w|\\.)+:\\d+", machine);
    }
}
