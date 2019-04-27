/*
    
*/

public class Location {

    private double x, y;

    public Location(double x, double y) {
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

    // need a method for determining the distance from this location to another.
    public double get_distance_to_location(Location l) {
        Location n = new Location(this.get_x() - l.get_x(), this.get_y() - l.get_y());
        return Math.sqrt(n.get_x() * n.get_x() + n.get_y() * n.get_y());
    }

    public Location add(Location location){
        return new Location(x+location.get_x(), y+location.get_y());
    }

    public Vector displacement_between_location(Location l) {
        // inspired by a question that led to this internet post 
        // https://math.stackexchange.com/questions/645672/what-is-the-difference-between-a-point-and-a-vector
        /*
            If given a point (-3, 5) and (4, 7), what is the vector that represents from point 1 to point 2?
            4 - (-3), 7 - (5) -> (7, 2)
        */
        double disp_x = l.get_x() - this.get_x();
        double disp_y = l.get_y() - this.get_y();
        return new Vector(disp_x, disp_y);
    }
}
