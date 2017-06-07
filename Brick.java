import java.awt.Color;
/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick
{
    // instance variables - replace the example below with your own
    public int x; //x position of the brick
    public int y; //y position of the brick    
    public int width;
    public int height;    
    public Color brickColor;
    public boolean gone=false;
    
    /**
     * Constructor for objects of class Brick
     */
    public Brick()
    {
        // initialise instance variables
        x = 0;
    }
    
    public Brick(int xPos, int yPos, int bWidth, int bHeight, Color theBrickColor)
    {
        x = xPos;
        y = yPos;  
        width = bWidth;
        height =bHeight;
        brickColor = theBrickColor; 
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
