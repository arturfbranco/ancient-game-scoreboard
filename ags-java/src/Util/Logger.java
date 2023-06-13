package Util;

import Interface.ElapsedTimeLog;
import Interface.PerformanceStats;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static boolean loggerEnabled = false;
    private static boolean elapsedTimeEnabled = false;
    private static boolean performanceStatsEnabled = false;
    private static final List<ElapsedTimeLog> elapsedTimeLogs = new ArrayList<>();

    private static final List<PerformanceStats> performanceStats = new ArrayList<>();

    public static void log(String message){
        if(loggerEnabled){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("[" + timestamp + "]: " + message);
        }
    }

    public static void logTime(Integer n, long time){
        if(elapsedTimeEnabled){
            ElapsedTimeLog elapsedTimeLog = new ElapsedTimeLog(n, time);
            elapsedTimeLogs.add(elapsedTimeLog);
        }
    }

    public static void logPerformanceStats(Integer n, Integer combinationsSize, Integer droppedBranches){
        if(performanceStatsEnabled){
            Long totalCombinations = (long) Math.floor(Math.pow(2, n));
            Long droppedCombinations = totalCombinations - combinationsSize;
            PerformanceStats stats = new PerformanceStats(n, totalCombinations, combinationsSize, droppedCombinations, droppedBranches);
            performanceStats.add(stats);
        }
    }



    public static void enableLogger(){
        loggerEnabled = true;
    }

    public static void enableElapsedTime(){
        elapsedTimeEnabled = true;
    }

    public static void enablePerformanceStats(){
        performanceStatsEnabled = true;
    }

    public static List<ElapsedTimeLog> getTimeLogs(){
        return elapsedTimeLogs;
    }

    public static List<PerformanceStats> getPerformanceStats(){
        return performanceStats;
    }
}
