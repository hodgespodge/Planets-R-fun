import java.awt.*;

public class Planet extends Particle{

    private double radius;
    private Color color;

    public Planet(double mass, Location location, Vector velocity,double radius,Color color) {
        super(mass, location, velocity);
        this.color = color;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(Color color){
        this.color = color;
    }

}
