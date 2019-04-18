public class Location {

    private double x_1, x_2;

    public Location(double x, double y) {
        this.x_1 = x;
        this.x_2 = y;
    }

    public String toString() {
        return "x_1 = " + this.get_x() + " y = " + this.get_y() + ".";
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

    public Location add(Location l) {
        double new_x_1 = get_x_1() + l.get_x_1();
        double new_x_2 = get_x_2() + l.get_x_2();
        return new Location(new_x_1, new_x_2);
    }

    // static functions
}
