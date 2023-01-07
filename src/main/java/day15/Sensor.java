package day15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sensor {

    private final List<Integer> sensorCoordinates;
    private final List<Integer> beaconCoordinates;
    private final int distance;

    public Sensor(List<Integer> sensorCoordinates, List<Integer> beaconCoordinates) {
        this.sensorCoordinates = sensorCoordinates;
        this.beaconCoordinates = beaconCoordinates;
        this.distance = Math.abs(beaconCoordinates.get(0) - sensorCoordinates.get(0)) + Math.abs(beaconCoordinates.get(1) - sensorCoordinates.get(1));
    }

    public void calculateCoveredPositionsAtHeight(int targetYCoordinate, Set<Integer> foo) {
        if (isInRange(targetYCoordinate)) {
            //only consider and store X coordinates
            if (targetYCoordinate >= sensorCoordinates.get(1)) {
                int remaining = Math.abs(distance - (targetYCoordinate - sensorCoordinates.get(1)));
                Set<Integer> coveredCoordinates = calculateCoordinates(remaining, targetYCoordinate);
                foo.addAll(coveredCoordinates);
            } else {
                int remaining = Math.abs(distance - (sensorCoordinates.get(1) - targetYCoordinate));
                Set<Integer> coveredCoordinates = calculateCoordinates(remaining, targetYCoordinate);
                foo.addAll(coveredCoordinates);
            }
        }
    }

    public boolean isInDistance(List<Integer> targetCoordinate) {
        int sensorToTarget = Math.abs(targetCoordinate.get(0) - sensorCoordinates.get(0)) + Math.abs(targetCoordinate.get(1) - sensorCoordinates.get(1));
        return sensorToTarget <= distance;
    }

    public Set<List<Integer>> calculateOutline(int limit) {

        Set<List<Integer>> outlineCoordinates = new HashSet<>();
        int outlineDistance = distance + 1;
        for (int i = 0; i <= outlineDistance; i++) {
            Integer sensorX = this.sensorCoordinates.get(0);
            Integer sensorY = this.sensorCoordinates.get(1);
            int outlineX = outlineDistance - i;
            List<Integer> newCoordinate = List.of(sensorX - outlineX, sensorY + i);
            if (isInLimit(newCoordinate, limit)) {
                outlineCoordinates.add(newCoordinate);
            }
            newCoordinate = List.of(sensorX + outlineX, sensorY + i);
            if (isInLimit(newCoordinate, limit)) {
                outlineCoordinates.add(newCoordinate);
            }
            newCoordinate = List.of(sensorX + outlineX, sensorY + i);
            if (isInLimit(newCoordinate, limit)) {
                outlineCoordinates.add(newCoordinate);
            }
            newCoordinate = List.of(sensorX + outlineX, sensorY + i);
            if (isInLimit(newCoordinate, limit)) {
                outlineCoordinates.add(newCoordinate);
            }
        }

        return outlineCoordinates;
    }

    private boolean isInLimit(List<Integer> coordinateToCheck, int limit) {
        if (coordinateToCheck.get(0) < 0 || coordinateToCheck.get(0) > limit || coordinateToCheck.get(1) < 0 || coordinateToCheck.get(1) > limit) {
            return false;
        } else {
            return true;
        }
    }

    private Set<Integer> calculateCoordinates(int remaining, int targetYCoordinate) {
        Set<Integer> result = new HashSet<>();
        Integer xCoordinate = this.sensorCoordinates.get(0);
        for (int i = xCoordinate - remaining; i <= xCoordinate + remaining; i++) {
            result.add(i);
        }
        return result;
    }

    private boolean isInRange(int targetYCoordinate) {
        if (sensorCoordinates.get(1) + distance >= targetYCoordinate && sensorCoordinates.get(1) - distance <= targetYCoordinate) {
            return true;
        } else {
            return false;
        }
    }

    public List<Integer> getSensorCoordinates() {
        return sensorCoordinates;
    }

    public List<Integer> getBeaconCoordinates() {
        return beaconCoordinates;
    }

    public int getDistance() {
        return distance;
    }
}
