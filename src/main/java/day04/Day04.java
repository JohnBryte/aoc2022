package day04;

import utils.Day;
import utils.IPuzzleSolver;

import java.util.List;

public class Day04 extends Day implements IPuzzleSolver {
    public Day04(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        int overlaps = 0;
        for (String line : input) {
            String[] section1 = line.split(",")[0].split("-");
            int x1 = Integer.parseInt(section1[0]);
            int x2 = Integer.parseInt(section1[1]);

            String[] section2 = line.split(",")[1].split("-");
            int y1 = Integer.parseInt(section2[0]);
            int y2 = Integer.parseInt(section2[1]);

            if (y1 >= x1 && y2 <= x2) {
                overlaps++;
            } else if (x1 >= y1 && x2 <= y2) {
                overlaps++;
            }

        }
        return String.valueOf(overlaps);
    }

    @Override
    public String solvePart2() {
        int overlaps = 0;
        for (String line : input) {
            String[] section1 = line.split(",")[0].split("-");
            int x1 = Integer.parseInt(section1[0]);
            int x2 = Integer.parseInt(section1[1]);

            String[] section2 = line.split(",")[1].split("-");
            int y1 = Integer.parseInt(section2[0]);
            int y2 = Integer.parseInt(section2[1]);


            if (x1 <= y1 && x2 >= y1) {
                overlaps++;
            } else if (y1 <= x1 && y2 >= x1) {
                overlaps++;
            }

        }
        return String.valueOf(overlaps);
    }
}
