package Snake;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
	private ArrayList<Rectangle> bodySnake;
	private int width = Game.width; // 30
	private int height = Game.height; // 30
	private int dimen = Game.dimension; // 20
	private String move;

	public Snake() {
		bodySnake = new ArrayList<Rectangle>();
		Rectangle rectangle = new Rectangle(dimen, dimen);
		rectangle.setLocation(width / 2 * dimen, height / 2 * dimen);
		bodySnake.add(rectangle);

		rectangle = new Rectangle(dimen, dimen);
		rectangle.setLocation((width / 2 - 1) * dimen, (height / 2) * dimen);
		bodySnake.add(rectangle);

		rectangle = new Rectangle(dimen, dimen);
		rectangle.setLocation((width / 2 - 2) * dimen, (height / 2) * dimen);
		bodySnake.add(rectangle);

		move = "Nothing";
	}

	public void move() {
		if (move != "Nothing") {
			Rectangle first = bodySnake.get(0);
			Rectangle r = new Rectangle(Game.dimension, Game.dimension);

			if (move == "Up") {
				r.setLocation(first.x, first.y - Game.dimension);
			} else if (move == "Down") {
				r.setLocation(first.x, first.y + Game.dimension);
			} else if (move == "Left") {
				r.setLocation(first.x - Game.dimension, first.y);
			} else {
				r.setLocation(first.x + Game.dimension, first.y);
			}
			bodySnake.add(0, r);
			bodySnake.remove(bodySnake.size() - 1);
		}
	}

	public void developpement() {
		Rectangle first = bodySnake.get(0);
		Rectangle r = new Rectangle(Game.dimension, Game.dimension);

		if (move == "Up") {
			r.setLocation(first.x, first.y - Game.dimension);
		} else if (move == "Down") {
			r.setLocation(first.x, first.y + Game.dimension);
		} else if (move == "Left") {
			r.setLocation(first.x - Game.dimension, first.y);
		} else {
			r.setLocation(first.x + Game.dimension, first.y);
		}
		bodySnake.add(0, r);
	}

	public ArrayList<Rectangle> getBodySnake() {
		return bodySnake;
	}

	public void setBodySnake(ArrayList<Rectangle> bodySnake) {
		this.bodySnake = bodySnake;
	}

	public int getX() {
		return bodySnake.get(0).x;
	}

	public int getY() {
		return bodySnake.get(0).y;
	}

	public String getMove() {
		return move;
	}

	public void up() {
		move = "Up";
	}

	public void down() {
		move = "Down";
	}

	public void left() {
		move = "Left";
	}

	public void right() {

		move = "Right";
	}

}
