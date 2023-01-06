package day14;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SandStrategyPart2 implements ISandStrategy {

    private Map<List<Integer>, IMaterial> sand;
    private Set<List<Integer>> stones;
    private int sandStart;

    public SandStrategyPart2(Map<List<Integer>, IMaterial> sand, Set<List<Integer>> stones, int sandStart) {
        this.sand = sand;
        this.stones = stones;
        this.sandStart = sandStart;
    }
    
    @Override
    public int calculateSand() {
        Sand nextSandPosition = findHighestGrainOfSand(sandStart, sand);
        Sand lastGrainOfSand = nextSandPosition;
        int counter = 0;
        List<Integer> lowestStone = findLeftLowestStone(stones);
        Integer lowestY = lowestStone.get(1) + 2;
        while (lastGrainOfSand.getX() != sandStart || lastGrainOfSand.getY() != 0) {
            counter++;
            lastGrainOfSand = calculateNextSand(nextSandPosition, counter, lowestY);
            nextSandPosition = findHighestGrainOfSand(sandStart, sand);
//            drawMap(sand);
        }
//        drawMap(sand);
        return lastGrainOfSand.getSandNummber();
    }

    private Sand calculateNextSand(Sand highestSand, int counter, Integer lowestY) {
        if (highestSand.getY() == lowestY) {
            return highestSand;
        }
        int x = highestSand.getX();
        int y = highestSand.getY();
        if (checkDown(highestSand, lowestY)) {
            Sand grainOfSand = new Sand(counter);
            List<Integer> sandPosition = List.of(x, y + 1);
            grainOfSand.setPosition(sandPosition);
            return calculateNextSand(grainOfSand, counter, lowestY);
        } else if(checkLeft(highestSand, lowestY)) {
            Sand grainOfSand = new Sand(counter);
            List<Integer> sandPosition = List.of(x - 1, y + 1);
            grainOfSand.setPosition(sandPosition);
            return calculateNextSand(grainOfSand, counter, lowestY);
        } else if (checkRight(highestSand, lowestY)) {
            Sand grainOfSand = new Sand(counter);
            List<Integer> sandPosition = List.of(x + 1, y + 1);
            grainOfSand.setPosition(sandPosition);
            return calculateNextSand(grainOfSand, counter, lowestY);
        } else {
            Sand grainOfSand = new Sand(counter);
            List<Integer> sandPosition = List.of(x, y);
            grainOfSand.setPosition(sandPosition);
            sand.put(sandPosition, grainOfSand);
//            map[y][x] = grainOfSand;
            return grainOfSand;
        }
    }

    private boolean checkRight(Sand highestSand, int lowestY) {
        return sand.get(List.of(highestSand.getX() + 1, highestSand.getY() + 1)) == null && lowestY > highestSand.getY() + 1;
    }

    private boolean checkLeft(Sand highestSand, int lowestY) {
        return sand.get(List.of(highestSand.getX() - 1, highestSand.getY() + 1)) == null && lowestY > highestSand.getY() + 1;
    }

    private boolean checkDown(Sand highestSand, int lowestY) {
        return sand.get(List.of(highestSand.getX(), highestSand.getY() + 1)) == null && lowestY > highestSand.getY() + 1;
    }
}
