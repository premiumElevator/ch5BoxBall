import java.awt.*;
import java.awt.geom.*;

/**
*Class BoxBall - a graphical ball that does not observe the effect of gravity, but rather moves within the constraints
*of a drawn canvas. When the ball reaches an edge of the canvas it will 'bounce' off into the appropriate direction.
*
*
*This movement can be initiated by repeated calls to the "move" method.
*
*
*@author Peter Basily
*@version 2018.10.14
*
*/

/**
* @param diameter the diameter of the ball
* @param xPosition the x coordinate of the ball
* @param yPosition the y coordinate of the ball
* @param xBound the boundary for the ball's x-coordinate
* @param yBound the boundary for the ball's y-coordinate
* @param dx the change in the ball's x coordinate (the speed and direction)
* @param dy the change in the ball's y coordinate (the speed and direction)
*/
public class BoxBall
{
  private Ellipse2D.Double circle;
  private Color color;
  private int diameter;
  private int xPosition;
  private int yPosition;
  private int xBound; //boundary for xPosition
  private int yBound; //boundary for yPosition
  private int dx = 5; //speed and direction of x
  private int dy = 5; //spped and direction of y

  private Canvas canvas;


  public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, Canvas drawingCanvas)
  {
    xPosition = xPos;
    yPosition = yPos;
    color = ballColor;
    diameter = ballDiameter;
    canvas = drawingCanvas;
  }




  public void draw()
  {
      canvas.setForegroundColor(color);
      canvas.fillCircle(xPosition, yPosition, diameter);
  }

  /**
   * Erase this ball at its current position.
   **/
  public void erase()
  {
      canvas.eraseCircle(xPosition, yPosition, diameter);
  }

  /**
   * Move this ball according to its position and speed and redraw.
   **/

  /**
  * checks the y position to see if it is within the given bounds.
  * If it is not, it changes the sign of y to reverse the direction
  * of the ball.
  */
  private void checkyBounds()
  {
      if(yPosition < (yBound - diameter))
      {
        dy = 5;
      }
      if(yPosition >= (yBound - diameter))
      {
        dy = -5;
      }

  }


    /**
    * checks the x position to see if it is within the given bounds.
    * If it is not, it changes the sign of x to reverse the direction
    * of the ball.
    */
  private void checkxBounds()
  {
    if(xPosition < (xBound - diameter))
      {
        dx = 5;
      }
      if( xPosition >= (xBound - diameter))
      {
        dx = -5;
      }
  }

  /**
  * The bounds of x and y coordinates are the size of the canvas - the diameter of
  * the ball.
  */
  public void move()
  {
    xBound = 600-diameter;
    yBound = 500-diameter;
      // remove from canvas at the current position
      erase();

      // compute new position
      xPosition += dx;
      yPosition += dy;

      if(xPosition >= xBound)
           checkxBounds();

      if(xPosition <=0)
          checkxBounds();

      if(yPosition >= yBound)
          checkyBounds();

      if(yPosition <= 0)
          checkyBounds();
      // draw again at new position
      draw();
  }

  /**
   * return the horizontal position of this ball
   */
  public int getXPosition()
  {
      return xPosition;
  }

  /**
   * return the vertical position of this ball
   */
  public int getYPosition()
  {
      return yPosition;
  }
}
