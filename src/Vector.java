/*
    Description: 
        Instances of this class are to represent a vector object that gives magnitude and direction. 
        The representation is done using doubles in blocks. 
*/ 


public class Vector {

    private double x, y;
    private double length; // so that it doesnt have to be computed continuously 


    public Vector(double x, double y) {
        this.x = x;
        this.y = y; // once these are set, they cannot be changed. No setters.
        this.length = Math.sqrt(this.get_x() * this.get_x() + this.get_y() * this.get_y()); // compute once since we are immutable.
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

    public double get_length() {
        return this.length;
    }
    
    /*
        Vector Operations: 
            - Addition
            - Subtraction
            - Scalar Multiplication
            - Length / Magnitude 
            - Dot product. 
            - Cross product
            
        Other:
            - Get the normalized vector
    */
    
    public Vector add(Vector v) {
        double new_x = get_x() + v.get_x();
        double new_y = get_y() + v.get_y();
        return new Vector(new_x, new_y);
    }

    public Vector subtract(Vector v) {
        double new_x = this.get_x() - v.get_x();
        double new_y = this.get_y() - v.get_y();
        return new Vector(new_x, new_y);
    }

    public Vector scale(double scalar) {
        return new Vector(this.get_x() * scalar, this.get_y() * scalar);
    }

    public Vector get_normalized_vector() {
        double new_x = this.get_x() / this.get_length();
        double new_y = this.get_y() / this.get_length();
        return new Vector(new_x, new_y);
    }
    
    // not implemented
    public double dot_product(Vector v) {
        return 0.0;
    }
    
    // not implemented. But this method doesnt make sense in a 2D space. 
    public Vector cross_product(Vector v) {
        return new Vector(0, 0); 
    }
}
