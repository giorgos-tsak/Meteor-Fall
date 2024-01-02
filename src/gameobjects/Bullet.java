package gameobjects;

import java.util.ArrayList;

import factories.Creatable;

public class Bullet extends GameObject implements Creatable{


	private int damage;
	private ArrayList<Meteor> meteorsHit;
	public Bullet(int width, int height,Player player) {
		super(width, height);
		x=player.x+player.width/2-this.width/2;
		y=player.y-height;
		damage = 40;
		speed = 5f;
		meteorsHit = new ArrayList<>();
		
	}
	
	public void fire() {			
		y-=speed;
	}
	
	
	public void update() {
		super.update();
		fire();
	}
	
	public void checkMeteorHit(Meteor meteor) {
		if(!meteorsHit.contains(meteor)) {
			meteor.setHealth(meteor.getHealth()-damage);
			meteorsHit.add(meteor);
		}
	}
	
	
	public int getDamage() {
		return damage;
	}
	
	public ArrayList<Meteor> getMeteorsHit() {
		return meteorsHit;
	}
	public void setMeteorsHit(ArrayList<Meteor> meteorsHit) {
		this.meteorsHit = meteorsHit;
	}
	
	
	
}
