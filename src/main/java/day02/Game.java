package day02;

public class Game {

    public int playRound(EPlay enemy, EPlay player) {
        if (player.equals(EPlay.ROCK) && enemy.equals(EPlay.SCISSOR) ||
            player.equals(EPlay.PAPER) && enemy.equals(EPlay.ROCK) ||
            player.equals(EPlay.SCISSOR) && enemy.equals(EPlay.PAPER)) {
            //win
            return player.getValue() + 6;
        } else if (enemy.getValue() == player.getValue()) {
            //draw
            return player.getValue() + 3;
        } else {
            //loss
            return player.getValue();
        }
    }
}
