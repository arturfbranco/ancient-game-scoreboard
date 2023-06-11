package Interface;

public class PerformanceStats {
    private Integer n;
    private Integer totalCombinations;
    private Integer usedCombinations;
    private Integer droppedCombinations;
    private Integer newDroppedBrances;

    public PerformanceStats(Integer n,
                            Integer totalCombinations,
                            Integer usedCombinations,
                            Integer droppedCombinations,
                            Integer newDroppedBrances) {
        this.n = n;
        this.totalCombinations = totalCombinations;
        this.usedCombinations = usedCombinations;
        this.droppedCombinations = droppedCombinations;
        this.newDroppedBrances = newDroppedBrances;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getTotalCombinations() {
        return totalCombinations;
    }

    public void setTotalCombinations(Integer totalCombinations) {
        this.totalCombinations = totalCombinations;
    }

    public Integer getUsedCombinations() {
        return usedCombinations;
    }

    public void setUsedCombinations(Integer usedCombinations) {
        this.usedCombinations = usedCombinations;
    }

    public Integer getDroppedCombinations() {
        return droppedCombinations;
    }

    public void setDroppedCombinations(Integer droppedCombinations) {
        this.droppedCombinations = droppedCombinations;
    }

    public Integer getNewDroppedBrances() {
        return newDroppedBrances;
    }

    public void setNewDroppedBrances(Integer newDroppedBrances) {
        this.newDroppedBrances = newDroppedBrances;
    }
}
