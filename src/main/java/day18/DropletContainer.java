package day18;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class DropletContainer {

    private final int sizeX;
    private final int sizeY;
    private final int sizeZ;
    private final boolean[][][] gridContainer;
    private final List<Cube> cubes;
    private int surfaceArea = 0;

    public DropletContainer(List<Cube> cubes) {
        this.cubes = cubes;
        int maxX = 0;
        int maxY = 0;
        int maxZ = 0;
        for (Cube cube : cubes) {
            if (cube.getX() < 0 || cube.getY() < 0 || cube.getZ() < 0) {
                throw new IllegalArgumentException();
            }
            maxX = Math.max(maxX, cube.getX());
            maxY = Math.max(maxY, cube.getY());
            maxZ = Math.max(maxZ, cube.getZ());
        }

        this.sizeX = maxX + 3;
        this.sizeY = maxY + 3;
        this.sizeZ = maxZ + 3;

        this.gridContainer = new boolean[sizeX][sizeY][sizeZ];
    }

    public void floodFill() {
        Cube start = new Cube(-1, -1, -1);
        fillContainerWithCube(start);
        Queue<Cube> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Cube cube = queue.poll();
            Cube backNeighbour = cube.getBackNeighbour();
            fillIfEmpty(backNeighbour, queue);

            Cube frontNeighbour = cube.getFrontNeighbour();
            fillIfEmpty(frontNeighbour, queue);

            Cube leftNeighbour = cube.getLeftNeighbour();
            fillIfEmpty(leftNeighbour, queue);

            Cube rightNeighbour = cube.getRightNeighbour();
            fillIfEmpty(rightNeighbour, queue);

            Cube upNeighbour = cube.getUpNeighbour();
            fillIfEmpty(upNeighbour, queue);

            Cube downNeighbour = cube.getDownNeighbour();
            fillIfEmpty(downNeighbour, queue);
        }
    }

    private void fillIfEmpty(Cube cube, Queue<Cube> queue) {
        if (!isInContainer(cube) || containerFilledAlreadyAt(cube)) {
            return;
        }

        if (this.cubes.contains(cube)) {
            surfaceArea++;
        } else {
            fillContainerWithCube(cube);
            queue.add(cube);
        }
    }

    private boolean containerFilledAlreadyAt(Cube cube) {
        return gridContainer[cube.getX() + 1][cube.getY() + 1][cube.getZ() + 1];
    }

    private boolean isInContainer(Cube cube) {
        return  cube.getX() + 1 >= 0 && cube.getX() + 1 < sizeX &&
                cube.getY() + 1 >= 0 && cube.getY() + 1 < sizeY &&
                cube.getZ() + 1 >= 0 && cube.getZ() + 1 < sizeZ;
    }

    private void fillContainerWithCube(Cube cube) {
        gridContainer[cube.getX() + 1][cube.getY() + 1][cube.getZ() + 1] = true;
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }
}
