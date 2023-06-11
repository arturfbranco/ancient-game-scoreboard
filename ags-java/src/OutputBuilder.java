import Interface.ElapsedTimeLog;
import Interface.PerformanceStats;
import Interface.ScoreBoard;
import Interface.SumValueWrapper;
import Util.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OutputBuilder {

    private static boolean sendOutput = true;

    public void printTimes(){
        List<ElapsedTimeLog> timeLogs = Logger.getTimeLogs();
        if (timeLogs.size() > 0){
            timeLogs.sort(Comparator.comparingInt(ElapsedTimeLog::getN));
            System.out.println("N,Time(seconds)");
            for(ElapsedTimeLog timeLog : timeLogs){
                System.out.print(timeLog.getN() + "," + timeLog.getTimeElapsed() / 1000.0 + "\n");
            }
        }
    }

    public void printStats(){
        List<PerformanceStats> stats = Logger.getPerformanceStats();
        if(stats.size() > 0){
            System.out.println("N,Total Combinations (exponential),Used Combinations,Dropped Combinations,New Dropped Branches");
            for(PerformanceStats pStat : stats){
                System.out.println(pStat.getN()
                        + "," + pStat.getTotalCombinations()
                        + "," + pStat.getUsedCombinations()
                        + "," + pStat.getDroppedCombinations()
                        + "," + pStat.getNewDroppedBrances());
            }
        }
    }
    public void sendOutput(List<SumValueWrapper> output){
        if(sendOutput){
            for(SumValueWrapper scoreboards : output){
                Integer value = scoreboards.getValue();
                ScoreBoard scoreBoard = scoreboards.getScoreBoard();
                if(value == null){
                    System.out.println("impossível");
                } else if(scoreBoard == null){
                    System.out.println(value + " nenhuma placa descartada");
                } else {
                    System.out.println(value + " descartada a placa " + scoreBoard.getA() + " " + scoreBoard.getB());
                }
            }
        }
    }

    public static void blockOutput(){
        sendOutput = false;
    }
}
