package NetUtils;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MainPackage.AddObjectDialog;



public class IPAddress {
    
   
    public static boolean validIPAddress(String IPAdr) {
        StringTokenizer st = new StringTokenizer(IPAdr, ".");
        if (st.countTokens()!= 4) return false;
        while (st.hasMoreTokens()){
            try {
                int value = Integer.parseInt(st.nextToken());
                if (value < 0 || value > 255) return false;     
            } catch (NumberFormatException e) { return false;}    
        }
        return true;
    }
    

    public static ArrayList<Integer> getIPAddresses (String object)
    {
        int FirstInt = getFirstAdrHost(object);
        int LastInt = getLastAdrHost(object);
        int count = LastInt - FirstInt+1;
        ArrayList<Integer> list = new ArrayList<Integer>(count);
        for(int i=count; i>0; i--)
            list.add(i+FirstInt-1);  
        return list;
    } 
    

    public static boolean validObject(String object) {
        if (object == null) return false;
        int FirstInt, LastInt;
        String FirstIP, LastIP;        
        FirstIP = LastIP = object;
      
        int sprpos = object.indexOf("-");
        if (sprpos != -1) { 
            FirstIP = object.substring(0, sprpos);

            LastIP = object.substring(sprpos + 1);
            LastIP = getNetAdrPart(object) + LastIP;

            FirstInt = getHostAdrPart(FirstIP); 
            LastInt = getHostAdrPart(LastIP);               
        }
        else {
          
            int zerostr = getHostAdrPart(object);
            if (zerostr == 0) { // IP Adr format x.x.x.0
                FirstInt = 1;
                LastInt = 254;
            }
            else
                FirstInt = LastInt = zerostr;     
        }

  
        return (FirstInt != -1) && (LastInt != -1) && (LastInt >= FirstInt) 
            && validIPAddress(FirstIP) && validIPAddress(LastIP);
    }   
    
 
    public static int getHostAdrPart(String object){
        try {
            return Integer.parseInt(object.substring(object.lastIndexOf(".") + 1));
        } catch (NumberFormatException e) {return -1;}
    }
    

    public static String getNetAdrPart(String IPAdr){
        return IPAdr.substring(0, IPAdr.lastIndexOf(".") + 1);
    }
    

    public static int getFirstAdrHost(String object){
        if (object == null) return -1;
        int FirstInt = 0;
      
        int sprpos = object.indexOf("-");
        if (sprpos != -1)
            FirstInt = getHostAdrPart(object.substring(0, sprpos));               
        else {
            int hostpart = getHostAdrPart(object);
            if (hostpart == 1) 
                FirstInt = 0;
            else if (hostpart == 254) 
                FirstInt = 1;
            else 
                FirstInt = hostpart;     
        }        
        return FirstInt;
    }

   
    public static int getLastAdrHost(String object){
        if (object == null) return -1;
        int LastInt = 0;
      
        int sprpos = object.indexOf("-");
        if (sprpos != -1)
            LastInt = getHostAdrPart(getNetAdrPart(object) + object.substring(sprpos + 1));               
        else {
            int hostpart = getHostAdrPart(object);
            if (hostpart == 1)
                LastInt = 254;
            else if (hostpart == 254)
                LastInt = 254;
            
            else
                LastInt = hostpart;     
        }        
        return LastInt;        
    }  
    public static int getOtherLastAdrHost(String object){
        if (object == null) return -1;
        int LastInt = 0;
      
        int sprpos = object.indexOf("-");
        if (sprpos != -1)
            LastInt = getHostAdrPart(getNetAdrPart(object) + object.substring(sprpos + 1));               
        else {
            int hostpart = getHostAdrPart(object);
            if (hostpart == 1)
                LastInt = 10;
            
            else
                LastInt = hostpart;     
        }        
        return LastInt;        
    }
}