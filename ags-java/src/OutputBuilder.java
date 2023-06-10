import Interface.ElapsedTimeLog;
import Interface.ScoreBoard;
import Interface.SumValueWrapper;
import Util.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OutputBuilder {

    public void printTimes(){
        List<ElapsedTimeLog> timeLogs = Logger.getTimeLogs();
        for(ElapsedTimeLog timeLog : timeLogs){
            System.out.println("N: " + timeLog.getN() + " | Time(seconds): " + timeLog.getTimeElapsed() / 1000.0);
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
