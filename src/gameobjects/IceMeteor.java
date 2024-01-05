package gameobjects;

import utilz.Load;

import java.util.Timer;
import java.util.TimerTask;

public class IceMeteor extends Meteor {

	private int damage=20;
	
	public IceMeteor(int width, int height) {
		super(width, height);
		image = Load.loadImage(Load.ICE_METEOR_IMAGE);
		speed = 1f;
	}

	@Override
	public void update(Player player) {
		super.update(player);
		freeze(player);
	}

	public void freeze(Player player) {
		if(this.hitbox.intersects(player.getHitbox())){
			player.setFreezeTime(System.currentTimeMillis());
		}
	}

	public int getDamage() {
		return damage;
	}

}
