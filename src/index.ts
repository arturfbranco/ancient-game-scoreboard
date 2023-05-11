import { getAllSumCombinations } from "./SumCombinator";
import { Direction, SumCombination, SumValueWrapper } from "./interfaces";


const entry = [
    [9, 3],
    [2, 1],
    [5, 2],
    [6, 8]
]

function getEqualSumCombination(scoreboards: number[][]): SumValueWrapper {
    const sumCombinations = getAllSumCombinations(entry);

    const matches: SumCombination[] = []
    for(const combination of sumCombinations){
        const upSum = combination.upSum;
        const downSum = combination.downSum;
        if(upSum === downSum){
            matches.push(combination);
        }
    }

    if(matches.length !== 0){
        let highestValue = -1;
        for(const match of matches){
            if(match.upSum > highestValue){
                highestValue = match.upSum;
            }
        }
        return {value: highestValue, scoreboard: null}
    }

    const prospects: SumValueWrapper[] = []

    for(let i = 0; i < entry.length; i++){
        for(let j = 0; j > sumCombinations.length; j++){
            const a = entry[i][0];
            const b = entry[i][1];
            const combinationDirection = sumCombinations[j].coordinates.get(i);
            let updatedA;
            let updatedB;
            if(combinationDirection === Direction.DIRECT){
                updatedA = sumCombinations[j].upSum - a;
                updatedB = sumCombinations[j].downSum - b;
            } else {
                updatedA = sumCombinations[j].upSum - b;
                updatedB = sumCombinations[j].downSum - a;
            }
            if(updatedA === updatedB){
                prospects.push({value: updatedA, scoreboard: {a, b}})
            }
        }
    }
    if(prospects.length === 0){
        return {value: null, scoreboard: null};
    }
    let highestSumValueWrappers: SumValueWrapper[] = []
    let highestValue = -1;
    for(const sumValue of prospects){
        if(highestSumValueWrappers.length === 0){
            highestSumValueWrappers.push(sumValue);
        } else if(sumValue.value === highestValue){
            highestSumValueWrappers.push(sumValue);
        } else if(sumValue.value! > highestValue){
            highestSumValueWrappers = [sumValue];
        }
    }
    if(highestSumValueWrappers.length === 1){
        return highestSumValueWrappers[0];
    }
    
    let lowestValueForA: SumValueWrapper | null = null;
    for(const sumValue of highestSumValueWrappers){
        if(lowestValueForA === null){
            lowestValueForA = sumValue;
        } else if(sumValue.scoreboard!.a < lowestValueForA.scoreboard!.a){
            lowestValueForA = sumValue;
        }
    }
    return lowestValueForA!;

}