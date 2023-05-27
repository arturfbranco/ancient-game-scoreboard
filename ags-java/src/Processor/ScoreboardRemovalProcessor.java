package Processor;

import Interface.Direction;
import Interface.ScoreBoard;
import Interface.SumCombination;
import Interface.SumValueWrapper;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardRemovalProcessor {

    public List<SumValueWrapper> processProspectsForScoreboardRemoval(int[][] scoreboards, List<SumCombination> sumCombinations){

        List<SumValueWrapper> prospects = new ArrayList<>();

        // Go through each scoreboard and test its removal
        for(int i = 0; i < scoreboards.length; i++){

            // Apply removal of scoreboard to each sum combination
            for(SumCombination sumCombination : sumCombinations){

                int a = scoreboards[i][0];
                int b = scoreboards[i][1];
                int updatedSumA;
                int updatedSumB;

                // First scoreboard is tree root so is always upwards
                if(i == 0){
                    updatedSumA = sumCombination.getUpSum() - a;
                    updatedSumB = sumCombination.getDownSum() - b;

                // For others we need to get coordinate metadata to find direction of branch for current sum combination
                } else {
                    Direction direction = sumCombination.getCoordinates().get(i);
                    if(direction.equals(Direction.DIRECT)){
                        updatedSumA = sumCombination.getUpSum() - a;
                        updatedSumB = sumCombination.getDownSum() - b;
                    } else {
                        updatedSumA = sumCombination.getUpSum() - b;
                        updatedSumB = sumCombination.getDownSum() - a;
                    }
                }

                if(updatedSumA == updatedSumB){
                    // Make sure a < b
                    if(a > b){
                        int aux = a;
                        a = b;
                        b = aux;
                    }
                    ScoreBoard scoreBoard = new ScoreBoard(a, b);
                    SumValueWrapper sumValueWrapper = new SumValueWrapper(updatedSumA, scoreBoard);
                    prospects.add(sumValueWrapper);
                }
            }
        }
        return prospects;
    }
}
