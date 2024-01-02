package gameobjects;

import utilz.Load;

public class IceMeteor extends Meteor {

	private int damage=20;
	
	public IceMeteor(int width, int height) {
		super(width, height);
		image = Load.loadImage(Load.ICE_METEOR_IMAGE);
		speed = 1f;
	}
	
	
	

	
	
	
	public int getDamage() {
		return damage;
	}
	
	

}
