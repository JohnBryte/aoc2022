package day14;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SandStrategyPart1 implements ISandStrategy {

    private final Map<List<Integer>, IMaterial> sand;
    private final Set<List<Integer>> stones;
    private final int sandStart;

    public SandStrategyPart1(Map<List<Integer>, IMaterial> sand, Set<List<Integer>> stones, int sandStart) {
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
        Integer lowestY = lowestStone.get(1);
        while (lastGrainOfSand.getY() != lowestY) {
            lastGrainOfSand = calculateNextSand(nextSandPosition, counter, lowestY);
//            drawMap(sand);
            nextSandPosition = findHighestGrainOfSand(sandStart, sand);
            counter++;
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
        if (checkDown(highestSand)) {
            Sand grainOfSand = new Sand(counter);
            List<Integer> sandPosition = List.of(x, y + 1);
            grainOfSand.setPosition(sandPosition);
            return calculateNextSand(grainOfSand, counter, lowestY);
        } else if(checkLeft(highestSand)) {
            Sand grainOfSand = new Sand(counter);
            List<Integer> sandPosition = List.of(x - 1, y + 1);
            grainOfSand.setPosition(sandPosition);
            return calculateNextSand(grainOfSand, counter, lowestY);
        } else if (checkRight(highestSand)) {
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

    private boolean checkRight(Sand highestSand) {
        return sand.get(List.of(highestSand.getX() + 1, highestSand.getY() + 1)) == null;// && lowestY > highestSand.getY() + 1;
    }

    private boolean checkLeft(Sand highestSand) {
        return sand.get(List.of(highestSand.getX() - 1, highestSand.getY() + 1)) == null;// && lowestY > highestSand.getY() + 1;
    }

    private boolean checkDown(Sand highestSand) {
        return sand.get(List.of(highestSand.getX(), highestSand.getY() + 1)) == null;// && lowestY > highestSand.getY() + 1;
    }
}
