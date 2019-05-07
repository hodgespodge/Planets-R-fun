import java.awt.*;
import javax.swing.*;

import java.util.Scanner;
import java.util.Random;

public class ThreadAnimation extends JFrame {

    private final int F_WIDTH = 1050;
    private final int F_HEIGHT = 700;
    private final int F_DIVIDE = 400;

    public ThreadAnimation() {

        initUI();
    }

    private void initUI() {

        JPanel board = new Board();
        add(board);

        JSplitPane splitPane = new JSplitPane();
        JPanel bottomPanel = new BottomPanel(new GridLayout(5,2));

        setPreferredSize(new Dimension(F_WIDTH, F_HEIGHT));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);

        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(F_DIVIDE);
        splitPane.setTopComponent(board);
        splitPane.setBottomComponent(bottomPanel);

        //bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        //bottomPanel.setLayout(new BorderLayout());

        setResizable(false);
        pack();

        setTitle("Planets R Fun");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new ThreadAnimation();
            ex.setVisible(true);
        });


        /**
         *
         * FOR TESTING FEATURES
         *
         * ALL OF THIS MAY BE DONE IN ANY OTHER CLASS AS IT ALL OPERATES ON THE UNIVERSE.GETINSTANCE
         *
         */

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        while(true){
            System.out.println("Planet size =  ");
            int radius = scan.nextInt();
            Universe.getInstance().addParticle(new Planet(radius*radius*4*Math.PI, new Location(rand.nextInt(600), rand.nextInt(600)), new Vector(0, 0), radius,Color.YELLOW));

            System.out.println("Set Gravity?");
            if(!scan.next().equalsIgnoreCase("No")){
                System.out.println("Gravity = ");
                Universe.getInstance().setGravityScale(scan.nextDouble());

            }else Universe.getInstance().setGravityScale(Universe.getInstance().getGravitationlConstant());
        }
    }
}
