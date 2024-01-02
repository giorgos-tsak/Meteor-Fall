package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface GameState {
	
	public void render(Graphics g);
	public void update();
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	
}
