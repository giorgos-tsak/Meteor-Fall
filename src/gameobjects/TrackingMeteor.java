package gameobjects;

import utilz.Load;

public class TrackingMeteor extends Meteor{

	private int damage = 15;
	
	public TrackingMeteor(int width, int height) {
		super(width, height);
		image = Load.loadImage(Load.METEOR_IMAGE);
		speed = 1.5f;
		
	}
	

	
	public int getDamage() {
		return damage;
	}

}
