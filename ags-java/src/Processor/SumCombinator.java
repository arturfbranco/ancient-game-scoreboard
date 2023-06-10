package Processor;

import Interface.SumCombination;
import Util.Logger;

import java.util.*;

public class SumCombinator {

    public Set<SumCombination> calculateSumCombinations(int[][] scoreboards){
        Set<SumCombination> sumCombinations = new HashSet<>();
        SumCombination root = new SumCombination(0, 0);
        sumCombinations.add(root);
        Logger.log("Scoreboards list size: " + scoreboards.length +". Starting calculation of possible sums...");

        for(int i = 0; i < scoreboards.length; i++){
            int[] currentScoreboard = scoreboards[i];
            int a = currentScoreboard[0];
            int b = currentScoreboard[1];
            Set<SumCombination> updatedSumCombinations = new HashSet<>();
            Logger.log("Computing scoreboard with index " + i + " and values " + a + " and " + b);
            for(SumCombination sumCombination: sumCombinations){

                Integer directUpSum = sumCombination.getUpSum() + a;
                Integer directDownSum = sumCombination.getDownSum() + b;
                SumCombination newDirect = new SumCombination(directUpSum, directDownSum);
                updatedSumCombinations.add(newDirect);

                Integer reverseUpSum = sumCombination.getUpSum() + b;
                Integer reverseDownSum = sumCombination.getDownSum() + a;
                SumCombination newReverse = new SumCombination(reverseUpSum, reverseDownSum);
                updatedSumCombinations.add(newReverse);

                if(i == scoreboards.length - 1){
                    Logger.log("Final sum: A: " + newDirect.getUpSum() + "; B: " + newDirect.getDownSum());
                    if(newDirect.getUpSum().equals(newDirect.getDownSum())){
                        return new HashSet<>(List.of(newDirect));
                    }
                    Logger.log("Final sum: A: " + newReverse.getUpSum() + "; B: " + newReverse.getDownSum());
                    if(newReverse.getUpSum().equals(newReverse.getDownSum())){
                        return new HashSet<>(List.of(newReverse));
                    }

                }
            }
            int totalCombinations = new Double(Math.pow(2, i)).intValue();
            Logger.log("Total combinations for index " + i + ": " + totalCombinations);
            Logger.log("Total actually used combinations for index " + i + ": " + updatedSumCombinations.size());
            Logger.log("Number of combinations dropped at index " + i + ": " + (totalCombinations - updatedSumCombinations.size()));
            sumCombinations = updatedSumCombinations;
        }

        return sumCombinations;
    }
}
