import javax.swing.JFrame;

public class BrickStarter extends JFrame {

    public BrickStarter()
    {
        add(new BrickBoard());
        setTitle("Circle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new BrickStarter();
    }
}