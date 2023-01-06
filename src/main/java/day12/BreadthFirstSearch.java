package day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch<T> {

    private final Edge<T> startEdge;
    private final boolean part2;

    public BreadthFirstSearch(Edge<T> startEdge, boolean part2) {
        this.startEdge = startEdge;
        this.part2 = part2;
    }

    public Edge<T> traverse() {
        Queue<Edge<T>> queue = new LinkedList<>();
        queue.add(startEdge);
        startEdge.setLevel(0);

        while (!queue.isEmpty()) {
            Edge<T> current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                if (part2) {
                    if (current.getData().equals('a') || current.getData().equals('S')) {
                        return current;
                    }
                } else {
                    if (current.getData().equals('E')) {
                        return current;
                    }
                }
                List<Edge<T>> neighbours = current.getNeighbours();
                for (Edge<T> edge : neighbours) {
                    if (!edge.isVisited() && edge.getLevel() == -1) {
                        edge.setLevel(current.getLevel() + 1);
                        edge.setPredecessor(current);
                    }
                }
                queue.addAll(neighbours);
            }
        }
        return null;
    }
}
