import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class BrickBoard  extends JPanel implements Runnable, MouseListener, MouseMotionListener
{
boolean ingame = false;//you can set to false to control start of game
private Dimension d;
int BOARD_WIDTH=1000;
int BOARD_HEIGHT=1000;
MousePosition mousePos=new MousePosition(0,0);
int distance;
BufferedImage img;
circleSpawn circleNew;
boolean collided=false;
boolean gameStart=false;
int newPos=0;
int numRuns=0;
String message = "Use this message as you wish";
 private Thread animator;

 
    public BrickBoard()
    {
        addKeyListener(new TAdapter());
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        setBackground(Color.black);
       //remove comments below if you'd like to add an image to your game
           /*         
             try {
                img = ImageIO.read(this.getClass().getResource("myImage.jpg"));
            } catch (IOException e) {
                 System.out.println("Image could not be read");
            // System.exit(1);
            }
            */
            if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
            }
                    
        //gives circle x, y position
        circleNew = new circleSpawn((int)(Math.random()*(d.width-2*circleSpawn.radius+1)+circleSpawn.radius),
            (int)(Math.random()*(d.height-2*circleSpawn.radius+1)+circleSpawn.radius),Color.white);
        
            distance=0;
        setDoubleBuffered(true);
    }
    
    public void paint(Graphics g)
{
    super.paint(g);
    //checks if mouse is inside circle
          if(distance<=circleSpawn.radius){
          collided=true;
        }
        //update distance
        distance=(int)(Math.sqrt(Math.pow((mousePos.mouseX-circleNew.posX),2)+Math.pow((mousePos.mouseY-circleNew.posY),2)));
    
    //color background black again
   g.setColor(Color.black);
   System.out.println("repainting");
   g.fillRect(0, 0, d.width, d.height);
    
    Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.black);
       g.setFont(small);
        g.drawString(message, 10, d.height-60);
    //draw the circle
    
    if(collided&&numRuns>=5){
        System.out.println("new circle");
    circleNew.newSpawn();
    
    
    System.out.println("new circle drawn");
    //once circle is given new position, collided is set to false
collided=false;
System.out.println("collided changed to false");
    newPos++;
    numRuns=0;
}
g.setColor(Color.white);
    g.fillOval(circleNew.posX,circleNew.posY,circleSpawn.radius,circleSpawn.radius);
    /*
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.black);
       g.setFont(small);
        g.drawString(message, 10, d.height-60);
*/
    if (ingame) {//active board appears in these brackets.
        
    
        
       
        
    // g.drawImage(img,0,0,200,200 ,null);//if you want to display an image
     
    
   
    }
Toolkit.getDefaultToolkit().sync();
g.dispose();
}
private class TAdapter extends KeyAdapter {

public void keyReleased(KeyEvent e) {
     int key = e.getKeyCode();
     
}

public void keyPressed(KeyEvent e) {
//System.out.println( e.getKeyCode());
   // message = "Key Pressed: " + e.getKeyCode();
    int key = e.getKeyCode();
   message = "key pressed: " + key;
        if(key==39){
          
        }
        
       

}

}




public void mousePressed(MouseEvent e) {
    ingame=true;
    int x = e.getX();
    int y = e.getY();
    message = "mousePressed: x: " + x + " y: " + y;

}

public void mouseReleased(MouseEvent e) {

}

public void mouseEntered(MouseEvent e) {
mousePos.mouseX=e.getX();
mousePos.mouseY=e.getY();
}

public void mouseExited(MouseEvent e) {

}

public void mouseClicked(MouseEvent e) {

}

public void mouseMoved(MouseEvent e){
mousePos.mouseX=e.getX();
mousePos.mouseY=e.getY();
}

public void mouseDragged(MouseEvent e){

}

public void run() {
  
long beforeTime, timeDiff, sleep;

beforeTime = System.currentTimeMillis();
 int animationDelay = 100;//control FPS of board
 long time = 
            System.currentTimeMillis();
    while (true) {//infinite loop
     // spriteManager.update();
      repaint();
      numRuns++;
      try {
        time += animationDelay;
        Thread.sleep(Math.max(0,time - 
          System.currentTimeMillis()));
          
      }catch (InterruptedException e) {
        System.out.println(e);
      }//end catch
        //circle move
      
    }//end while loop

/*
long beforeTime, timeDiff, sleep,currentTime;


 int animationDelay = 10000;//control FPS of board
    while (ingame) {//infinite loop
     // spriteManager.update();
      repaint();
      beforeTime = System.currentTimeMillis();
      try {
        //time += animationDelay;
        while(distance>circleSpawn.radius){
        distance=(int)(Math.sqrt(Math.pow((mousePos.mouseX-circleNew.posX),2)+Math.pow((mousePos.mouseY-circleNew.posY),2)));
        //System.out.println(distance);
        Thread.sleep(1000);
    }
    currentTime=System.currentTimeMillis();
    if(currentTime-beforeTime>animationDelay){
    ingame=false;
    //end game
    }
      }catch (InterruptedException e) {
        System.out.println(e);
      }//end catch
        //circle move
      circleNew.newSpawn();
      //this line is causing error
    }//end while loop

    */


}//end of run

}//end of class
