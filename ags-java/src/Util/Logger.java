package Util;

import Interface.ElapsedTimeLog;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static boolean enabled = false;
    private static final List<ElapsedTimeLog> elapsedTimeLogs = new ArrayList<>();
    public static void log(String message){
        if(enabled){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("[" + timestamp + "]: " + message);
        }
    }

    public static void logTime(Integer n, long time){
        if(enabled){
            ElapsedTimeLog elapsedTimeLog = new ElapsedTimeLog(n, time);
            elapsedTimeLogs.add(elapsedTimeLog);
        }
    }

    public static List<ElapsedTimeLog> getTimeLogs(){
        return elapsedTimeLogs;
    }

    public static void enableLogger(){
        enabled = true;
    }
}
