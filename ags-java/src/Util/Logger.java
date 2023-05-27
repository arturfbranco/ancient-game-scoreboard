package Util;

import java.sql.Timestamp;

public class Logger {
    private static boolean enabled = false;
    public static void log(String message){
        if(enabled){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("[" + timestamp + "]: " + message);
        }
    }

    public static void enableLogger(){
        enabled = true;
    }
}
