package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Game;
import ui.GameButton;

public class PauseState extends State implements GameState{

	private GameButton gameButton = new GameButton(300, 200, 50, 50, 0);
	
	public PauseState(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.setFont(new Font(null, Font.ITALIC, 20));
		g.drawString("GAME PAUSED", Game.GAME_WIDTH/2-50, 100);
		gameButton.render(g);
		
	}

	@Override
	public void update() {
		gameButton.update();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(isIn(e, gameButton)) {
			gameButton.setMousePressed(true);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		gameButton.setMousePressed(false);
		if(isIn(e, gameButton)) {
			game.setCurrentState(new Quit(game));
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		gameButton.setMouseOver(false);
		if(isIn(e, gameButton)) {
			gameButton.setMouseOver(true);
		}
		
	}

}
