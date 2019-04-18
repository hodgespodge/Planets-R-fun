import java.util.List;

public class Particle extends Universe {

    // Constants

    private double mass;
    private Location location;
    private Vector velocity;
    private Vector net_force;
    private Vector new_velocity;
    private Location new_location;

    public Particle(double mass, Location location, Vector velocity) {
        this.mass = mass;
        this.velocity = velocity;
        this.location = location;
        this.net_force = null; // function to  calculate net force goes here
    }

    public double get_mass() {
        return mass;
    }

    public Location get_location() {
        return location;
    }

    public Vector get_velocity() {
        return velocity;
    }

    public Vector get_net_force() {
        return net_force;
    }

    public Vector get_new_velocity() {
        return new_velocity;
    }

    public Location get_new_location() {
        return new_location;
    }

    public double get_distance_to_particle(Particle p) {
        return this.get_location().get_distance_to_location(p.get_location());
    }

    public Vector get_force_between_particle(Particle p) {
        Vector r_unit_vector = this.get_direction_to_particle(p);
        Double temp = ((-1) * get_universal_gravitational_constant() * this.mass * p.mass)
                / (this.get_distance_to_particle(p) * this.get_distance_to_particle(p));
        Vector force_vector = r_unit_vector.scale(temp);
        return force_vector;
    }

    public Vector get_direction_to_particle(Particle p) {
        double x_difference = p.get_location().get_x() - this.get_location().get_x();
        double y_difference = p.get_location().get_y() - this.get_location().get_y();
        Vector r_vector = new Vector(x_difference, y_difference);
        return r_vector.get_normalized_vector();
    }

    public Vector get_net_force_on_particle() {
        Vector vector_sum = new Vector(0, 0);
        List<Particle> particles = get_particles();
        for (Particle p : particles) {
            if (p == this) {
                continue;
            }
            vector_sum = vector_sum.add(this.get_force_between_particle(p));
        }
        return vector_sum;
    }

    public void calculate_next_update() {
        // I really dislike this function, maybe should fix later.
        // we might be using more memory then we need...
        double time_step = get_time_step();
        Vector acceleration = this.get_net_force().scale(this.mass);
        Vector change_in_velocity = acceleration.scale(time_step / 2.0);
        Vector average_velocity = this.get_velocity().subtract(change_in_velocity);
        Vector temp_distance_travelled = average_velocity.scale(time_step);
        Location distance_travelled = new Location(temp_distance_travelled.get_x_1(),
                temp_distance_travelled.get_x_2());
        this.new_location = this.get_location().add(distance_travelled);
        this.new_velocity = average_velocity; // these last tow lines hsould really use setters.
    }

    public void set_next_update() {
        this.velocity = this.new_velocity;
        this.location = this.new_location;
        this.new_velocity = null;
        this.new_location = null;
        this.net_force = get_net_force();
        // do we need setters?
    }
}
