package day20;

public class NumberWrapper {
    private final long val;
    private final int idx;
    private boolean visited = false;

    public NumberWrapper(long val, int idx) {
        this.val = val;
        this.idx = idx;
    }

    public long getVal() {
        return val;
    }

    public int getIdx() {
        return idx;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
