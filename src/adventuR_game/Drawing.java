package adventuR_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;


public class Drawing extends GameApplet{
	
	Sarah s = new Sarah(0,475);
	Sound jumpSound;
	Monsters m = new Monsters(2000,475);
//	Obstacles o = new Obstacles(975, 475);
	public int counter = 0;
	ImageLayer layer7 = new ImageLayer("backgroundLayers/layer7.png", 0, 0, 2147483647, 1365, 1);
	ImageLayer layer6 = new ImageLayer("backgroundLayers/layer6.png", 0, 0, 2147483640, 1365, 1);
	ImageLayer layer5 = new ImageLayer("backgroundLayers/layer5.png", 0, 0, 4, 1365, 50);
	ImageLayer layer4 = new ImageLayer("backgroundLayers/layer4.png", 0, 0, 3, 1365, 50);
	ImageLayer layer3 = new ImageLayer("backgroundLayers/layer3.png", 0, 0, 2, 1365, 50);
	ImageLayer layer2 = new ImageLayer("backgroundLayers/layer2.png", 0, 0, 1, 1365, 50);
	ImageLayer layer1 = new ImageLayer("backgroundLayers/layer1.png", 0, -200, 1, 1365, 50);
	
	public Vector<Bullet> shoot;
	Random rand = new Random();
	
	//LevelBuilder levels = new LevelBuilder();
	
	Obstacles[] obs = new Obstacles[1000];

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		shoot = new Vector<Bullet>();
		
		int last_loc = 0;
		for (int i = 0; i < obs.length; i++) {
			int pos = last_loc + rand.nextInt(1024);
			obs[i] = new Obstacles(pos, 475, rand.nextInt(3));
			last_loc = pos;
		}
		
		jumpSound = new Sound("sounds/s.jump.wav");
	}

	@Override
	public void respondToInput() {
		// TODO Auto-generated method stub
	    if(input[RT]) { 
	    	s.run();
	    	Camera2D.moveRightBy(20);
	    }
	    if (input[SP]){
	    	s.shoot(shoot);
	    }
	    if (input[_Z]){
	    	s.melee();
	    }
	    if (input[_X]){
	    	s.slide();
	    }
	    if (input[_C]){
	    	
	    	s.jump();
	    	 
	    
//	    	input[_K] = false;
//	    	s.update();

	    }
	    
	}
		@Override
	   public  void keyReleased(KeyEvent e)
	   {
	      int code = e.getKeyCode();
	      if(code == _C){
	    	  Sarah.isOnTheGround = true;
	    	  jumpSound.play();
//	    	  if((Sarah.isOnTheGround)){
//	    		  input[code] = true;
//	    	  }
//	    	  else {
//	    		  input[code] = false;
//	    	  }
	      }
	      else{
	      input[code] = false;
	      }
	      
	      //
	   }

	@Override
	public void moveGameObjects() {
		s.update();
		m.walk_left(9);
		//Camera2D.moveRightBy(10);
	
		for(int i =0; i< shoot.size(); i++){
			shoot.get(i).update();
		}
	}

	@Override
	public void handleCollisions() {
		// TODO Auto-generated method stub


		for(int i= 0; i<obs.length;i++){
			if (s.hasCollidedWith(obs[i].ObstaclesgetBounds())){
				//System.out.println("Collision");
				s.die();
			}
		}
		
		
	}
	
	public void paint(Graphics g) {
		layer7.draw(g);
		layer6.draw(g);
		layer5.draw(g);
		layer4.draw(g);
		layer3.draw(g);
		layer2.draw(g);
		layer1.draw(g);
		for (int i=0;i<obs.length;i++){
			obs[i].draw(g);
		}
		g.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
		g.setColor(Color.RED);
		g.drawString(s.getHealth(), 5, 15);
		for (int i = 0; i< shoot.size();i++){
			shoot.get(i).draw(g);
		}
		
		//levels.drawLevels(g);
		
		//o.draw(g);
		s.draw(g);
		m.draw(g);
		//g.drawImage(image, 100, 100, null);
	}
	

}
