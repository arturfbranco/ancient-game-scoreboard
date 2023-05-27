package Processor;

import Interface.Direction;
import Interface.SumCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumCombinator {

    public List<SumCombination> calculateSumCombinations(int[][] scoreboards){
        List<SumCombination> sumCombinations = new ArrayList<>();
        int[] firstScoreBoard = scoreboards[0];
        Map<Integer, Direction> firstCoordinates = new HashMap<>();
        firstCoordinates.put(0, null);
        SumCombination firstSumCombination = new SumCombination(firstScoreBoard[0], firstScoreBoard[1], firstCoordinates);
        sumCombinations.add(firstSumCombination);

        for(int i = 1; i < scoreboards.length; i++){
            int[] currentScoreboard = scoreboards[i];
            int a = currentScoreboard[0];
            int b = currentScoreboard[1];
            List<SumCombination> updatedSumCombinations = new ArrayList<>();
            for(SumCombination sumCombination: sumCombinations){
                Map<Integer, Direction> directCoordinates = new HashMap<>(sumCombination.getCoordinates());
                directCoordinates.put(i, Direction.DIRECT);
                Integer directUpSum = sumCombination.getUpSum() + a;
                Integer directDownSum = sumCombination.getDownSum() + b;
                SumCombination newDirect = new SumCombination(directUpSum, directDownSum, directCoordinates);
                updatedSumCombinations.add(newDirect);

                Map<Integer, Direction> reverseCoodinates = new HashMap<>(sumCombination.getCoordinates());
                reverseCoodinates.put(i, Direction.REVERSE);
                Integer reverseUpSum = sumCombination.getUpSum() + b;
                Integer reverseDownSum = sumCombination.getDownSum() + a;
                SumCombination newReverse = new SumCombination(reverseUpSum, reverseDownSum, reverseCoodinates);
                updatedSumCombinations.add(newReverse);
            }
            sumCombinations = updatedSumCombinations;
        }

        return sumCombinations;
    }
}
