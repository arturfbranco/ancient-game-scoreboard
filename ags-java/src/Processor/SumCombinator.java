package Processor;

import Interface.Direction;
import Interface.SumCombination;
import Util.Logger;

import java.util.*;

public class SumCombinator {

    public List<SumCombination> calculateSumCombinations(int[][] scoreboards){
        List<SumCombination> sumCombinations = new ArrayList<>();
        SumCombination root = new SumCombination(0, 0, null);
        sumCombinations.add(root);
        Logger.log("Starting calculation of possible sums...");
        Logger.log("0: Direct position / 1: Reverse position");
        for(int i = 0; i < scoreboards.length; i++){
            int[] currentScoreboard = scoreboards[i];
            int a = currentScoreboard[0];
            int b = currentScoreboard[1];
            List<SumCombination> updatedSumCombinations = new ArrayList<>();
            Logger.log("Computing scoreboard with index " + i + " and values " + a + " and " + b);
            for(SumCombination sumCombination: sumCombinations){
                Map<Integer, Direction> previousCoordinates = sumCombination.getCoordinates();

                Map<Integer, Direction> directCoordinates;
                if(previousCoordinates == null){
                    directCoordinates = new HashMap<>();
                } else {
                    directCoordinates = new HashMap<>(previousCoordinates);
                }
                directCoordinates.put(i, Direction.DIRECT);
                Integer directUpSum = sumCombination.getUpSum() + a;
                Integer directDownSum = sumCombination.getDownSum() + b;
                SumCombination newDirect = new SumCombination(directUpSum, directDownSum, directCoordinates);
                updatedSumCombinations.add(newDirect);

                Map<Integer, Direction> reverseCoordinates;
                if(previousCoordinates == null){
                    reverseCoordinates = new HashMap<>();
                } else {
                    reverseCoordinates = new HashMap<>(previousCoordinates);
                }
                reverseCoordinates.put(i, Direction.REVERSE);
                Integer reverseUpSum = sumCombination.getUpSum() + b;
                Integer reverseDownSum = sumCombination.getDownSum() + a;
                SumCombination newReverse = new SumCombination(reverseUpSum, reverseDownSum, reverseCoordinates);
                updatedSumCombinations.add(newReverse);
                if(i == scoreboards.length - 1){
                    Logger.log("Final sum: A: " + newDirect.getUpSum() + "; B: " + newDirect.getDownSum());
                    Logger.log("Final sum: A: " + newReverse.getUpSum() + "; B: " + newReverse.getDownSum());
                }
            }
            sumCombinations = updatedSumCombinations;
        }

        return sumCombinations;
    }
}
