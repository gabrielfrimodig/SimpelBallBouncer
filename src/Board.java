
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;


public class Board extends JPanel implements ActionListener, Commons{
    private final ArrayList<Ball> allBalls = new ArrayList<>();
    private Timer time;

    public Board(){
        initBoard();
    }

    private void initBoard(){
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(boardheight, boardwidght));

        initGame();
    }

    private void initGame(){
        System.out.println("Press 'Space' for new ball, 'p' for pause/continue, 'esc' for ending.");

        time = new Timer(DELAY, this);
        time.start();

        allBalls.add(new Ball());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g){
        g.setColor(Color.RED);

        for(Ball b : allBalls) {
            g.setColor(b.getColor());
            g.fillOval(b.getX(), b.getY(), ballsize, ballsize);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(Ball b : allBalls) {
            b.move();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_SPACE) {
                allBalls.add(new Ball());
            }

            if((key == KeyEvent.VK_P) && time.isRunning()){
                time.stop();
            }else{
                time.start();
            }

            if((key == KeyEvent.VK_ESCAPE)){
                System.exit(0);
            }
        }
    }
}
