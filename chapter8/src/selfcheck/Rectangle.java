// Represents a 2-dimensional rectangular region.
public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;
    
    // Constructs a new Rectangle whose top-left corner is specified by the
    // given coordinates and with the given width and height.
    public Rectangle(int x, int y, int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    // Constructs a new Rectangle whose top-left corner is specified by the 
    // given Point and with the given width and height.
    public Rectangle(Point p, int width, int height) {
        this(p.getX(), p.getY(), width, height);
    }
    
    // Returns whether the given coordinates lie inside this Rectangle.
    public boolean contains(int x, int y) {
        return this.x <= x && x < this.x + this.width &&
               this.y <= y && y < this.y + this.height;
    }
    
    // Returns whether the given point lies inside this Rectangle.
    public boolean contains(Point p) {
        return this.contains(p.getX(), p.getY());
    }
    
    // Returns whether o is a Rectangle with the same x/y
    // coordinates, width, and height as this Rectangle.
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Rectangle other = (Rectangle) o;
        return other.x == this.x && other.y == this.y &&
               other.width == this.width && other.height == this.height;
    }
    
    // Returns this Rectangle's height.
    public int getHeight() {
        return this.height;
    }
    
    // Returns this Rectangle's width.
    public int getWidth() {
        return this.width;
    }
    
    // Returns this Rectangle's x coordinate.
    public int getX() {
        return this.x;
    }
    
    // Returns this Rectangle's y coordinate.
    public int getY() {
        return this.y;
    }
    
    // Returns a new Rectangle that represents the largest rectangular region 
    // completely contained within both this rectangle and the given other 
    // rectangle.  If the rectangles do not intersect at all, returns a rectangle
    // whose width and height are both 0.
    public Rectangle intersection(Rectangle rect) {
        int left = Math.max(this.x, rect.x);
        int top = Math.max(this.y, rect.y);
        int right = Math.min(this.x + this.width, rect.x + rect.width);
        int bottom = Math.min(this.y + this.height, rect.y + rect.height);
        int width = Math.max(0, right - left);
        int height = Math.max(0, bottom - top);
        
        return new Rectangle(left, top, width, height);
    }
    
    // Returns a String representation of this Rectangle, such as 
    // "Rectangle[x=1,y=2,width=3,height=4]".
    public String toString() {
        return "Rectangle[x=" + this.x + ",y=" + this.y +
               ",width=" + this.width + ",height=" + this.height + "]";
    }
    
    // Returns a new Rectangle that represents the tightest bounding box 
    // that contains both this rectangle and the other rectangle.
    public Rectangle union(Rectangle rect) {
        int left = Math.min(this.x, rect.x);
        int top = Math.min(this.y, rect.y);
        int right = Math.max(this.x + this.width, rect.x + rect.width);
        int bottom = Math.max(this.y + this.height, rect.y + rect.height);
        
        return new Rectangle(left, top, right - left, bottom - top);
    }
}