package Interface;

public class SumValueWrapper {
    private Integer value;
    private ScoreBoard scoreBoard;

    public SumValueWrapper(Integer value, ScoreBoard scoreBoard) {
        this.value = value;
        this.scoreBoard = scoreBoard;
    }


    public SumValueWrapper() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
}
