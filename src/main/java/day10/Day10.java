package day10;

import utils.Day;

import java.util.List;

public class Day10 extends Day {
    public Day10(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        int x = 1;
        int cycles = 0;
        int result = 0;
        for (String line : input) {
            if (line.equals("noop")) {
                cycles++;
                result = cycleCheck(x, cycles, result);
            } else {
                for (int i = 0; i <2; i++) {
                    cycles++;
                    result = cycleCheck(x, cycles, result);
                }
                x += Integer.parseInt(line.split(" ")[1]);
            }
        }
        return String.valueOf(result);
    }

    @Override
    public String solvePart2() {
        int x = 1;
        int idx = 0;
        String drawing = "";
        StringBuilder finalString = new StringBuilder();
        for (String line : input) {
            if (line.equals("noop")) {
                drawing = drawPosition(x, idx, drawing);
                idx++;
                if (idx == 40) {
                    System.out.println(drawing);
                    finalString.append(drawing);
                    drawing = "";
                    idx = 0;
                }
            } else {
                for (int i = 0; i <2; i++) {
                    drawing = drawPosition(x, idx, drawing);
                    idx++;
                    if (idx == 40) {
                        System.out.println(drawing);
                        finalString.append(drawing);
                        drawing = "";
                        idx = 0;
                    }
                }
                x += Integer.parseInt(line.split(" ")[1]);
            }
        }
        return finalString.toString();
    }

    private String drawPosition(int x, int idx, String drawing) {
        if (idx == x - 1 || idx == x || idx == x + 1) {
            drawing += "#";
        } else {
            drawing += ".";
        }
        return drawing;
    }

    private int cycleCheck(int x, int cycles, int result) {
        if (cycles == 20 || cycles == 60 || cycles == 100|| cycles == 140 || cycles == 180 || cycles == 220) {
//            System.out.println("X: " + x + ", cycles: " + cycles + ", result: " + x * cycles);
            result += x * cycles;
        }
        return result;
    }
}
