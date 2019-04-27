/*
    Description:
        The idea behind this class is that all object that contains mass will be represented by an instance
        of the Particle class... so you can think of Particle as being used to do the mathemical modeling 
        of whats going on in the static Universe class. Objects such as asteroid, planets, or other blobs will
        have their own classes that EXTEND the Particle class. 
*/ 

import java.awt.*;
import java.util.List;

public class Particle implements NewtonianSolid{

    private double mass; // object have mass, a location, and velocity. They also have a netforce 
    private Location location;
    private Vector velocity;
    private Vector net_force;

    private Vector new_velocity; // these new things can be thought as temporary. When the universe calls to update where every
                                 // particle is, this keeps track of the new info without impacting other objects that havent completed their cycle.
    private Location new_location;

    public Particle(double mass, Location location, Vector velocity) {
        this.mass = mass;
        this.velocity = velocity;
        this.location = location;
        /**
        if (is_time_paused()) { // if the time in the universe is paused, well we should wait until its unpaused to update the net force on the particle    
            this.net_force = null;
        } else {
            // if simulation is not paused then use the current conditions of the universe to update the particle.
            this.set_net_force(this.get_net_force_on_particle());
        }**/
    }
    
    public void set_net_force(Vector f) {
        this.net_force = f;
    }
    
    public void set_velocity(Vector v) {
        this.velocity = new Velocity(v.get_x_1(), v.get_x_2());
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
        Double temp = ((-1) * Universe.getInstance().get_universal_gravitational_constant() * this.mass * p.mass)
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

    public double getRadius() {
        return mass;
    }

    public Color getColor() {
        return Color.WHITE;
    }

    /**
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
    }**/

    /**
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
    }**/

    public void set_next_update() {
        this.velocity = this.new_velocity;
        this.location = this.new_location;
        this.new_velocity = null;
        this.new_location = null;
        this.net_force = get_net_force();
        // do we need setters?
    }
}
