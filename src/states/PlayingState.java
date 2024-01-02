package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import gameobjects.MeteorList;
import gameobjects.Player;
import gameobjects.PowerupList;
import main.Game;

public class PlayingState extends State implements GameState{

	Player player;
	MeteorList meteorList;
	PowerupList powerupList;
	PauseState pauseState;
	private boolean pause;
	
	public PlayingState(Game game) {
		super(game);
		player = new Player(100, 100);
		meteorList = new MeteorList(player);
		powerupList = new PowerupList(player);
		pauseState = new PauseState(game);
	}

	@Override
	public void update() {
		if(pause) {
			pauseState.update();
		}
		else {			
			player.update();
			meteorList.update();
			powerupList.update();
		}
	}
	
	@Override
	public void render(Graphics g) {
		player.render(g);
		meteorList.render(g);
		powerupList.render(g);
		if(pause) {
			pauseState.render(g);
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.setUp(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.setLeft(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.setDown(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			player.setRight(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if(pause) {
				pause = false;
			}
			else {				
				pause = true;
			}
		}
		
		if(pause) {			
			pauseState.keyPressed(e);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.setUp(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.setLeft(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.setDown(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			player.setRight(false);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {			
			player.setShooting(true);
		}
		
		if(pause) {			
			pauseState.mousePressed(e);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		player.setShooting(false);
		if(pause) {			
			pauseState.mouseReleased(e);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(pause) {			
			pauseState.mouseMoved(e);
		}
		
	}

}
