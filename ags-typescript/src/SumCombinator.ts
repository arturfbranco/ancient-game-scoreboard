import { Direction, SumCombination } from "./interfaces";

export function getAllSumCombinations(scoreBoards: number[][]): SumCombination[] {
    let sumCombinations: SumCombination[] = [];
    const firstBoard: SumCombination = {
        upSum: scoreBoards[0][0],
        downSum: scoreBoards[0][1],
        coordinates: new Map()
    }
    sumCombinations.push(firstBoard);
    for(let i = 1; i < scoreBoards.length; i++){
        const currentScoreboard = scoreBoards[i];
        const a = currentScoreboard[0];
        const b = currentScoreboard[1];
        const updatedSumCombinations = [];
        for(const combination of sumCombinations){
            const directCoordinates = new Map(combination.coordinates);
            directCoordinates.set(i, Direction.DIRECT);
            const newDirect: SumCombination = {
                upSum: combination.upSum + a,
                downSum: combination.downSum + b,
                coordinates: directCoordinates
            }
            const reverseCoordinates = new Map(combination.coordinates);
            reverseCoordinates.set(i, Direction.REVERSE);
            const newReverse: SumCombination = {
                upSum: combination.upSum + b,
                downSum: combination.downSum + a,
                coordinates: reverseCoordinates
            }
            updatedSumCombinations.push(newDirect);
            updatedSumCombinations.push(newReverse);
        }
        sumCombinations = updatedSumCombinations;
    }
    return sumCombinations;
}