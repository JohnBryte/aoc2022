package day02;

import utils.Day;

import java.util.List;

public class Day02 extends Day {

    public Day02(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        int score = 0;
        Game game = new Game();
        for (String line : input) {
            String[] plays = line.split(" ");
            EPlay enemy = EPlay.getEnemy(plays[0]);
            EPlay player = EPlay.getPlayer(plays[1]);
            assert enemy != null;
            assert player != null;
            score += game.playRound(enemy, player);
        }
        return String.valueOf(score);
    }

    @Override
    public String solvePart2() {
        int score = 0;
        Game game = new Game();
        for (String line : input) {
            String[] plays = line.split(" ");
            EPlay enemy = EPlay.getEnemy(plays[0]);
            String play = plays[1];
            assert enemy != null;
            EPlay player;
            if (play.equals("X")) {
                player = EPlay.getLoss(enemy);
            } else if (play.equals("Y")) {
                player = EPlay.getDraw(enemy);
            } else {
                player = EPlay.getWin(enemy);
            }
            assert player != null;
            score += game.playRound(enemy, player);
        }
        return String.valueOf(score);
    }
}
