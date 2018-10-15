import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the
 * Canvas class.
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo

{
    private Canvas myCanvas;
    ArrayList<BoxBall> balls = new ArrayList<>();

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void boxBounce()
    {
      int numOfBalls = 5+((int) (Math.random() * ((30-5)+1)));

      myCanvas.setVisible(true);
      for(int i = 0; i < numOfBalls;i++)
      {
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b= (int)(Math.random()*256);
        Color color = new Color(r, g, b);
        int d = 10+((int)(Math.random() * ((25 - 10) + 1)));
        int x = new Random().nextInt(Math.abs(600));
        int y = new Random().nextInt(Math.abs(500));
        balls.add(new BoxBall(x, y, d, color, myCanvas));
        balls.get(i).draw();
      }

      boolean finished = false;

      while(!finished)
      {

        for(int i = 0; i < numOfBalls; i++)
        {       if(numOfBalls>5)
                {
                    myCanvas.wait(2);
                    balls.get(i).move();
                }
                if(numOfBalls<5)

                  myCanvas.wait(7);
                  balls.get(i).move();


        }
      }
    }
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(80, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(500, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
             //stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550)
            {
               finished = true;
            }
        }
    }
}
//}
