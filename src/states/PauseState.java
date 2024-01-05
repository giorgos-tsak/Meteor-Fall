package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Game;
import ui.GameButton;
import ui.GameText;

public class PauseState extends State implements GameState{

	
	public PauseState(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.setFont(new Font(null, Font.ITALIC, 20));
		g.drawString("GAME PAUSED", Game.GAME_WIDTH/2-50, 100);
		
	}

	@Override
	public void update() {
		
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
