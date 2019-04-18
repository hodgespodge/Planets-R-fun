/*
    Description: 
        Immutable. 
*/ 

public class Point {
    
    private double x, y;
    
    public Point(x, y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return "x = " + this.get_x() + " y = " + this.get_y() + ".";
    }

    public double get_x() {
        return this.x;
    }

    public double get_y() {
        return this.y;
    }
    
    public double get_distance_to_point(Point p) {
        Point n = new Point(this.get_x() - p.get_x(), this.get_y() - p.get_y());
        return Math.sqrt(n.get_x() * n.get_x() + n.get_y() * n.get_y());
    }
    
    public Vector displacement_between_points(Point p) {
        // inspired by a question that led to this internet post 
        // https://math.stackexchange.com/questions/645672/what-is-the-difference-between-a-point-and-a-vector
        /*
            If given a point (-3, 5) and (4, 7), what is the vector that represents from point 1 to point 2?
            4 - (-3), 7 - (5) -> (7, 2)
        */
        double disp_x = p.get_x() - this.get_x();
        double disp_y = p.get_y() - this.get_y();
        return new Vector(disp_x, disp_y);
    }
}