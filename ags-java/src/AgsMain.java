import Interface.ElapsedTimeLog;
import Interface.SumValueWrapper;
import Processor.ScoreboardProcessor;
import Util.Logger;
import Util.Options;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AgsMain {
    public static void main(String[] args) throws Exception {

        if(args.length == 0){
            System.out.println("Please provide a file path!");
            return;
        }
        if(args.length > 1){
            configureOptions(Options.valueOf(args[1].toUpperCase()));
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
        outputBuilder.printTimes();
        outputBuilder.printStats();
        outputBuilder.sendOutput(outputStructure);
    }

    public static void configureOptions(Options option) throws Exception {
        switch (option){
            case ALL:
                Logger.enableLogger();
                Logger.enableElapsedTime();
                Logger.enablePerformanceStats();
                break;
            case LOGS:
                Logger.enableLogger();
                break;
            case TIME:
                Logger.enableElapsedTime();
                OutputBuilder.blockOutput();
                break;
            case STATS:
                Logger.enablePerformanceStats();
                OutputBuilder.blockOutput();
                break;
            default:
                throw new Exception();
        }
    }
}