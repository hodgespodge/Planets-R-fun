public class Main {

    public static void main(String[] args) {
        Particle p1 = new Particle(1000000, new Location(0, 0), new Vector(0, 0));
        Particle p2 = new Particle(1, new Location(5, 0), new Vector(100, 0));
        p1.get_force_between_particle(p2);
    }
}
