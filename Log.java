import java.io.*;
import java.text.*;
import java.util.*;
public class Log {
    //used for logging price change activity
    public static void serverLog() throws Exception {
        //used for continuous price logging
        BufferedWriter bw = new BufferedWriter(new FileWriter("BTC_server_log.txt"));
        double lprice = webData.getCurrent();
        while(true) {
            double price = webData.getCurrent();
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            String date = df.format(dateobj);
            String line = "[" + date + "] price: " + price + " USD";
            if (lprice>price) {
                line+=" - DOWN: " +(lprice-price);
            } else if (price>lprice) {
                line+=" - UP: " + (price-lprice);
            } else {
                line+=" - NO PRICE CHANGE";
            }
            bw.write(line);
            bw.flush();
            bw.newLine();
            System.out.println(line);
            try {
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            lprice=price;
        }
    }
}