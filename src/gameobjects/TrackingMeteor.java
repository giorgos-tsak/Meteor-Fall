package gameobjects;

import utilz.Load;

public class TrackingMeteor extends Meteor{

	private int damage = 15;
	
	public TrackingMeteor(int width, int height) {
		super(width, height);
		image = Load.loadImage(Load.TRACKING_METEOR_IMAGE);
		speed = 1.5f;
		
	}

	@Override
	public void update(Player player) {
		super.update(player);
		trackPlayer(player);
	}

	public void trackPlayer(Player player){
		if(this.y<player.y){
			if(this.x<player.x){
				this.x+=speed;
			}
			if(this.x>player.x){
				this.x-=speed;
			}
		}
	}
	

	
	public int getDamage() {
		return damage;
	}

}
