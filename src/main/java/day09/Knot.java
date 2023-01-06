package day09;

import java.awt.geom.Point2D;

public class Knot {
    public Point2D.Double currentPosition;
    public Point2D.Double previousPosition = new Point2D.Double();
    public Integer index;

    public Knot(Point2D.Double currentPosition, Integer index) {
        this.currentPosition = currentPosition;
        this.index = index;
    }

    public void moveHead(String direction) {
        double x = currentPosition.getX();
        double y = currentPosition.getY();
        previousPosition.setLocation(x, y);
        switch (direction) {
            case "R":
                x++;
                break;
            case "L":
                x--;
                break;
            case "U":
                y--;
                break;
            case "D":
                y++;
                break;
        }
        currentPosition.setLocation(x, y);
    }

}
