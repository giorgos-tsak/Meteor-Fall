package factories;

import gameobjects.Weapon;

public abstract class BulletFactory extends Factory{

	protected Weapon weapon;
	
	public BulletFactory(Weapon weapon) {
		this.weapon = weapon;
	}
	

	
	
	public boolean onCooldown() {
		currentTime = System.currentTimeMillis();
		elapsedTime = (currentTime-creationTime)/1000.0;
		if(elapsedTime>=weapon.getFireCooldown()) {
			creationTime = System.currentTimeMillis();
			return false;
		}
		return true;
	}
	


}
