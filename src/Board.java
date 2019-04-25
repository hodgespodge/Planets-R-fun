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
    private final int B_HEIGHT = 950;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image star;
    private Thread animator;
    private int x, y;

    //private ArrayList<Planet> planets;
    private Universe universe;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/resources/earth.png");
        star = ii.getImage();


    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        //loadImage();

        //planets = new ArrayList<>();

        universe = new Universe();

        universe.addPlanet(new Planet(100, new Location(0, 0), new Vector(0, 0),20.0,Color.BLUE));
        universe.addPlanet(new Planet(75, new Location(200, 200), new Vector(100, 0), 70.0,Color.MAGENTA));

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

        //g.drawImage(star, x, y, this);

        for(Planet planet : universe.getPlanets()){

            g.setColor(planet.getColor());
            g.fillOval((int)planet.get_location().get_x(),(int)planet.get_location().get_y(),(int)planet.getRadius(),(int)planet.getRadius());
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle() {

        /**
        x += 1;
        y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }**/
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