import java.awt.EventQueue;
import javax.swing.JFrame;

public class ThreadAnimation extends JFrame {

    public ThreadAnimation() {

        initUI();
    }

    private void initUI() {

        JPanel board = new Board();
        add(board);

        JSplitPane splitPane = new JSplitPane();
        JPanel bottomPanel = new BottomPanel();

        setPreferredSize(new Dimension(F_WIDTH, F_HEIGHT));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);

        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(F_DIVIDE);
        splitPane.setTopComponent(board);
        splitPane.setBottomComponent(bottomPanel);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

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
    }
}
