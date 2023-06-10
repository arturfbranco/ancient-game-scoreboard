package Interface;

public class ElapsedTimeLog {
    private int n;
    private long timeElapsed;

    public ElapsedTimeLog(int n, long timeElapsed) {
        this.n = n;
        this.timeElapsed = timeElapsed;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
