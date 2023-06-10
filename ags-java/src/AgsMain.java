import Interface.ElapsedTimeLog;
import Interface.SumValueWrapper;
import Processor.ScoreboardProcessor;
import Util.Logger;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AgsMain {
    public static void main(String[] args) throws IOException {

        if(args.length == 0){
            System.out.println("Please provide a file path!");
            return;
        }
        if(args.length > 1 && Boolean.parseBoolean(args[1])){
            Logger.enableLogger();
        }
        InputReader inputReader = new InputReader(args[0]);
        int[][][] inputStructure = inputReader.processFile();
        List<SumValueWrapper> outputStructure = new ArrayList<>();
        ScoreboardProcessor processor = new ScoreboardProcessor();
        int i = 0;
        boolean hasNext = true;
        while (i < inputStructure.length && hasNext){
            if(inputStructure[i] == null){
                hasNext = false;
            } else {
                long start = System.currentTimeMillis();
                SumValueWrapper result = processor.queryHighestEqualScoreboardsSum(inputStructure[i]);
                long finish = System.currentTimeMillis();
                Logger.logTime(inputStructure[i].length, finish - start);
                outputStructure.add(result);
                i++;
            }
        }
        OutputBuilder outputBuilder = new OutputBuilder();
        outputBuilder.sendOutput(outputStructure);
        outputBuilder.printTimes();
    }
}