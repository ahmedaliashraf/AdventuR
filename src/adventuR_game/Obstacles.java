package adventuR_game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.Vector;

public class Obstacles {
	int type;

	int x;
	int y;
	public static int image1Width;
	public static int image1Height;
	public static int image2Width;
	public static int image2Height;
	public static int image3Width;
	public static int image3Height;

	Image[] images = { Toolkit.getDefaultToolkit().getImage("obstacles/spike A.png"),
			Toolkit.getDefaultToolkit().getImage("obstacles/spike B.png"),
			Toolkit.getDefaultToolkit().getImage("obstacles/spike C.png") };

	public Obstacles(int x, int y, int type) {
		// System.out.println(x + " "+ y);

		this.type = type;

		this.x = x;
		this.y = y;

	}

	public int getHeight() {
		return 85;
	}

	public int getWidth() {
		return 80;
	}

	public int getX() {
		return x - (int) Camera2D.x;
	}

	public Rect ObstaclesgetBounds() {
		// return new Rectangle(x,y, 80, 85);
		return new Rect(x - (int) Camera2D.x, y, 80, 85);
	}

	public void draw(Graphics g) {
		//g.drawRect(x - (int) Camera2D.x, y, 80, 85);
		g.drawImage(images[type], this.x - (int) Camera2D.x, y, null);
	}

	// public boolean collidedWith(Sarah s) {
	// System.out.println("jklala");
	// return s.getBounds().intersects(this.ObstaclesgetBounds());
	//
	// }

	// public boolean collidedWith(Sarah s) {
	// System.out.println("jklala");
	// return s.getBounds().hasCollidedWith((this.ObstaclesgetBounds()));
	//
	// }

}
