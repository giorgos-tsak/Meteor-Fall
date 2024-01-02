package gameobjects;

import utilz.Load;

public class PiercePowerup extends Powerup{

	
	public PiercePowerup(int width, int height) {
		super(width, height);
		image = Load.loadImage(Load.PIERCE_IMAGE);
	}

	
	@Override
	public void power(Player player) {
		
		if(this.getHitbox().intersects(player.getHitbox())) {			
			player.getWeapon().setPiercing(true);
			player.getWeapon().setPierceTime(System.currentTimeMillis());
			activated = true;
		}
		
	}
	
	

}
