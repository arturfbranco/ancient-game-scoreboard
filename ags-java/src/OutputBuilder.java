import Interface.ScoreBoard;
import Interface.SumValueWrapper;

import java.util.List;

public class OutputBuilder {
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
