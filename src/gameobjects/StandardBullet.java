package gameobjects;



import utilz.Load;

public class StandardBullet extends Bullet{

	
	public StandardBullet(int width, int height,Weapon weapon) {
		super(width,height,weapon.getPlayer());
		image = Load.loadImage(Load.STANDARD_BULLET_IMAGE);
	}
	
	




}
