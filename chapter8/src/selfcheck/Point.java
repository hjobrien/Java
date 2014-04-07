import java.util.*;

// Represents points in 2D space.
public class Point {
    private int x;   // x-coordinate
    private int y;   // y-coordinate

    // Constructs a Point object at the origin, (0, 0).
    public Point() {
        this(0, 0);
    }

    // Constructs a Point object with the given x and y coordinates.
    public Point(int x, int y) {
        setLocation(x, y);
    }

    // Constructs a Point object with the same x and y
    // coordinates as the given Point.
    public Point(Point p) {
        this(p.x, p.y);   // call the (int, int) constructor
    }

    // Returns whether this Point has the same (x, y) values as
    // the given other Point object.
    public boolean equals(Object o) {
        Point other = (Point) o;
        return x == other.x && y == other.y;
    }

    // Returns the distance from this point to the given point.
    // given other point.
    public double distance(Point other) {
        int dx = x - other.x;
        int dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Returns the distance between this point and the
    // origin at (0, 0).
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Returns the distance between this point and the
    // origin at (0, 0).
    public double distanceFromOrigin2(Point other) {
        return distance(new Point(0, 0));
    }

    // Returns the "Manhattan (rectangular) distance" between
    // this point and the given other point.
    public double manhattanDistance(Point other) {
        int dx = x - other.x;
        int dy = y - other.y;
        return Math.abs(dx) + Math.abs(dy);
    }

    // Returns the x-coordinate of this Point.
    public int getX() {
        return x;
    }

    // Returns the y-coordinate of this Point.
    public int getY() {
        return y;
    }

    // Returns whether the given three points are colinear.
    public boolean isColinear(Point p1, Point p2) {
        // basic case: all points have same x or y value
        if ((x == p1.x && x == p2.x) ||
            (y == p1.y && y == p2.y)) {
            return true;
        }

        // complex case: compare slopes
        double slope1 = (p1.y - y) / (p1.x - x);
        double slope2 = (p2.y - y) / (p2.x - x);
        return round(slope1, 4) == round(slope2, 4);
    }

    // Returns true if the given point lines up vertically
    // with this point (if they have the same x value).
    public boolean isVertical(Point p) {
        return x == p.x;
    }

    // Returns the slope of the line between this point and
    // the given other point.
    public double slope(Point other) {
        if (x == other.x) {
            throw new IllegalArgumentException("undefined");
        }

        return (other.y - y) / (other.x - x);
    }

    // Rounds the given value to 4 digits after the decimal.
    public static double round(double value, int places) {
        double pow10 = Math.pow(10, places);
        return Math.round(value * pow10) / pow10;
    }

    // Sets this Point's (x, y) location to the given values.
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Sets this Point's x coordinate to the given value.
    public void setX(int newX) {
        x = newX;
    }

    // Sets this Point's y coordinate to the given value.
    public void setY(int newY) {
        y = newY;
    }

    // Returns a String representation of this point.
    public String toString() {
        return "java.awt.Point[x=" + x + ",y=" + y + "]";
    }
}
