package gameobjects;

import java.awt.Graphics;
import java.util.ArrayList;

import factories.PowerupFactory;
import main.Game;

public class PowerupList {

	private ArrayList<Powerup> powerups = new ArrayList<>();
	private Player player;
	private PowerupFactory powerupFactory;
	
	public PowerupList(Player player) {
		this.player = player;
		powerupFactory = new PowerupFactory();
	}
	
	public void update() {
		addPowerup();
		removePowerup();
		for (int i = 0; i < powerups.size(); i++) {
			powerups.get(i).update(player);
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < powerups.size(); i++) {
			powerups.get(i).render(g);
		}
	}
	
	public void addPowerup() {
		Powerup powerup = (Powerup)powerupFactory.create();
		
		if(powerup!=null) {
			powerups.add(powerup);
		}
		
	}
	
	public void removePowerup() {
		for (int i = 0; i < powerups.size(); i++) {
			if(powerups.get(i).y>Game.GAME_HEIGHT || powerups.get(i).activated) {
				powerups.remove(i);
			}
		}
	}
	
	
	
}
