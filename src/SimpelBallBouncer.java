import javax.swing.*;

public class SimpelBallBouncer extends JFrame {

    public SimpelBallBouncer(){
        initUI();
    }

    private void initUI(){
        add(new Board());
        setResizable(false);
        pack();

        setTitle("Simpel Ball Bouncer");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        JFrame frame = new SimpelBallBouncer();
        frame.setVisible(true);
    }
}