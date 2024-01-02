package gameobjects;


import utilz.Load;

public class StrongBullet extends Bullet{

	
	
	public StrongBullet(int width, int height,Weapon weapon) {
		super(width,height,weapon.getPlayer());
		speed = 3.5f;
		image = Load.loadImage(Load.STRONG_BULLET_IMAGE);
	}
	
	
	

}
