package day09;

import java.awt.geom.Point2D;
import java.util.*;

public class Rope {
    public Map<Integer, Knot> rope = new HashMap<>();
    public Set<Point2D.Double> tailVisited = new HashSet<>();
    public void moveRope(String direction) {
        for (int i = 0; i < rope.size(); i++) {
            if (i == 0) {
                rope.get(i).moveHead(direction);
            } else {
                Knot previousKnot = rope.get(i - 1);
                Knot currentKnot = rope.get(i);
                if (previousKnot.currentPosition.distance(currentKnot.currentPosition) >= 2) {

                    double dx = previousKnot.currentPosition.getX() - currentKnot.currentPosition.getX();
                    double dy = previousKnot.currentPosition.getY() - currentKnot.currentPosition.getY();

                    int x = dx < 0 ? - 1 : dx > 0 ? 1 : 0;
                    int y = dy < 0 ? - 1 : dy > 0 ? 1 : 0;
                    currentKnot.currentPosition.setLocation(currentKnot.currentPosition.getX() + x, currentKnot.currentPosition.getY() + y);
                } else {
                    break;
                }
            }
        }
        tailVisited.add(new Point2D.Double(rope.get(rope.size() - 1).currentPosition.getX(), rope.get(rope.size() - 1).currentPosition.getY()));
    }
}
