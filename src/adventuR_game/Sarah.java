package adventuR_game;

import java.util.Vector;

public class Sarah extends Sprite {
	public static final int RUN = 1;
	public static final int JUMP = 2;
	public static final int SLIDE = 3;
	public static final int SHOOT = 4;
	public static final int MELEE = 5;
	public static final int DEAD = 6;
	public int Sarah_Health = 100;
	public int score = 0;

	public static boolean isOnTheGround = true;

	// Image [] shoot = {img1, img2};
	double gravity = 5;
	double velocityx = 5;
	double velocityy = -10;

	private static final String[] actions = { "idle", "run", "jump", "slide", "shoot", "melee", "dead", };

	private static final int[] counts = { 10, 8, 10, 5, 3, 7, 10, };

	public Sarah(int x, int y) {
		super(x, y, 80, 80, "girl/girl", 4, actions, counts);

		// ground_pos = y;

	}

	public int getPos() {
		return (int) Camera2D.x + x;
	}

	public void respondToInput(boolean[] input) {
		// if (inputIs[GameApplet.RT]) run(4);
		if (input[GameApplet.RT]) {
			run();
			Camera2D.moveRightBy(20);
		}
		if (input[GameApplet._Z]) {
			melee();
		}
		if (input[GameApplet._X]) {
			slide();
		}
		if (input[GameApplet.UP]) {
			jump();

			// input[_K] = false;
			// s.update();
		}
	}

	public void update() {
		if ((action == JUMP) && (isOnTheGround)) {
			// System.out.println(y + " initial: " + isOnTheGround);
			x += .5;
			y -= 30 * .6;
			// System.out.println(y + "initial value: ");
			if (y <= 300) {
				isOnTheGround = false;
				// System.out.println(y + " " + isOnTheGround);
			}
		} else if ((action == JUMP) && (!(isOnTheGround))) {
			// System.out.println(y + " y coming down intital " +
			// isOnTheGround);
			y += 30 * .5;
			x += .7;
			if (y >= 475) {
				y = 475;
				// isOnTheGround = true;
			}
		}

		// if (action == JUMP){
		// x += .5;
		// y -= 30 *.6;
		// System.out.println(y + " init" + isOnTheGround);
		// if (y <= 310) isOnTheGround =false;
		// System.out.println(y + ": " + isOnTheGround);
		// }
		// else if ((action == JUMP)&&(y>=475)&&(!(isOnTheGround))){
		// y+= 30 *.4;
		// x+= .5;
		// if( y>=475){ isOnTheGround = false;
		// }
		// }

	}

	public void run() {
		action = RUN;
	}

	public void jump() {
		action = JUMP;

	}

	public void slide() {
		action = SLIDE;

		moving = true;
	}

	public void shoot(Vector<Bullet> bullets) {
		action = SHOOT;

		bullets.add(new Bullet(x + 71, y + 30));
		// System.out.println(y);
		// moving = true;
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

	public void hit() {
		Sarah_Health = -10;
	}

	public String getHealth() {
		return Integer.toString(Sarah_Health);
	}

	public String getScore() {
		return Integer.toString(score);
	}

	public Rect getBounds() {
		return new Rect(x, y, w, h);
	}

	//
	// public void draw(Graphics g) {
	// if (action == JUMP) {
	//
	// int current = animation[JUMP].getCurrentIndex();
	//
	// if (current == 4) {
	// jump_rate = -jump_rate;
	// }
	//
	// y -= jump_rate;
	// }
	//
	// super.draw(g);
	// }
}
