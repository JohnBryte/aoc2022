package day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ISandStrategy {
    int calculateSand();

    default Sand findHighestGrainOfSand(int sandStart, Map<List<Integer>, IMaterial> sand) {
        List<Integer> currentHighest = new ArrayList<>();
        currentHighest.add(0);
        currentHighest.add(Integer.MAX_VALUE);
        for (List<Integer> point : sand.keySet()) {
            if (point.get(1) <= currentHighest.get(1) && point.get(0) == sandStart) {
                currentHighest = point;
            }
        }
        IMaterial sand1 = sand.get(currentHighest);
        Sand nextSandPosition = new Sand(-1);
        nextSandPosition.setPosition(List.of(sand1.getX(), sand1.getY() - 1));
        return nextSandPosition;
    }

    default List<Integer> findLeftLowestStone(Set<List<Integer>> stones) {
        List<Integer> currentLowest = new ArrayList<>();
        currentLowest.add(Integer.MAX_VALUE);
        currentLowest.add(Integer.MIN_VALUE);
        for (List<Integer> point : stones) {
            if (point.get(1) >= currentLowest.get(1)) {
                currentLowest = point;
            }
        }
        return currentLowest;
    }

    default void drawMap(Map<List<Integer>, IMaterial> sand) {
        //only for testing
        //for real data, needs to adjust values
        System.out.println("==============================");
        System.out.println();
        System.out.println("==============================");
        for (int row = 0; row < 13; row++) {
            StringBuilder mapRow = new StringBuilder();
            for (int col = 0; col < 520; col++) {
                if (row == 0 && col == 500) {
                    mapRow.append("+");
                } else if (sand.containsKey(List.of(col, row))) {
                    mapRow.append(sand.get(List.of(col, row)).drawMaterial());
                }else {
                    mapRow.append(".");
                }
            }
            System.out.println(mapRow);
        }
    }
}
