package states;

import java.awt.event.MouseEvent;

import main.Game;
import ui.GameButton;

public class State {
	
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public boolean isIn(MouseEvent e,GameButton gameButton) {
		
		return gameButton.getBounds().contains(e.getX(),e.getY());
	}

}
