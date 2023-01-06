package day12;

import utils.Day;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day12 extends Day {
    List<Edge<Character>> allEdges = new ArrayList<>();

    public Day12(List<String> input) {
        super(input);

    }

    @Override
    public String solvePart1() {
        allEdges = new ArrayList<>();
        int idx = getIdxOfStartEdge('S');
        setNeighbours(allEdges, "SabcdefghijklmnopqrstuvwxyzE");
        Edge<Character> root = allEdges.get(idx);
        BreadthFirstSearch<Character> bfs = new BreadthFirstSearch<>(root, false);
        Edge<Character> fin = bfs.traverse();
        return String.valueOf(fin.getLevel());
    }

    @Override
    public String solvePart2() {
        allEdges = new ArrayList<>();
        int idx = getIdxOfStartEdge('E');
        setNeighbours(allEdges, "EzyxwvutsrqponmlkjihgfedcbaS");
        Edge<Character> root = allEdges.get(idx);
        BreadthFirstSearch<Character> bfs = new BreadthFirstSearch<>(root, true);
        Edge<Character> fin = bfs.traverse();
        return String.valueOf(fin.getLevel());
    }

    private int getIdxOfStartEdge(Character startSymbol) {
        int idx = 0;
        int counter = 0;
        for (int row = 0; row < input.size(); row ++) {
            for (int col = 0; col < input.get(0).length(); col++) {
                Edge<Character> edge = new Edge<>(input.get(row).charAt(col), new Point(col, row), false);
                if (input.get(row).charAt(col) == startSymbol) {
                    idx = counter;
                }
                allEdges.add(edge);
                counter++;
            }
        }
        return idx;
    }

    private void setNeighbours(List<Edge<Character>> allEdges, String height) {
        Character startSymbol = height.charAt(0);
        Character endSymbol = height.charAt(height.length() - 1);
        for (Edge<Character> edge : allEdges) {
            if (edge.getData() == endSymbol) {
                continue;
            }
            List<Edge<Character>> neighbours = new ArrayList<>();
            int edgeHeight = height.indexOf(edge.getData());
            if (edge.getData() == startSymbol) {
                edgeHeight = height.indexOf(startSymbol) + 1;
            }

            int xCurrentEdge = edge.getPoint().x;
            int yCurrentEdge = edge.getPoint().y;

            for (Edge<Character> possibleNeighbour : allEdges) {
                if (possibleNeighbour.getPoint() != edge.getPoint()) {
                    int xNeighbourEdge = possibleNeighbour.getPoint().x;
                    int yNeighbourEdge = possibleNeighbour.getPoint().y;
                    if (xNeighbourEdge == xCurrentEdge - 1 &&  yNeighbourEdge == yCurrentEdge ||
                            xNeighbourEdge == xCurrentEdge + 1 &&  yNeighbourEdge == yCurrentEdge ||
                            xNeighbourEdge == xCurrentEdge &&  yNeighbourEdge == yCurrentEdge + 1 ||
                            xNeighbourEdge == xCurrentEdge &&  yNeighbourEdge == yCurrentEdge - 1) {
                        Character data = possibleNeighbour.getData();
                        int possibleNeighbourHeight = height.indexOf(data);
                        if (data == endSymbol) {
                            possibleNeighbourHeight = height.indexOf(endSymbol) - 1;
                        } else if (data == startSymbol) {
                            possibleNeighbourHeight = height.indexOf(startSymbol) + 1;
                        }

                        if (possibleNeighbourHeight <= edgeHeight || ((edgeHeight + 1) == possibleNeighbourHeight)) {
                            neighbours.add(possibleNeighbour);
                        }
                    }
                }
            }
            edge.setNeighbours(neighbours);
        }
    }

    private void printMap(Edge<Character> fin) {
        List<Character> path = new ArrayList<>();
        path.add('E');
        List<Edge<Character>> edgePath = new ArrayList<>();
        edgePath.add(fin);
        Edge<Character> predecessor = fin.getPredecessor();
        while (predecessor != null) {
            path.add(predecessor.getData());
            edgePath.add(predecessor);
            predecessor = predecessor.getPredecessor();
        }

        Collections.reverse(edgePath);
        for (int row = 0; row < input.size(); row ++) {
            StringBuilder mapRow = new StringBuilder();
            for (int col = 0; col < input.get(0).length(); col++) {
                Edge<Character> inPath = isInPath(col, row, edgePath);
                if (inPath != null) {
                    mapRow.append(String.format("%1$" + 3 + "s", edgePath.indexOf(inPath)).replace(' ', '0'));
                    mapRow.append("(").append(input.get(row).charAt(col)).append(")|");
                } else {
                    mapRow.append("   ").append(input.get(row).charAt(col)).append("  |");
                }
            }
            System.out.println(mapRow);
        }
    }

    private Edge<Character> isInPath(int col, int row, List<Edge<Character>> edgePath) {
        for (Edge<Character> edge : edgePath) {
            if (edge.getPoint().x == col && edge.getPoint().y == row) {
                return edge;
            }
        }
        return null;
    }
}
