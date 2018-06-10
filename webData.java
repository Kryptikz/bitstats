import java.net.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
public class webData {
    public static double getCurrent() {
        try {
            URLConnection connection = new URL("https://api.coindesk.com/v1/bpi/currentprice.json").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();
            
            BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                sb.append(line);
            }
            
            String get = sb.toString();
            get = get.substring(get.indexOf("&#36")); //clip beginning
            get = get.substring(get.indexOf(",")); //clip after comma
            get = get.substring(get.indexOf(":")); //clip all before price
            get = get.substring(0,get.indexOf("\",\"")); //clip all after price
            get = get.substring(get.indexOf("\"")+1); //clip small details
            String aftercomma = "";
            for(char c : get.toCharArray()) {
                if(c!=',') {
                    aftercomma+=c;
                }
            }
            
            //System.out.println(aftercomma);
            
            //System.out.println(sb.toString());
            return Double.parseDouble(aftercomma);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}