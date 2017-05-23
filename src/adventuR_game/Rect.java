package adventuR_game;

import java.awt.*;

public class Rect {

	int x;
	int y;
	int w;
	int h;

	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;

		this.w = w;
		this.h = h;
	}

	public boolean contains(int mx, int my) {
		return ((mx < x + w) && (mx > x) && (my > y) && (my < y + h));
	}

	public boolean hasCollidedWith(Rect r) {
		return ((r.x <= x + w) && (r.x + r.w >= x) && (r.y + r.h >= y) && (r.y <= y + h));
	}

	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void moveLeftBy(int dx) {
		x -= dx;
	}

	public void moveRightBy(int dx) {
		x += dx;
	}

	public void moveUpBy(int dy) {
		y -= dy;
	}

	public void moveDownBy(int dy) {
		y += dy;
	}

	public void draw(Graphics g) {
		g.drawRect(x, y, w, h);
	}

}