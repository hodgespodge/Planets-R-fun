public class Velocity extends Vector {
    
    public Velocity(double x, double y) {
        super(x, y);
    }
    
    public double get_velocity_in_x_direction() {
        return get_x();
    }
    
    public double get_velocity_in_y_direction() {
        return get_y();
    }
    
    public double get_speed() {
        return get_length();
    }
    
    public Vector get_direction_of_travel() {
        return get_normalized_vector();
    }
    
    
}