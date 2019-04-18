import java.util.ArrayList;
import java.util.List;

public class Universe {

    // constants
    private static double G = 0.0000000000667408; // univeral gravitational constant
    private static List<Particle> particles = new ArrayList<>();
    private static List<Particle> updated_particles = new ArrayList<>();
    
    public static double get_universal_gravitational_constant() {
        return G;
    }

    public static List<Particle> get_particles() {
        return particles;
    }
}
