package day17;

public class CaveState {
    private long rounds;
    private long score;

    public CaveState(long rounds, long score) {
        this.rounds = rounds;
        this.score = score;
    }

    public long getRounds() {
        return rounds;
    }

    public void setRounds(long rounds) {
        this.rounds = rounds;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
