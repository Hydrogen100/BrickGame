import java.awt.Color;
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball
{
    // instance variables - replace the example below with your own
    int x; //x position of ball
    int y; //y position of ball
    int width; //width of ball
    int height;//height of ball
    public Color ballColor;
    int xDir=1;
    int yDir=1;

    /**
     * Constructor for objects of class Ball
     */
    public Ball()
    {
        // initialise instance variables
        x = 0;
    }

    public Ball(int xPos, int yPos, int bWidth,int bHeight, Color theBallColor)
    {
        x = xPos;
        y = yPos;
        width = bWidth;
        height = bHeight;
        ballColor = theBallColor;
    }/**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void collide(Brick aBrick)
    {
        if (!aBrick.gone)
        {
            if ((Math.abs(aBrick.x-this.x)<width)&&(Math.abs(aBrick.y-this.y)<height))//collide
            {
                aBrick.gone = true;
                yDir *=-1; 
                xDir *=-1;
            }
            
        }
        
    }
    public void move()
    {
        int moveSpeed=20;
       if (yDir==1){ //up
            this.y-=moveSpeed;
        }else{
            this.y+=moveSpeed;
        }

        if (xDir==1){ 
            this.x-=moveSpeed;//left
        }else{
            this.x+=moveSpeed; //right
        }        
        
        //bounce
        if (this.y<=0){
            yDir=-1;
        }else if(this.y>=(500-height)){
            yDir=1;
        }

        if (this.x<=0){
            xDir=-1;
        }else if(this.x>=(500-width)){
            xDir=1;
        }        
    }
}
