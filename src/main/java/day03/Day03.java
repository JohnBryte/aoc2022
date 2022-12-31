package day03;

import utils.Day;
import java.util.ArrayList;
import java.util.List;

public class Day03 extends Day {

    private final String POINTS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Day03(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        int result = 0;
        for (String rucksack : input) {
            int index = rucksack.length() / 2;
            String firstHalf = rucksack.substring(0, index);
            String secondHalf = rucksack.substring(index);
            for (int i = 0; i < POINTS.length(); i++) {
                if (firstHalf.indexOf(POINTS.charAt(i)) != -1 &&  secondHalf.indexOf(POINTS.charAt(i)) != -1) {
                    result += i +1;
                }
            }
        }
        return String.valueOf(result);
    }

    @Override
    public String solvePart2() {
        int result = 0;
        int counter = 0;
        List<String> rucksacks = new ArrayList<>();
        for (String rucksack : input) {
            rucksacks.add(rucksack);
            counter++;
            if (counter < 3) {
                continue;
            }
            for (int i = 0; i < POINTS.length(); i++) {
                if (rucksacks.get(0).indexOf(POINTS.charAt(i)) != -1 && rucksacks.get(1).indexOf(POINTS.charAt(i)) != -1 && rucksacks.get(2).indexOf(POINTS.charAt(i)) != -1) {
                    result += i+1;
                }
            }
            counter = 0;
            rucksacks = new ArrayList<>();
        }
        return String.valueOf(result);
    }
}
