package day15;

import utils.Day;

import java.math.BigInteger;
import java.util.*;

public class Day15 extends Day {

    List<Sensor> sensorList = new ArrayList<>();
    private final int yTargetCoordinatePartOne;
    private final int limit;

    public Day15(List<String> input, int yTargetCoordinatePartOne, int limit) {
        super(input);
        this.yTargetCoordinatePartOne = yTargetCoordinatePartOne;
        this.limit = limit;
    }

    @Override
    public String solvePart1() {
        Set<Integer> resultOnlyX = new HashSet<>();
        for (String line : input) {
            populateSensorList(line).calculateCoveredPositionsAtHeight(yTargetCoordinatePartOne, resultOnlyX);
        }
        for (Sensor sensor : sensorList) {
            if (sensor.getBeaconCoordinates().get(1) == yTargetCoordinatePartOne) {
                resultOnlyX.remove(sensor.getBeaconCoordinates().get(0));
            }
        }
        return String.valueOf(resultOnlyX.size());
    }

    @Override
    public String solvePart2() {
        for (String line : input) {
            populateSensorList(line);
        }

        for (Sensor sensor : sensorList) {
            Set<List<Integer>> outline = sensor.calculateOutline(limit);
            for (List<Integer> outlineCoordinate : outline) {
                if (sensorList.stream().noneMatch(s -> s.isInDistance(outlineCoordinate))) {
//                    System.out.println("X: " + outlineCoordinate.get(0) + ", Y: " + outlineCoordinate.get(1));
                    long x = outlineCoordinate.get(0);
                    long y = outlineCoordinate.get(1);
                    return String.valueOf(BigInteger.valueOf(x * 4000000 + y));
                }
            }
        }
        return "Failed to find solution";
    }

    private Sensor populateSensorList(String line) {
        String[] inputLine = line.split(": closest beacon is at ");
        String[] beaconCoordinates = inputLine[1].split(", ");
        Integer beaconX = Integer.parseInt(beaconCoordinates[0].split("x=")[1]);
        Integer beaconY = Integer.parseInt(beaconCoordinates[1].split("y=")[1]);
        String[] sensorCoordinates = inputLine[0].split("Sensor at ")[1].split(", ");
        Integer sensorX = Integer.parseInt(sensorCoordinates[0].split("x=")[1]);
        Integer sensorY = Integer.parseInt(sensorCoordinates[1].split("y=")[1]);
        Sensor sensor = new Sensor(List.of(sensorX, sensorY), List.of(beaconX, beaconY));
        sensorList.add(sensor);
        return sensor;
    }
}
