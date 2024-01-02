package gameobjects;

import utilz.Load;

public class HealPowerup extends Powerup{

	private int healing=25;
	
	
	public HealPowerup(int width, int height) {
		super(width, height);
		image = Load.loadImage(Load.HEAL_IMAGE);
	}

	@Override
	public void power(Player player) {
		if(this.getHitbox().intersects(player.getHitbox())) {
			player.setHealth(player.getHealth()+healing);
			if(player.getHealth()>100) {
				player.setHealth(100);
			}
			activated = true;
		}
		
	}

}
