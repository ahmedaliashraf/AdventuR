package adventuR_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;


public class Drawing extends GameApplet{
	
	Sarah s = new Sarah(0,475);
	Sound jumpSound;
	//Monsters m = new Monsters(2000,475);
	Monsters[] monsters = new Monsters[1000];
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
		shoot = new Vector<Bullet>();
		int last_loc = 0;
		for (int i = 0; i < obs.length; i++) {
			int pos = last_loc + rand.nextInt(1024);
			obs[i] = new Obstacles(pos, 475, rand.nextInt(3));
			last_loc = pos;
		}
		int j = 2000;
		for (int i = 0; i < monsters.length; i++) {
			monsters[i]= new Monsters(j,475);
			j+=rand.nextInt((1000-500)+1)+500;
		}
		jumpSound = new Sound("sounds/s.jump.wav");
	}

	@Override
	public void respondToInput() {
		s.respondToInput(input);
	    if (input[SP]){
	    	s.shoot(shoot);
	    }
	    
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == UP) {
			Sarah.isOnTheGround = true;
			jumpSound.play();
			// if((Sarah.isOnTheGround)){
			// input[code] = true;
			// }
			// else {
			// input[code] = false;
			// }
		} else {
			input[code] = false;
		}
	}

	@Override
	public void moveGameObjects() {
		s.update();
		//m.walk_left(5);
		for (int i = 0; i < monsters.length; i++) {
			//monsters[i].chase(s);
			monsters[i].walk_left(5);
		}
		//Camera2D.moveRightBy(10);
	
		for(int i =0; i< shoot.size(); i++){
			shoot.get(i).update();
		}
	}

	@Override
	public void handleCollisions() {
		// Sarh's Collision with obstacles
		for (int i = 0; i < obs.length; i++) {
			if (s.hasCollidedWith(obs[i].ObstaclesgetBounds())) {
				s.Sarah_Health = 0;
				s.die();
			}
		}
		// Sarah's Collision with monster
		for (int i = 0; i < monsters.length; i++) {
			if (monsters[i].isAlive){
				if (s.hasCollidedWith(monsters[i])) {//&& m.isAlive == true
					s.Sarah_Health = 0;
					s.die();
				}
			}
		}

		// Monster's collision with bullets
		for (int j = 0; j < shoot.size(); j++) {
			if (shoot.get(j).isActive){
				for (int i = 0; i < monsters.length; i++) {
					if (monsters[i].hasCollidedWith(shoot.get(j).getBounds())) {// && shoot.get(j).isActive == true
						monsters[i].hit();
						if (monsters[i].health >= 1) {
							shoot.get(j).isActive = false;
						} else {
							monsters[i].isAlive = false;
							s.score += 10;//give points to player per monster kill
						}
					}
				}
			}
		}

		// bullet's with obstacles
		for (int k = 0; k < shoot.size(); k++) {
			for (int i = 0; i < obs.length; i++) {
				if (shoot.get(k).hasCollidedWith(obs[i].ObstaclesgetBounds())) {
					shoot.get(k).isActive = false;
				}
			}
		}
		// monster with obstacles
		for (int i = 0; i < obs.length; i++) {
			for (int j = 0; j < monsters.length; j++) {
				if(monsters[j].hasCollidedWith(obs[i].ObstaclesgetBounds())){
					monsters[j].moveUpBy(obs[i].getHeight());
					monsters[j].moveLeftBy(obs[i].getWidth());
					monsters[j].moveDnBy(obs[i].getHeight());
	//tried so it clims up, but not working
//					if (475-obs[i].getHeight()+2!=m.y) m.moveUpBy(1);
//					if (obs[i].getX()-2!=m.x)	m.moveLeftBy(1);
//					if (m.y<475)	m.moveDnBy(1);
//					if(m.y>= 475) m.moving = true;
				}
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
		g.drawString("HP: "+s.getHealth(), 5, 15);
		g.drawString("Score: "+s.getScore(), 5, 30);
		for (int i = 0; i< shoot.size();i++){
			shoot.get(i).draw(g);
		}
		
		//levels.drawLevels(g);
		
		s.draw(g);
		for (int j = 0; j < monsters.length; j++) {
			if (monsters[j].isAlive){
				monsters[j].draw(g);
			}
		}

		//g.drawImage(image, 100, 100, null);
	}
	

}
