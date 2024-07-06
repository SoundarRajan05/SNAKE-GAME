package Snake;

import java.awt.Rectangle;

public class Food {
	private int x;
	private int y;

	public Food(Snake player) {
		this.random_food(player);
	}
	
	public void random_food(Snake player) { 
		boolean check_on_snake = true;
		while (check_on_snake) {
			check_on_snake = false;
			x = (int) (Math.random() * Game.width - 1 );
			y = (int) (Math.random() * Game.height - 1);
			for (Rectangle rec : player.getBodySnake()) {
				if (rec.x == x && rec.y == y) {
					check_on_snake = true;
				}
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
