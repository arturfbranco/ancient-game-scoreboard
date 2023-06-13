package Interface;

public class PerformanceStats {
    private Integer n;
    private Long totalCombinations;
    private Integer usedCombinations;
    private Long droppedCombinations;
    private Integer newDroppedBrances;

    public PerformanceStats(Integer n, Long totalCombinations, Integer usedCombinations, Long droppedCombinations, Integer newDroppedBrances) {
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

    public Long getTotalCombinations() {
        return totalCombinations;
    }

    public void setTotalCombinations(Long totalCombinations) {
        this.totalCombinations = totalCombinations;
    }

    public Integer getUsedCombinations() {
        return usedCombinations;
    }

    public void setUsedCombinations(Integer usedCombinations) {
        this.usedCombinations = usedCombinations;
    }

    public Long getDroppedCombinations() {
        return droppedCombinations;
    }

    public void setDroppedCombinations(Long droppedCombinations) {
        this.droppedCombinations = droppedCombinations;
    }

    public Integer getNewDroppedBrances() {
        return newDroppedBrances;
    }

    public void setNewDroppedBrances(Integer newDroppedBrances) {
        this.newDroppedBrances = newDroppedBrances;
    }
}
