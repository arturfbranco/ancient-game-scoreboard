import Interface.ElapsedTimeLog;
import Interface.ScoreBoard;
import Interface.SumValueWrapper;
import Util.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OutputBuilder {

    public void printTimes(){
        List<ElapsedTimeLog> timeLogs = Logger.getTimeLogs();
        timeLogs.sort(Comparator.comparingInt(ElapsedTimeLog::getN));
        System.out.println("N,Time(seconds)");
        for(ElapsedTimeLog timeLog : timeLogs){
            System.out.print(timeLog.getN() + "," + timeLog.getTimeElapsed() / 1000.0 + "\n");
        }
    }
    public void sendOutput(List<SumValueWrapper> output){

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
