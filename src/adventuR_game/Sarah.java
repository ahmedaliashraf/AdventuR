package adventuR_game;
import java.awt.Graphics;
import java.awt.Image;

public class Sarah extends Sprite{
	   public static final int RUN = 1;
	   public static final int JUMP = 2;
	   public static final int SLIDE = 3;
	   public static final int SHOOT = 4;
	   public static final int MELEE = 5;
	   public static final int DEAD = 6;
	   public int Sarah_Health = 100;
	   
	   boolean isOnTheGround = true;
	   
	   
	   double gravity = 5;
	   double velocityx = 5;
	   double velocityy = -10;
	   
	   private static final String[] actions =
	   {
	      "idle",
		  "run",
		  "jump",
	      "slide",
	      "shoot",
	      "melee",
	      "dead",
	   };
	   
	   private static final int[] counts = {
	       10, 8, 10, 5, 3, 7, 10,
	   };


	   public Sarah(int x, int y)
	   {
	     super(x, y, 118, 100, "girl/girl", 10, actions, counts);
	     
//	     ground_pos = y;
	      
	   }
	   
	   public int getPos() {
		   return (int)Camera2D.x + x; 
	   }
	   
	   public void respondToInput(boolean[] inputIs){
//		   if (inputIs[GameApplet.RT]) run(4);
//		   if (inputIs[GameApplet._C]) jump(30);
//		   if (inputIs[GameApplet.SP]) shoot();
//		   if (inputIs[GameApplet._Z]) melee();
//		   if (inputIs[GameApplet._X]) slide();
//		   if (inputIs[GameApplet.DN]) melee();
		   
		   
	   }
	   
	   public void update() {
		   if ((action == JUMP)&&(isOnTheGround)) {
			 x += 10 * .5;
			 y -= 30 * .6;
			 System.out.println(y + "initial value: ");
			 if (y <= 370){
				 isOnTheGround = false;	 
				 System.out.println(y + " " + isOnTheGround);
			 }
		   }
		   if ((action == JUMP)&&(!(isOnTheGround))){
			   y += 10 *.4;
			   x += 15 *.5;
			   if (y == 475){
				   isOnTheGround = true;
			   }
		   }
	   }
	   
	   public void run()
	   {
	      action = RUN;
	   }
	   
	   public void jump()
	   {  
	      action = JUMP;
	  
	   }
	   
	   public void slide()
	   {
	      action = SLIDE;
	      
	      moving = true;
	   }
	   
	   public void shoot() {
	      setAction(SHOOT);
	      moving = true;
	   }
	   
	   public void melee() {
		   action = MELEE;
		   moving = false;
	   }
	   
	   public void die() {
		   // this might change later to reflect the image.
		   action = DEAD;
		   moving = false;
	   }
	   public void hit(){
		   Sarah_Health =-10;
	   }
	   public String getHealth(){
		   return Integer.toString(Sarah_Health);
	   }

//	   
//	   public void draw(Graphics g) {
//		   if (action == JUMP) {
//			   
//			   int current = animation[JUMP].getCurrentIndex();
//			   
//			   if (current == 4) {
//				   jump_rate = -jump_rate;
//			   }
//			   
//			   y -= jump_rate;
//		   }
//		   
//		   super.draw(g);
//	   }
}
