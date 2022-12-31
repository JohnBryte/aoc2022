package day01;

import utils.Day;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 extends Day {

    public Day01(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        int currentMax = 0;
        int max = 0;
        int counter = 0;
        for (String calories : input) {
            if (calories.equals("") || counter == input.size()-1) {
                if (currentMax > max) {
                    max = currentMax;
                }
                currentMax = 0;
                counter++;
                continue;
            }
            currentMax += Integer.parseInt(calories);
            counter++;
        }
        return String.valueOf(max);
    }

    @Override
    public String solvePart2() {
        int currentSum = 0;
        List<Integer> sumOfAllElves = new ArrayList<>();
        int counter = 0;
        for (String calories : input) {
            if (calories.equals("")) {
                sumOfAllElves.add(currentSum);
                currentSum = 0;
                counter++;
                continue;
            } else if (counter == input.size()-1) {
                currentSum += Integer.parseInt(calories);
                sumOfAllElves.add(currentSum);
                continue;
            }
            counter++;
            currentSum += Integer.parseInt(calories);
        }
        sumOfAllElves.sort(Collections.reverseOrder());
        return String.valueOf(sumOfAllElves.stream().limit(3).mapToInt(Integer::intValue).sum());
    }
}
