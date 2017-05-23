package adventuR_game;

public class Monsters extends Sprite {

	public static final int WALK = 0;
	public int health = 100;
	public boolean isAlive = true;

	private static final String[] actions = { "walks" };

	private static final int[] counts = { 12 };

	public Monsters(int x, int y) {
		super(x, y, 86, 100, "monsters/monsters", 5, actions, counts);

	}

	public void walk_left(int dx) {
		x -= dx;
		moving = true;
	}

	public void walk_right(int dx) {
		x += dx;
	}

	public void moveUpBy(int dy) {
		y -= dy;
	}

	public void moveDnBy(int dy) {
		y += dy;
	}

	public void hit() {
		health -= 10;
	}

	public void chase(Sarah s) {
		if (s.x <= this.x)
			walk_left(5);
		if (s.x > this.x)
			walk_right(5);
	}
}
