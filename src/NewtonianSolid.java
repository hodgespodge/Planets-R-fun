import java.awt.*;

public interface NewtonianSolid {
    public void set_net_force(Vector f);

    public void set_velocity(Vector v);

    public double get_mass();

    public Location get_location();

    public Vector get_velocity();

    public Vector get_net_force();

    public Vector get_new_velocity();

    public Location get_new_location();

    public double get_distance_to_particle(Particle p) ;
    public Vector get_force_between_particle(Particle p);

    public Vector get_direction_to_particle(Particle p);

    public double getRadius();
    public Color getColor();
}
