package factories;

import java.util.Random;

import gameobjects.IceMeteor;
import gameobjects.Meteor;
import gameobjects.TrackingMeteor;

public class MeteorFactory extends Factory{
	
	
	private  float creationCoolDown;
	
	public MeteorFactory() {
		creationCoolDown = 1f;
	}
	
	@Override
	public Meteor create() {
		currentTime = System.currentTimeMillis();
		elapsedTime = (currentTime-creationTime)/1000.0;
		if(elapsedTime>=creationCoolDown)
		{			
			creationTime = System.currentTimeMillis();
			Random random = new Random();
			int randomNum = random.nextInt(100);
			if(randomNum<=30) {
				return new IceMeteor(60, 60);
			}
			else if (randomNum <=60){
				return new TrackingMeteor(60, 60);
			}
			else{
				return new Meteor(60,60);
			}
		}
		return null;
	}
	

}
