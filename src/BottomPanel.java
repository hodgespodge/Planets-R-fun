    
import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel{

    static JSlider x;
    static JSlider y;

    BottomPanel() {
        run();
    }

    private void run() {
        setBackground(Color.LIGHT_GRAY);

        this.setLayout(null);

        //JLabel label = new JLabel("PLAAAAAANETS ARE FUUUUUUUUUN");

        x = new JSlider(-10, 10, 0);
        y = new JSlider(-10, 10, 0);
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

        add(x);
        add(y);
    }

    public static double getXValue() {
        return Double.valueOf(x.getValue());
    }

    public static double getYValue() {
        return Double.valueOf(y.getValue());
    }
}
