import javax.swing.*;

public class SimpleBallBouncer extends JFrame {

    public SimpleBallBouncer(){
        initUI();
    }

    private void initUI(){
        add(new Board());
        setResizable(false);
        pack();

        setTitle("Simple Ball Bouncer");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        JFrame frame = new SimpleBallBouncer();
        frame.setVisible(true);
    }
}