import Interface.SumValueWrapper;
import Processor.ScoreboardProcessor;

public class Main {
    public static void main(String[] args) {

        int[][] input = new int[7][2];

        input[0][0] = 5;
        input[0][1] = 3;

        input[1][0] = 20;
        input[1][1] = 14;

        input[2][0] = 18;
        input[2][1] = 8;

        input[3][0] = 6;
        input[3][1] = 2;

//        input[4][0] = 13;
//        input[4][1] = 10;

        input[4][0] = 9;
        input[4][1] = 35;

        input[5][0] = 1;
        input[5][1] = 27;


        ScoreboardProcessor processor = new ScoreboardProcessor();
        SumValueWrapper result = processor.queryHighestEqualScoreboardsSum(input);
        System.out.println("Value: " + result.getValue() + " Scoreboard: " + result.getScoreBoard().getA() + ", " + result.getScoreBoard().getB());
    }
}