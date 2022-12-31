package day02;

enum EPlay {

    ROCK ( 1),
    PAPER (2),
    SCISSOR (3);

    private final int value;

    EPlay(int value) {
        this.value = value;
    }

    public static EPlay getDraw(EPlay enemy) {
        return enemy;
    }

    public static EPlay getWin(EPlay enemy) {
        if (enemy.equals(ROCK)) {
            return PAPER;
        } else if (enemy.equals(PAPER)) {
            return SCISSOR;
        } else {
            return ROCK;
        }
    }

    public static EPlay getLoss(EPlay enemy) {
        if (enemy.equals(ROCK)) {
            return SCISSOR;
        } else if (enemy.equals(PAPER)) {
            return ROCK;
        } else {
            return PAPER;
        }
    }

    public static EPlay getPlayer(String play) {
        switch (play) {
            case "X": return ROCK;
            case "Y": return PAPER;
            case "Z": return SCISSOR;
            default: return null;
        }
    }

    public static EPlay getEnemy(String play) {
        switch (play) {
            case "A": return ROCK;
            case "B": return PAPER;
            case "C": return SCISSOR;
            default: return null;
        }
    }

    public int getValue() {
        return value;
    }


}
