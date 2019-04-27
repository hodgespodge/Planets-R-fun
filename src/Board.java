import org.w3c.dom.css.RGBColor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel
        implements Runnable {

    private final int B_WIDTH = 950;
    private final int B_HEIGHT = 600;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image Earth;
    private Thread animator;
    private int x, y;

    //private ArrayList<Planet> planets;
    private Universe universe;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/resources/earth.png");
        Earth = ii.getImage();


    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        //loadImage();
        //planets = new ArrayList<>();

        universe = Universe.getInstance();

        //universe.addParticle(new Planet(1, new Location(0, 0), new Vector(1, 1),10.0,Color.BLUE));
        //universe.addParticle(new Planet(1, new Location(20, 20), new Vector(1, 1), 10.0,Color.ORANGE));
        //universe.addParticle(new Planet(1, new Location(700, 70), new Vector(1, 1), 10.0,Color.MAGENTA));
        //universe.addParticle(new Planet(1, new Location(500, 200), new Vector(2, 1), 10.0,Color.RED));
        universe.addParticle(new Planet(1000000, new Location(550, 300), new Vector(0.1, -0.3), 50.0,Color.YELLOW));
        //universe.addParticle(new Planet(1, new Location(50, 50), new Vector(1, 1),10.0,Color.BLUE));
        //universe.addParticle(new Planet(1, new Location(51, 49), new Vector(1, 1), 10.0,Color.ORANGE));
        universe.addParticle(new Planet(1000000, new Location(500, 300), new Vector(0.1, 0.3), 50.0,Color.YELLOW));
        //universe.addParticle(new Planet(1, new Location(57, 48), new Vector(2, 1), 10.0,Color.RED));
        //universe.addParticle(new Planet(1, new Location(56, 45), new Vector(1, 1), 10.0,Color.GRAY));
        //universe.addParticle(new Planet(1000000000, new Location(B_WIDTH/2, B_HEIGHT/2), new Vector(0, 0), 50.0,Color.YELLOW));

        x = INITIAL_X;
        y = INITIAL_Y;
    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawPlanets(g);
    }

    private void drawPlanets(Graphics g) {

        //System.out.println("Drawing Planets ");

        //g.drawImage(star, x, y, this);

        for(Particle particle : universe.getInstance().getParticles()){

            g.setColor(particle.getColor());
            g.fillOval((int)particle.get_location().get_x(),(int)particle.get_location().get_y(),(int)particle.getRadius(),(int)particle.getRadius());
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle() {

        Universe.getInstance().update();
        //Update the list of particles here

    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}