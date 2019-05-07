import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

public class Board extends JPanel implements Runnable,MouseListener{

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

    }

    private void initBoard() {


        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        addMouseListener(this);

        universe = Universe.getInstance();

        //universe.addParticle(new Planet(1, new Location(0, 0), new Vector(1, 1),10.0,Color.BLUE));
        //universe.addParticle(new Planet(1, new Location(20, 20), new Vector(1, 1), 10.0,Color.ORANGE));

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

        for(Particle particle : universe.getInstance().getParticles()){

            g.setColor(particle.getColor());
            g.fillOval((int)particle.get_location().get_x(),(int)particle.get_location().get_y(),(int)particle.getRadius(),(int)particle.getRadius());
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle() {

        Universe.getInstance().setGravityScale(BottomPanel.getGravity());
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

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");

        if (SwingUtilities.isLeftMouseButton(e)){
            double radius = 50;
            Universe.getInstance().addParticle(new Planet(BottomPanel.getMass(), new Location(e.getX(), e.getY()), new Vector(BottomPanel.getXValue(), BottomPanel.getYValue()), BottomPanel.getRadius(),Color.YELLOW));
        }
        else{
            ArrayList<Particle> myParticles;
            myParticles = Universe.getInstance().getParticles();

            for (int i = 0; i < myParticles.size(); i++) {
                if (myParticles.get(i).contains(e.getPoint())) {
                    myParticles.remove(i);
                }
            }
        }



    }

}