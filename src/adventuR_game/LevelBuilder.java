package adventuR_game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class LevelBuilder {

	private int current = 0;

	private Level[] a_levels = new Level[5];
	private Level[] b_levels = new Level[5];

	private Level[] currLevels;
	private Level[] backLevels;

	// private Sarah sarah;

	private Random rand;

	private int total = 0;

	public LevelBuilder() {
		currLevels = b_levels;
		backLevels = a_levels;

		rand = new Random();

		// sarah = s;

		for (int i = 0; i < 5; i++) {
			int[] obs = new int[8];
			for (int y = 0; y < 8; y++) {
				obs[y] = -1 + rand.nextInt(4);
			}

			currLevels[i] = new Level(total, 0, obs);
			total += 4096;
		}

	}

	private void generateLevels() {
		for (int i = 1; i < 5; i++) {
			int[] obs = new int[8];
			for (int y = 0; y < 8; y++) {
				obs[y] = -1 + rand.nextInt(4);
			}

			backLevels[i] = new Level(total, 0, obs);
			total += 4096;
		}
	}

	public void nextLevel() {
		current++;

		if (current == 3) {
			generateLevels();
		}

		else if (current == 5) {
			Level[] temp = currLevels;
			currLevels = backLevels;
			backLevels = temp;
			current = 0;
			currLevels[0] = backLevels[4];
		}
	}
	// public Rectangle getBounds(){
	// return new Rectangle(x,y,w,h);
	// }

	public Level getLevel() {
		return currLevels[current];
	}

	public void drawLevels(Graphics g) {
		if (!(currLevels[current].contains((int) Camera2D.x)))
			nextLevel();

		// System.out.println(current);

		for (int i = 0; i < 5; i++) {
			currLevels[i].draw(g);
		}
	}
}
