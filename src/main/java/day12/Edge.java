package day12;

import java.awt.*;
import java.util.ArrayList;

public class Edge<T> {

    private final T data;
    private final Point point;
    private boolean visited;
    private java.util.List<Edge<T>> neighbours = new ArrayList<>();
    public int level = -1;
    public Edge<T> predecessor;

    public Edge(T data, Point point, boolean visited) {
        this.data = data;
        this.point = point;
        this.visited = visited;
    }

    public T getData() {
        return data;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public java.util.List<Edge<T>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(java.util.List<Edge<T>> neighbours) {
        this.neighbours = neighbours;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Edge<T> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Edge<T> predecessor) {
        this.predecessor = predecessor;
    }
}
