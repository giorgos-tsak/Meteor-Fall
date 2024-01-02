package gameobjects;

import java.util.Random;

import factories.Creatable;
import main.Game;

public abstract class Powerup extends GameObject implements Creatable{

	protected boolean activated;
	
	public Powerup(int width, int height) {
		super(width, height);
		Random random = new Random();
		x = random.nextInt(Game.GAME_WIDTH-width);
		y=0;
		speed = 1.5f;
	}
	
	public void update(Player player) {
		super.update();
		updatePosition();
		power(player);
		
	}
	
	public void updatePosition() {
		y+=speed;
	}
	
	public abstract void power(Player player);
	

}
