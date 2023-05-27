package Processor;

import Interface.SumCombination;
import Interface.SumValueWrapper;

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
            return new SumValueWrapper(highestValue, null);
        }

        // Get prospects for one scoreboard removal
        ScoreboardRemovalProcessor prospectsProcessor = new ScoreboardRemovalProcessor();
        List<SumValueWrapper> prospects = prospectsProcessor.processProspectsForScoreboardRemoval(scoreboards, sumCombinations);

        if(prospects.size() == 0){
            return new SumValueWrapper(null, null);
        }

        if(prospects.size() == 1){
            return prospects.get(0);
        }

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

        // Get scoreboard with highest "a" value
        SumValueWrapper lowestValueForA = null;

        for(SumValueWrapper sumValue : highestSums){
            if(lowestValueForA == null || sumValue.getScoreBoard().getA() < lowestValueForA.getScoreBoard().getA()){
                lowestValueForA = sumValue;
            }
        }
        return lowestValueForA;
    }
}
