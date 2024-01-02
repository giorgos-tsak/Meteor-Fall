package gameobjects;

import java.util.Random;

import factories.Creatable;
import main.Game;

public class Meteor extends GameObject implements Creatable{
	
	
	private int health;
	private boolean destroyed;
	private double hitCooldown;
	protected int damage = 20;
	public Meteor(int width, int height) {
		super(width, height);
		Random random = new Random();
		width = 80;
		heigth = 70;
		x = random.nextInt(Game.GAME_WIDTH-width);
		y = 0;
		health=100;
		hitCooldown=1;
	}
	
	public void update(Player player) {
		super.update();
		updatePosition();
		attack(player);
		attackedBy(player);
	}
	
	
	private long currentTime = System.currentTimeMillis();
	private long hitTime = System.currentTimeMillis();
	private double elapsedTime;
	public void attack(Player player) {
		currentTime = System.currentTimeMillis();
		elapsedTime = (currentTime-hitTime)/1000.0;
		if(this.getHitbox().intersects(player.getHitbox())) {
			if(elapsedTime>=hitCooldown) {
				hitTime = System.currentTimeMillis();
				player.setHealth(player.getHealth()-damage);
				System.out.println("hit");
			}
		}
	}
	
	public void attackedBy(Player player) {
		for (int i = 0; i < player.getWeapon().getBulletList().getBullets().size(); i++) {
			Bullet currentBullet  = player.getWeapon().getBulletList().getBullets().get(i);
			if(currentBullet.hitbox.intersects(this.hitbox)) {
				if(!player.getWeapon().Ispiercing()) {
					this.health-=currentBullet.getDamage();
					player.getWeapon().getBulletList().getBullets().remove(i);
				}
				else {
					currentBullet.checkMeteorHit(this);
				}
				if(this.health<=0) {
					destroyed = true;
				}
			}
		}
	}
	
	
	
	
	public void updatePosition() {
		y+=speed;
	}
	

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public boolean isDestroyed() {
		return destroyed;
	}
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	
}
