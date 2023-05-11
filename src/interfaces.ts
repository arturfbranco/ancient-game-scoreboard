export interface SumCombination {
    upSum: number,
    downSum: number,
    coordinates: Map<number, Direction>
}

export enum Direction {
    DIRECT,
    REVERSE
}

export interface SumValueWrapper {
    value: number | null,
    scoreboard: {
        a: number,
        b: number
    } | null
}