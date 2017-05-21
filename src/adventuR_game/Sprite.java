package adventuR_game;

import java.awt.*;


public class Sprite extends Rect
{
   Animation[] animation;
   
   public static final int IDLE = 0;

   int action = IDLE;

   boolean moving = false;


   public Sprite
   (
      int      x,
      int      y,
      int      w,
      int      h,
      String   filename,
      int      duration,
      String[] actions,
      int[]    image_counts
   )
   {
      super(x, y, w, h);

      animation = new Animation[actions.length];

      for(int i = 0; i < actions.length; i++) {
    	  animation[i] = new Animation(filename + "_" + actions[i] + "_" , 
    			  image_counts[i], duration);
//    	  System.out.println(filename+ actions[i]+ image_counts[i]);
      }
    }
   
   public void idle() {
	   action = IDLE;
	   moving = false;
   }
   
   public void setAction(int action) {
	   if (animation[action].finished()) {
		   this.action = action;
	   }
   }
   

   public void draw(Graphics g)
   {
	  
	   
	   g.drawRect(x, y, w, h);
	   g.drawImage(animation[action].nextImage(),x,y, null);
	   
	   action = IDLE;
	   
//      if(moving)    g.drawImage(animation[action].nextImage(),x,y, null);
//
//      else          g.drawImage(animation[action].nextImage(),x,y, null);
//
//      moving = false;
	   
//	   System.out.println("Drawing next image");
//	g.drawImage(animation[action].nextImage(),x,y,100,100,Color.WHITE,null);
	
//	   g.drawImage(animation[action].nextImage(), x, y, null);
//      g.drawRect(x, y, w, h);
   }

}
