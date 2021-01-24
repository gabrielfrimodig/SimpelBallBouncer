import java.awt.Color;

public class Ball implements Commons{
    private int x,y;
    private int dirx, diry;
    private final int[] rand = {-1,1};
    private Color color;

    public Ball() {
        initBall();
    }

    private void initBall() {
        this.x = (int)(Math.random()*(Board.boardwidght-ballsize/2)+1);
        this.y = (int)(Math.random()*(Board.boardheight-ballsize/2)+1);

        this.dirx = rand[(int)(Math.random()*rand.length)];
        this.diry = rand[(int)(Math.random()*rand.length)];

        this.color = new Color((int)(Math.random() * 0x1000000));
    }

    public void move() {
        if(x+Board.ballsize >= Board.boardwidght){
            dirx = -Board.ballspeed;
            x += dirx;
        }else if (x <= 0){
            dirx = Board.ballspeed;
            x += dirx;
        }else{
            x += dirx;
        }

        if(y+Board.ballsize == Board.boardheight){
            diry = -Board.ballspeed;
            y += diry;
        }else if(y == 0){
            diry = Board.ballspeed;
            y += diry;
        }else{
            y += diry;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}
