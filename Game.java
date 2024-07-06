package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Game implements KeyListener {
	private Snake player;
	private Food food;
	private Graphic graphic;
	private JFrame window;
	
	public static final int width = 40;
	public static final int height = 40;
	public static final int dimension = 20;
	public Game() {
		window = new JFrame();
		
		player = new Snake();
		food = new Food(player);
		graphic = new Graphic(this); 
		
		window.add(graphic);
		window.setTitle("Snake Game");
		window.setSize(width * dimension + 2, height * dimension + dimension + 4);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void start() {
		graphic.state = "RUNNING";
	}
	public void update() {
		if(graphic.state == "RUNNING")
		{
			if(check_food()) { 
				player.developpement();
				food.random_food(player);
			}
			else if(check_wall() || check_body()) { 
				graphic.state = "END";
			}
			else {
				player.move();
			}
		}
	}
	private boolean check_wall() {
		if(player.getX() < 0 || player.getX() >= width * dimension 
				|| player.getY() < 0 || player.getY() >= height * dimension)
		{
			return true;
		}
		return false;
	}
	private boolean check_food() {
		if(player.getX() == food.getX() * dimension
				&& player.getY() == food.getY() * dimension)
		{
			return true;
		}
		return false;
	}
	private boolean check_body() {
		for(int i = 1; i < player.getBodySnake().size(); i++)
		{
			if(player.getX() == player.getBodySnake().get(i).x 
				&& player.getY() == player.getBodySnake().get(i).y)
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		int keyCode  = e.getKeyCode();
		
		if(graphic.state == "RUNNING")
		{
			if (keyCode == KeyEvent.VK_W && player.getMove() != "Down") { //Move up
				player.up();
			}
			if (keyCode == KeyEvent.VK_S && player.getMove() != "Up") {  //Move down
				player.down();
			}
			if (keyCode == KeyEvent.VK_A && player.getMove() != "Right") { //Move left
				player.left();
			}
			if (keyCode == KeyEvent.VK_D && player.getMove() != "Left") { //Move down
				player.right();
			}
		}
		else {
			this.start();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	public Snake getPlayer() {
		return player;
	}
	public void setPlayer(Snake player) {
		this.player = player;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Graphic getGraphic() {
		return graphic;
	}
	public void setGraphic(Graphic graphic) {
		this.graphic = graphic;
	}
	public JFrame getWindow() {
		return window;
	}
	public void setWindow(JFrame window) {
		this.window = window;
	}
}