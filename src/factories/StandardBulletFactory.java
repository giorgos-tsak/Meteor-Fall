package factories;

import gameobjects.StandardBullet;
import gameobjects.Weapon;

public class StandardBulletFactory extends BulletFactory{	

	
	public StandardBulletFactory(Weapon weapon) {
		super(weapon);
	}
	

//	@Override
//	public Bullet createBullet() {
//
//		if(!onCooldown()) {
//			return new StandardBullet(weapon.getPlayer());
//		}
//		return null;
//	}


	@Override
	public Creatable create() {
		if(!onCooldown()) {
			return new StandardBullet(20,20,weapon);
		}
		return null;
	}
	

	

}
