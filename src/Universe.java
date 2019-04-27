import java.util.ArrayList;
import java.util.List;

public class Universe {

    private static Universe instance; // so we believe there is only  one universe in existence sooooo

    // constants associated with the universe
    private double G = 0.0000000000667408; // universal gravitational constant
    private ArrayList<Particle> particles; // so this will store anything that extends the particle class. So...

    private Universe() { // nobody should be able to create more universes
        this.particles = new ArrayList<>();
    }

    static { // constructs the instance at class loading time
        instance = new Universe();
    }

    public static Universe getInstance() {
        return instance;
    }

    // I'm thinking more of this. Here we take anything that is a particle list.
    public void addParticle(Particle particle) {
        this.particles.add(particle);
    }

    // not sure exactly how the mechanics of this will work yet. Could it be that a reference to a particle is
    // provided then the particle list is searched until it is found, then it is deleted.
    public void removeParticle() {
        System.out.println("Universe.removeParticle() HAS NOT BEEN IMPLEMENTED YET.");
    }

    public void update(){

        //System.out.println("Updating Universe ");

        for(Particle particle: particles){
            particle.calculate_next_update();
        }

        //System.out.println("Calling set_next_update ");

        for(Particle particle: particles){
            particle.set_next_update();
        }

        //particles;
    }

    public double get_universal_gravitational_constant(){
        return this.G;
    }

    public ArrayList<Particle> getParticles() {
        return this.particles;
    }

}
