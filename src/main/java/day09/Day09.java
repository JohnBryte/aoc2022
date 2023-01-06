package day09;

import utils.Day;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day09 extends Day {
    public Day09(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        Rope rope = new Rope();
        Knot head = new Knot(new Point2D.Double(0, 0), 0);
        Knot tail = new Knot(new Point2D.Double(0, 0), 1);
        rope.rope.put(head.index, head);
        rope.rope.put(tail.index, tail);
        for (String line : input) {
            String[] moves = line.split(" ");
            for (int i = Integer.parseInt(moves[1]); i > 0; i--) {
                rope.moveRope(moves[0]);
            }
        }
        return String.valueOf(rope.tailVisited.size());
    }

    @Override
    public String solvePart2() {
        Rope rope = new Rope();
        Knot head = new Knot(new Point2D.Double(0, 0), 0);
        Knot knot1 = new Knot(new Point2D.Double(0, 0), 1);
        Knot knot2 = new Knot(new Point2D.Double(0, 0), 2);
        Knot knot3 = new Knot(new Point2D.Double(0, 0), 3);
        Knot knot4 = new Knot(new Point2D.Double(0, 0), 4);
        Knot knot5 = new Knot(new Point2D.Double(0, 0), 5);
        Knot knot6 = new Knot(new Point2D.Double(0, 0), 6);
        Knot knot7 = new Knot(new Point2D.Double(0, 0), 7);
        Knot knot8 = new Knot(new Point2D.Double(0, 0), 8);
        Knot tail = new Knot(new Point2D.Double(0, 0), 9);
        rope.rope.put(head.index, head);
        rope.rope.put(knot1.index, knot1);
        rope.rope.put(knot2.index, knot2);
        rope.rope.put(knot3.index, knot3);
        rope.rope.put(knot4.index, knot4);
        rope.rope.put(knot5.index, knot5);
        rope.rope.put(knot6.index, knot6);
        rope.rope.put(knot7.index, knot7);
        rope.rope.put(knot8.index, knot8);
        rope.rope.put(tail.index, tail);
        for (String line : input) {
            String[] moves = line.split(" ");
            for (int i = Integer.parseInt(moves[1]); i > 0; i--) {
                rope.moveRope(moves[0]);
            }
        }
        return String.valueOf(rope.tailVisited.size());
    }
}
