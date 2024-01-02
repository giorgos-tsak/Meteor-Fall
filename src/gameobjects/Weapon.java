package gameobjects;

import java.awt.Graphics;

public class Weapon {
	
	private float fireCooldown;
	private boolean piercing;
	private BulletList bulletList;
	private Player player;
	private double pierceDuration;
	
	public Weapon(Player player) {
		this.player = player;
		fireCooldown = 0.5f;
		bulletList = new BulletList(this);
		pierceDuration = 3;
	}
	
	public void update() {
		shoot();
		checkPierce();
		bulletList.update();
	}
	
	public void render(Graphics g) {
		bulletList.render(g);
	}
	
	public void shoot() {
		if(player.isShooting()) {
			bulletList.addBullet();
		}
	}
	
	private long currentTime,pierceTime;
	private double elapsedTime;
	
	public void checkPierce() {
		currentTime=System.currentTimeMillis();
		elapsedTime = (currentTime-pierceTime)/1000.0;
		if(elapsedTime>=pierceDuration) {
			piercing=false;
		}
		
		
	}
	
	public void setPierceTime(long pierceTime) {
		this.pierceTime = pierceTime;
	}
	public boolean Ispiercing() {
		return piercing;
	}
	public void setPiercing(boolean piercing) {
		this.piercing = piercing;
	}
	public float getFireCooldown() {
		return fireCooldown;
	}
	public Player getPlayer() {
		return player;
	}
	public BulletList getBulletList() {
		return bulletList;
	}
	
}
