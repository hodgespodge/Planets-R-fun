    
import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel{

    static JSlider x;
    static JSlider y;
    static JSlider mass;
    static JSlider radius;

    BottomPanel() {
        run();
    }

    private void run() {
        setBackground(Color.LIGHT_GRAY);

       // this.setLayout(BorderLayout);

        x = new JSlider(-10, 10, 0);
        y = new JSlider(-10, 10, 0);
        mass = new JSlider(0, 1000000, 500000);
        radius = new JSlider(0, 200, 100);

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

        add(x);
        add(y);
        add(mass);
        add(radius);
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
}
