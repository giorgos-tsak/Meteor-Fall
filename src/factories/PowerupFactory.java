package factories;

import java.util.Random;

import gameobjects.HealPowerup;
import gameobjects.PiercePowerup;
import gameobjects.Powerup;

public class PowerupFactory extends Factory{

	private double createCooldown = 4;
	
	@Override
	public Powerup create() {
		
		currentTime = System.currentTimeMillis();
		elapsedTime = (currentTime-creationTime)/1000.0;
		if(elapsedTime>=createCooldown) {	
			creationTime = System.currentTimeMillis();
			Random random = new Random();
			int randomNum = random.nextInt(100);
			if(randomNum<=30) {
				return new HealPowerup(60, 60);
			}
			else {
				return new PiercePowerup(60, 60);
			}
		}
		
		
		return null;
	}

}
