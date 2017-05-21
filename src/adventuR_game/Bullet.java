package adventuR_game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bullet {
	
	public int x;
	public int y;
	public Image img;
	public int imageHeight;
	public int imageWidth;
	public boolean isActive = true;
	
	public Bullet(int x, int y){
		this.x = x;
		this.y = y;
		img = Toolkit.getDefaultToolkit().getImage("bullet/bullets.png");
		this.imageHeight = img.getHeight(null);
		this.imageWidth = img.getWidth(null);
		
	}
	
	public void setX(int x){
		this.x = x;
	}
	public void update(){
		x += 5;
	}
	public Rect getBounds(){
		return new Rect(x,y,imageWidth, imageHeight);
	}
	
	public int getY(){
		return y;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.ORANGE);
		if(isActive)	g.drawImage(img,x,y,null);
	}
	
	
}
