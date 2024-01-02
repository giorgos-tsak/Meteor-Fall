package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;

public class MouseInputs implements MouseListener,MouseMotionListener{

	private Game game;
	public MouseInputs(Game game) {
		this.game = game;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		game.getCurrentState().mousePressed(e);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		game.getCurrentState().mouseReleased(e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		game.getCurrentState().mouseMoved(e);
		
	}

}
