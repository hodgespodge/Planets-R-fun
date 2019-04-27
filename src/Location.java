/*
    
*/

public class Location {

    private double x, y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double get_x() {
        return this.x;
    }

    public double get_y() {
        return this.y;
    }

    public double get_distance_to_location(Location l) {
        Location n = new Location(this.get_x() - l.get_x(), this.get_y() - l.get_y());
        return Math.sqrt(n.get_x() * n.get_x() + n.get_y() * n.get_y());
    }

    public Location add(Vector v){
        return new Location(x + v.get_x(), y + v.get_y());
    }

    public Vector displacement_between_location(Location l) {
        /*
            inspired by a question that led to this internet post
            https://math.stackexchange.com/questions/645672/what-is-the-difference-between-a-point-and-a-vector
            If given a point (-3, 5) and (4, 7), what is the vector that represents from point 1 to point 2?
            4 - (-3), 7 - (5) -> (7, 2)
        */
        double displacement_x = l.get_x() - this.get_x();
        double displacement_y = l.get_y() - this.get_y();
        return new Vector(displacement_x, displacement_y);
    }
}
