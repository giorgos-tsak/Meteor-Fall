package factories;

import java.util.Random;

import gameobjects.IceMeteor;
import gameobjects.TrackingMeteor;

public class MeteorFactory extends Factory{
	
	
	protected int creationCooldown;
	
	public MeteorFactory() {
		creationCooldown = 1;
	}
	
	@Override
	public Creatable create() {
		currentTime = System.currentTimeMillis();
		elapsedTime = (currentTime-creationTime)/1000.0;
		if(elapsedTime>=creationCooldown)
		{			
			creationTime = System.currentTimeMillis();
			Random random = new Random();
			int randomNum = random.nextInt(100);
			if(randomNum<=70) {
				return new IceMeteor(60, 60);
			}
			else {
				return new TrackingMeteor(60, 60);
			}
		}
		return null;
	}
	

}
