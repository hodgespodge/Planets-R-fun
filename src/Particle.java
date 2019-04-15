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

    // coould probably change the name to something that makes more sense
    public Vector get_force_between_particle(Particle p) {
        Vector r_vector =
    }

}
