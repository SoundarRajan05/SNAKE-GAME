package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphic extends JPanel implements ActionListener {
	private Timer t = new Timer(100, this);
	public String state;
	
	private Snake s;
	private Food f;
	private Game game;

	public Graphic(Game g) {
		t.start();
		state = "START";
		
		game = g;
		s = g.getPlayer();
		f = g.getFood();
		
		//add a keyListner 
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponents(g); 
		
		Graphics2D gra2D = (Graphics2D) g;
		gra2D.setColor(Color.black);
		gra2D.fillRect(0, 0, Game.width * Game.dimension + 5, Game.height * Game.dimension + 5);
		if(state == "START") {
			gra2D.setColor(Color.white);
			gra2D.drawString("Press Any Key", Game.width/2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
		}
		else if(state == "RUNNING") {
			
			gra2D.setColor(Color.white);
			gra2D.fillArc(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.dimension, Game.dimension,0,360);
			
			
			gra2D.setColor(Color.blue);
			for(Rectangle r : s.getBodySnake()) {
				gra2D.fill(r);
			}
		}
		else {
			gra2D.setColor(Color.white);
			gra2D.drawString("Your Score: " + (s.getBodySnake().size() - 3), Game.width/2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		game.update();
	}
}
