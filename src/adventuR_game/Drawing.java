package adventuR_game;

import java.awt.Color;
import java.awt.Graphics;


public class Drawing extends GameApplet{
	
	Sarah s = new Sarah(550,475);
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
	
	int[] lv1_obs = {-1, 0, -1, 1, 1, 0, -1, -1};
	Level lv1 = new Level(0, 1, lv1_obs);
	
	int[] lv2_obs = {-1, 0, -1, -1, 1, -1, 2, -1};
	Level lv2 = new Level(2048, 1, lv1_obs);
	
	Level currentLevel = lv1;
	Level nextLevel = lv1;
	

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respondToInput() {
		// TODO Auto-generated method stub
	    if(input[RT]) { 
	    	s.run();
	    	Camera2D.moveRightBy(8);
	    }
	    if (input[SP]){
	    	s.shoot();
	    }
	    if (input[_Z]){
	    	s.melee();
	    }
	    if (input[_X]){
	    	s.slide();
	    }
	    if (input[_K]){
	    	s.jump();
//	    	s.update();
	    }
	    
	}

	@Override
	public void moveGameObjects() {
		s.update();
		m.walk_left(9);
	}

	@Override
	public void handleCollisions() {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
		layer7.draw(g);
		layer6.draw(g);
		layer5.draw(g);
		layer4.draw(g);
		layer3.draw(g);
		layer2.draw(g);
		layer1.draw(g);
		g.setColor(Color.WHITE);
		g.drawString(s.getHealth(), 5, 15);
		
		nextLevel.draw(g);
		
		//o.draw(g);
		s.draw(g);
		m.draw(g);
		
		//g.drawImage(image, 100, 100, null);
	}

}
