package Processor;

import Interface.SumCombination;
import Interface.SumValueWrapper;
import Util.Logger;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProcessor {

    public SumValueWrapper queryHighestEqualScoreboardsSum(int[][] scoreboards){
        List<SumCombination> sumCombinations = new SumCombinator().calculateSumCombinations(scoreboards);


        // Look for sum equality without any removal
        List<SumCombination> matches = new ArrayList<>();
        for(SumCombination sumCombination : sumCombinations){
            Integer upSum = sumCombination.getUpSum();
            Integer downSum = sumCombination.getDownSum();
            if(upSum.equals(downSum)){
                matches.add(sumCombination);
            }
        }

        if(matches.size() > 0){
            Integer highestValue = -1;
            for(SumCombination sumCombination : matches) {
                if(sumCombination.getUpSum() > highestValue){
                    highestValue = sumCombination.getUpSum();
                }
            }
            Logger.log("Match found without removal of any scoreboard: " + highestValue);
            return new SumValueWrapper(highestValue, null);
        }

        Logger.log("Sum mismatch!");

        // Get prospects for one scoreboard removal
        ScoreboardRemovalProcessor prospectsProcessor = new ScoreboardRemovalProcessor();
        List<SumValueWrapper> prospects = prospectsProcessor.processProspectsForScoreboardRemoval(scoreboards, sumCombinations);

        if(prospects.size() == 0){
            Logger.log("No matches found for given scoreboards");
            return new SumValueWrapper(null, null);
        }

        if(prospects.size() == 1){
            SumValueWrapper result = prospects.get(0);
            Logger.log("Matching final sum found with removal of one scoreboard. Value: " + result.getValue() + "; Scoreboard removed: " + result.getScoreBoard().getA() + ", " + result.getScoreBoard().getB());
            return result;
        }

        Logger.log("Number of prospects found: " + prospects.size());

        // Get list of prospects with the highest value
        List<SumValueWrapper> highestSums = null;
        int highestValue = -1;
        for(SumValueWrapper prospect : prospects){
            if(highestSums == null){
                highestValue = prospect.getValue();
                highestSums = new ArrayList<>(List.of(prospect));
            } else if(prospect.getValue().equals(highestValue)){
                highestSums.add(prospect);
            } else if(prospect.getValue() > highestValue){
                highestValue = prospect.getValue();
                highestSums = new ArrayList<>(List.of(prospect));
            }
        }
        if(highestSums.size() == 1){
            return highestSums.get(0);
        }

        Logger.log("Found " + highestSums.size() + " matches with same highest sum");
        // Get scoreboard with highest "a" value
        SumValueWrapper lowestValueForA = null;

        for(SumValueWrapper sumValue : highestSums){
            if(lowestValueForA == null || sumValue.getScoreBoard().getA() < lowestValueForA.getScoreBoard().getA()){
                lowestValueForA = sumValue;
            }
        }
        Logger.log("Matching final sum found with removal of one scoreboard. Value: " + lowestValueForA.getValue() + "; Scoreboard removed: " + lowestValueForA.getScoreBoard().getA() + ", " + lowestValueForA.getScoreBoard().getB());

        return lowestValueForA;
    }
}
