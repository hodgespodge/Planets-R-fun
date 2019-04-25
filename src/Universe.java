import java.util.ArrayList;
import java.util.List;

public class Universe {

    // constants
    private static double G = 0.0000000000667408; // univeral gravitational constant
    private static List<Planet> Planets;
    private static List<Particle> updated_particles;

    public Universe() {
        Planets = new ArrayList<>();
        updated_particles = new ArrayList<>();

    }

    public void updatePlanets(){

        //UPDATE Planets HERE
    }

    public void addPlanet(Planet planet){
        Planets.add(planet);
    }

    public boolean removePlanet(Planet planet){
        return Planets.remove(planet);
    }

    public static double get_universal_gravitational_constant(){
        return G;
    }

    public static List<Planet> getPlanets() {
        return Planets;
    }
}
