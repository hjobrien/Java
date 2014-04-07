// Represents a line segment between two Points.
public class Line {
    private Point p1;
    private Point p2;
    
    // Constructs a new Line that contains the given two points.
    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }
    
    // Constructs a new Line that contains the given two points.
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    // Returns whether o refers to a Line object
    // with the same endpoints as this Line.
    public boolean equals(Object o) {
        Line other = (Line) o;
        return p1.equals(other.p1) && p1.equals(other.p2);
    }
    
    // Returns this Line's first endpoint.
    public Point getP1() {
        return p1;
    }
    
    // Returns this Line's second endpoint.
    public Point getP2() {
        return p2;
    }

    // Returns the slope of this Line.
    public double getSlope() {
        if (p1.getX() == p2.getX()) {
            throw new IllegalArgumentException("undefined slope");
        }
        
        return (double) (p2.getY() - p1.getY()) /
                        (p2.getX() - p1.getX());
    }

    // Returns true if the given point is colinear with this Line.
    public boolean isColinear(Point p) {
        // basic case: all points have same x or y value
        if ((p.getX() == this.p1.getX() &&
             p.getX() == this.p2.getX()) ||
            (p.getY() == this.p1.getY() &&
             p.getY() == this.p2.getY())) {
            return true;
        }
        
        // complex case: compare slopes
        double slope1 = (this.p1.getY() - p.getY()) /
                        (this.p1.getX() - p.getX());
        double slope2 = (this.p2.getY() - p.getY()) /
                        (this.p2.getX() - p.getX());
        return round(slope1, 4) == round(slope2, 4);
    }

    // Rounds the given value to 4 digits after the decimal.
    public static double round(double value, int places) {
        double pow10 = Math.pow(10, places);
        return Math.round(value * pow10) / pow10;
    }

    // Returns a String representation of this Line.
    public String toString() {
        return "[" + this.p1 + ", " + this.p2 + "]";
    }
}
