import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 *Modified author: Zachary Childers, Spartanburg Community College
 *Modified Date: March 31st, 2021
 *--
 * @original author Michael Kölling and David J. Barnes
 * @original date 2016.02.29
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }
    
    public void drawTriangle(){
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.GREEN);;
        for(int i=0; i<3; i++){
            pen.move(100);
            pen.turn(120);
        }
    }
    
    public void drawPentagon(){
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.MAGENTA);
        for (int i=0; i<5; i++){
            pen.move(100);
            pen.turn(-72);
        }
    }
    
    public void drawPolygon(int n){
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.CYAN);
        for (int i = 0; i < n; i++) {
            pen.move(50);
            pen.turn(180 - ((n - 2) * 180 / n));
        }
       
    }

    public void spiral()
    {
        Pen pen = new Pen(120, 100, myCanvas);
        pen.setColor(Color.CYAN);
        int z = 10;
        for(int i = 0; i<30; i++)
        {
            pen.move(z);
            pen.turn(90);
            z = z + 5;
        }
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }
    

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
