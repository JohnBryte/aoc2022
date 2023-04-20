package day18;

import utils.Day;

import java.util.ArrayList;
import java.util.List;

public class Day18 extends Day {
    private List<Cube> cubes = new ArrayList<>();
    public Day18(List<String> input) {
        super(input);
        for (String line : input) {
            String[] split = line.split(",");
            cubes.add(new Cube(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }

        for (Cube cube : cubes) {
            for (Cube other : cubes) {
                if (!other.equals(cube)) {
                    cube.checkEdges(other);
                }
            }
        }
    }

    @Override
    public String solvePart1() {

        return String.valueOf(cubes.stream().mapToInt(Cube::getFreeEdges).sum());
    }

    @Override
    public String solvePart2() {
        DropletContainer container = new DropletContainer(cubes);
        container.floodFill();
        return String.valueOf(container.getSurfaceArea());
    }
}
