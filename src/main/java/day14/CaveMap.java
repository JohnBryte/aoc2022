package day14;

import java.util.*;

public class CaveMap {

    private final int sandStart;
    private ISandStrategy sandStrategy;

    public CaveMap(int sandStart) {
        this.sandStart = sandStart;
    }

    private final Map<List<Integer>, IMaterial> sand = new HashMap<>();
    private final Set<List<Integer>> stones = new HashSet<>();


    public void createMap(List<String> input, boolean partOne) {
        for (String line : input) {
            List<String> coordinates = List.of(line.split(" -> "));
            Stone firstStone = new Stone();
            Stone nextStone = new Stone();
            int idx = 0;
            for (String coordinate : coordinates) {
                if (idx == 0) {
                    List<Integer> stonePosition = getStonePosition(coordinate);
                    stones.add(stonePosition);
                    firstStone.setPosition(stonePosition);
                } else if (idx == 1) {
                    List<Integer> stonePosition = getStonePosition(coordinate);
                    nextStone.setPosition(List.of(stonePosition.get(0), stonePosition.get(1)));
                } else {
                    List<Integer> stonePosition = getStonePosition(coordinate);
                    nextStone.setPosition(List.of(stonePosition.get(0), stonePosition.get(1)));
                }
                if (idx >= 1) {
                    while (firstStone.getX() != nextStone.getX() || firstStone.getY() != nextStone.getY()) {
                        if (firstStone.getX() == nextStone.getX()) {
                            if (firstStone.getY() > nextStone.getY()) {
                                firstStone.setPosition(List.of(firstStone.getX(), firstStone.getY() - 1));
                            } else {
                                firstStone.setPosition(List.of(firstStone.getX(), firstStone.getY() + 1));
                            }
                        } else if (firstStone.getX() > nextStone.getX()) {
                            firstStone.setPosition(List.of(firstStone.getX() - 1, firstStone.getY()));
                        } else if (firstStone.getX() < nextStone.getX()) {
                            firstStone.setPosition(List.of(firstStone.getX() + 1, firstStone.getY()));
                        }
                        stones.add(List.of(firstStone.getX(), firstStone.getY()));
                    }
                }
                idx++;
            }
        }
        for (List<Integer> stone : stones) {
            sand.put(stone, new Stone(stone));
        }
        if (partOne) {
            sandStrategy = new SandStrategyPart1(sand, stones, sandStart);
        } else {
            sandStrategy = new SandStrategyPart2(sand, stones, sandStart);
        }
    }

    private List<Integer> getStonePosition(String coordinate) {
        int x = Integer.parseInt(coordinate.split(",")[0]);
        int y = Integer.parseInt(coordinate.split(",")[1]);
        return List.of(x, y);
    }

    public int calculateSand() {
        return sandStrategy.calculateSand();
    }
}
