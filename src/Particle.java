public class Particle extends Universe {

    // Constants

    private double mass;
    private Location location;
    private Vector velocity;
    private Vector net_force;
    private Vector new_net_force;
    private Vector new_velocity;
    private Location new_location;

    public Particle(double mass, Location location, Vector velocity) {
        this.mass = mass;
        this.velocity = velocity;
        this.location = location;


        this.net_force = null; // function to  calculate net force goes here

    }


    // getters

    public Location get_location() {
        return this.location;
    }


    // operations

    public double get_distance_to_particle(Particle p) {
        return this.get_location().get_distance_to_location(p.get_location());
    }

    public Vector get_force_between_particle(Particle p) {
        final double G = 0.0000000000667408; // univeral gravitational constant
        Vector r_unit_vector = this.get_direction_to_particle(p);
        Double temp = ((-1) * G * this.mass * p.mass) / (1);
        Vector force_vector = r_unit_vector.scale(temp);
        System.out.println(force_vector.get_x_1() + " " + force_vector.get_x_2());
        return force_vector;
    }

    public Vector get_direction_to_particle(Particle p) {
        double x_difference = p.get_location().get_x() - this.get_location().get_x();
        double y_difference = p.get_location().get_y() - this.get_location().get_y();
        Vector r_vector = new Vector(x_difference, y_difference);
        return r_vector.get_normalized_vector();
    }
}
