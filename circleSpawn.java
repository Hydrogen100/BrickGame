import java.awt.Color;
public class circleSpawn
{
    int posX=500;
    int posY=500;
    static int radius=30;
    Color circleColor;
   //Graphics currentG;
    public circleSpawn(int x, int y, Color color){
    posX=x;
    posY=y;
    circleColor=color;
    //currentG=g;
    }
    
    public void newSpawn(){
    posX=(int)(Math.random()*(1000-2*circleSpawn.radius)+circleSpawn.radius);
    posY=(int)(Math.random()*(1000-2*circleSpawn.radius)+circleSpawn.radius);
    }
}
