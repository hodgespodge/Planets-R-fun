    
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Hashtable;

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

        //sliders do not have their own labels so JLabels are used
        JLabel xLabel = new JLabel("Velocity along x-axis:");
        JLabel yLabel = new JLabel("Velocity along y-axis:");
        JLabel massLabel = new JLabel("Mass:");
        JLabel radiusLabel = new JLabel("Radius:");
        JLabel gravityLabel = new JLabel("Gravity (automatically set to universal gravitational constant of 0.0000000000667408):");

        //JSliders take a minimum value, max value, and the default value (ONLY INTS BY DEFAULT)
        x = new JSlider(-10, 10, 0);
        y = new JSlider(-10, 10, 0);
        mass = new JSlider(0, 1000000, 500000);
        radius = new JSlider(0, 200, 100);


        /**
         * Gravity slider is converted into a double so the effects can be visualised better.
         * labelTable handles displaying the double value instead of the normal int. Only for visualizing
         * these calls do not actually change the value of gravity
         */
        gravity = new JSlider(-5, 5, 0);
        Hashtable labelTable = new Hashtable();
        labelTable.put( 0, new JLabel("0.0") );
        labelTable.put( -5, new JLabel("-0.05") );
        labelTable.put( 5, new JLabel("0.05") );
        labelTable.put(1, new JLabel("0.01") );
        labelTable.put(2, new JLabel("0.02") );
        labelTable.put(3, new JLabel("0.03") );
        labelTable.put(4, new JLabel("0.04") );
        labelTable.put(-1, new JLabel("-0.01") );
        labelTable.put(-2, new JLabel("-0.02") );
        labelTable.put(-3, new JLabel("-0.03") );
        labelTable.put(-4, new JLabel("-0.04") );
        gravity.setLabelTable(labelTable);

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


    //handles conversions of setting ints to doubles. Could be streamlined into a much better method to avoid repetition
    //of code
    public static double getGravity() {
        double grav = Double.valueOf(gravity.getValue());
        if(grav == 0.0) {
            return Universe.getInstance().getGravitationlConstant();
        }
        if(grav == 1) {
            return .01;
        }
        if(grav == 2) {
            return .02;
        }
        if(grav == 3) {
            return .03;
        }
        if(grav == 4) {
            return .04;
        }
        if(grav == 5) {
            return .05;
        }
        if(grav == -1) {
            return -.01;
        }
        if(grav == -2) {
            return -.02;
        }
        if(grav == -3) {
            return -.03;
        }
        if(grav == -4) {
            return -.04;
        }
        if(grav == -5) {
            return -.05;
        }
        else return grav;
    }
}
