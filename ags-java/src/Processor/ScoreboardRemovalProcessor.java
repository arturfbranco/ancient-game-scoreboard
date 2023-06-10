package Processor;

import Interface.ScoreBoard;
import Interface.SumCombination;
import Interface.SumValueWrapper;
import Util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ScoreboardRemovalProcessor {

    public List<SumValueWrapper> processProspectsForScoreboardRemoval(int[][] scoreboards, Set<SumCombination> sumCombinations){

        List<SumValueWrapper> prospects = new ArrayList<>();

        Logger.log("Looking for match with one scoreboard removal...");
        // Go through each scoreboard and test its removal
        for(int i = 0; i < scoreboards.length; i++){

            int a = scoreboards[i][0];
            int b = scoreboards[i][1];

            Logger.log("Testing with removal of: " + a + ", " + b);

            // Apply removal of scoreboard to each sum combination
            for(SumCombination sumCombination : sumCombinations){

                Integer upSumMinusA = sumCombination.getUpSum() - a;
                Integer downSumMinusB = sumCombination.getDownSum() - b;

                Integer upSumMinusB = sumCombination.getUpSum() - b;
                Integer downSumMinusA = sumCombination.getDownSum() - a;

                boolean directSubtractionMatch = upSumMinusA.equals(downSumMinusB);
                boolean reverseSubtractionMatch = upSumMinusB.equals(downSumMinusA);

                if(directSubtractionMatch || reverseSubtractionMatch){
                    Logger.log("Match found for " + a + ", " + b);
                    // Make sure a < b
                    if(a > b){
                        int aux = a;
                        a = b;
                        b = aux;
                    }
                    Integer matchValue;
                    if(directSubtractionMatch){
                        matchValue = upSumMinusA;
                    } else {
                        matchValue = upSumMinusB;
                    }
                    ScoreBoard scoreBoard = new ScoreBoard(a, b);
                    SumValueWrapper sumValueWrapper = new SumValueWrapper(matchValue, scoreBoard);
                    prospects.add(sumValueWrapper);
                }
            }
        }
        return prospects;
    }
}
