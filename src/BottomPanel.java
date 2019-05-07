    
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BottomPanel extends JPanel{

    static JSlider x;
    static JSlider y;
    static JSlider mass;
    static JSlider radius;
    static JSlider gravity;

    BottomPanel(LayoutManager layout) {
        setLayout(layout);
        repaint();
        run();
    }

    private void run() {

        setBackground(Color.LIGHT_GRAY);

        JLabel xLabel = new JLabel("Velocity along x-axis:");
        JLabel yLabel = new JLabel("Velocity along y-axis:");
        JLabel massLabel = new JLabel("Mass:");
        JLabel radiusLabel = new JLabel("Radius:");
        JLabel gravityLabel = new JLabel("Gravity (automatically set to universal gravitational constant of 0.0000000000667408):");

        x = new JSlider(-10, 10, 0);
        y = new JSlider(-10, 10, 0);
        mass = new JSlider(0, 1000000, 500000);
        radius = new JSlider(0, 200, 100);
        gravity = new JSlider(-5, 5, 0);

        x.setPaintTrack(true);
        x.setPaintTicks(true);
        x.setPaintLabels(true);
        x.setMajorTickSpacing(5);
        x.setMinorTickSpacing(1);
        y.setPaintTrack(true);
        y.setPaintTicks(true);
        y.setPaintLabels(true);
        y.setMajorTickSpacing(5);
        y.setMinorTickSpacing(1);
        mass.setPaintTrack(true);
        mass.setPaintTicks(true);
        mass.setPaintLabels(true);
        mass.setMajorTickSpacing(250000);
        mass.setMinorTickSpacing(50000);
        radius.setPaintTrack(true);
        radius.setPaintTicks(true);
        radius.setPaintLabels(true);
        radius.setMajorTickSpacing(50);
        radius.setMinorTickSpacing(10);
        gravity.setPaintTrack(true);
        gravity.setPaintTicks(true);
        gravity.setPaintLabels(true);
        gravity.setMajorTickSpacing(5);
        gravity.setMinorTickSpacing(1);

        add(xLabel);
        add(x);
        add(yLabel);
        add(y);
        add(massLabel);
        add(mass);
        add(radiusLabel);
        add(radius);
        add(gravityLabel);
        add(gravity);
    }

    public static double getXValue() {
        return Double.valueOf(x.getValue());
    }

    public static double getYValue() {
        return Double.valueOf(y.getValue());
    }

    public static double getMass() {
        return Double.valueOf(mass.getValue());
    }

    public static double getRadius() {
        return Double.valueOf(radius.getValue());
    }

    public static double getGravity() {
        double grav = Double.valueOf(gravity.getValue());
        if(grav == 0.0) {
            return Universe.getInstance().getGravitationlConstant();
        }
        else return grav;
    }
}
