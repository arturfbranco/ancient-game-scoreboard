package Processor;

import Interface.PerformanceStats;
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
            Logger.log("Computing scoreboard for N = " + (i + 1) + " and values " + a + " and " + b);
            int droppedBranches = 0;
            for(SumCombination sumCombination: sumCombinations){

                Integer directUpSum = sumCombination.getUpSum() + a;
                Integer directDownSum = sumCombination.getDownSum() + b;
                SumCombination newDirect = new SumCombination(directUpSum, directDownSum);
                boolean addedDirect = updatedSumCombinations.add(newDirect);

                Integer reverseUpSum = sumCombination.getUpSum() + b;
                Integer reverseDownSum = sumCombination.getDownSum() + a;
                SumCombination newReverse = new SumCombination(reverseUpSum, reverseDownSum);
                boolean addedReverse = updatedSumCombinations.add(newReverse);

                if(!addedDirect){
                    droppedBranches++;
                }
                if(!addedReverse){
                    droppedBranches++;
                }
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
            Logger.logPerformanceStats(i + 1, updatedSumCombinations.size(), droppedBranches);
            sumCombinations = updatedSumCombinations;
        }
        return sumCombinations;
    }
}
