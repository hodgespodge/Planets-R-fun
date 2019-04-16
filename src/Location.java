public class Location {

    private double x_1, x_2;

    public Location(double x, double y) {
        this.x_1 = x;
        this.x_2 = y;
    }

    public double get_x() {
        return this.x_1;
    }

    public double get_y() {
        return this.x_2;
    }

    // need a method for determining the distance from this location to another.
    public double get_distance_to_location(Location l) {
        Location n = new Location(this.get_x() - l.get_x(), this.get_y() - l.get_y());
        return Math.sqrt(n.get_x() * n.get_x() + n.get_y() * n.get_y());
    }


    // static functions
}