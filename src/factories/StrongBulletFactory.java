package factories;


import gameobjects.StrongBullet;
import gameobjects.Weapon;

public class StrongBulletFactory extends BulletFactory{

	
	public StrongBulletFactory(Weapon weapon) {
		super(weapon);
	}
	


	@Override
	public Creatable create() {
		if(!onCooldown()) {
			return new StrongBullet(40,40,weapon);
		}
		return null;
	}

}
