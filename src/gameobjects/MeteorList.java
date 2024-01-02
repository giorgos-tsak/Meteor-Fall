package gameobjects;

import java.awt.Graphics;
import java.util.ArrayList;

import factories.MeteorFactory;
import main.Game;

public class MeteorList {
	
	ArrayList<Meteor> meteors = new ArrayList<>();
	MeteorFactory meteorFactory = new MeteorFactory();
	private Player player;
	public MeteorList(Player player) {
		this.player = player;
	}
	
	public void update() {
		addMeteor();
		removeMeteor();
		for (int i = 0; i < meteors.size(); i++) {
			meteors.get(i).update(player);
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < meteors.size(); i++) {
			meteors.get(i).render(g);
		}
	}
	
	public void addMeteor() {
		Meteor meteor = (Meteor)meteorFactory.create();
		if(meteor!=null) {
			meteors.add(meteor);
		}
	}
	
	public void removeMeteor() {
		for (int i = 0; i < meteors.size(); i++) {
			if(meteors.get(i).getY()>Game.GAME_HEIGHT || meteors.get(i).isDestroyed()) {
				meteors.remove(i);
			}
		}
	}
	
	

}
