package Interface;

import java.util.Map;
import java.util.Objects;

public class SumCombination {
    private Integer upSum;
    private Integer downSum;

    public SumCombination(Integer upSum, Integer downSum) {
        this.upSum = upSum;
        this.downSum = downSum;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SumCombination otherSumCombination = (SumCombination) o;
        Integer otherUpSum = otherSumCombination.getUpSum();
        Integer otherDownSum = otherSumCombination.getDownSum();
        return otherUpSum.equals(this.upSum) && otherDownSum.equals(this.downSum)
                || otherUpSum.equals(this.downSum) && otherDownSum.equals(this.upSum);
    }

    @Override
    public int hashCode() {
        return this.upSum.hashCode() ^ this.downSum.hashCode();
    }
}
