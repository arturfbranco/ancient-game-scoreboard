package Interface;

import java.util.Map;

public class SumCombination {
    private Integer upSum;
    private Integer downSum;
    private Map<Integer, Direction> coordinates;

    public SumCombination(Integer upSum, Integer downSum, Map<Integer, Direction> coordinates) {
        this.upSum = upSum;
        this.downSum = downSum;
        this.coordinates = coordinates;
    }

    public SumCombination() {
    }

    public Integer getUpSum() {
        return upSum;
    }

    public void setUpSum(Integer upSum) {
        this.upSum = upSum;
    }

    public Integer getDownSum() {
        return downSum;
    }

    public void setDownSum(Integer downSum) {
        this.downSum = downSum;
    }

    public Map<Integer, Direction> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Map<Integer, Direction> coordinates) {
        this.coordinates = coordinates;
    }
}
