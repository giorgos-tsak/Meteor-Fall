package gameobjects;



import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import main.Game;
import main.Stats;
import ui.ExperienceBar;
import ui.HealthBar;
import utilz.Load;

public class Player extends GameObject{
	
	private float speed;
	private boolean up,down,left,right;
	private boolean isShooting;
	private Weapon weapon;
	private int currentExperience;
	private int health;
	private int maxHealth;
	private HealthBar healthBar;
	private ExperienceBar experienceBar;
	private boolean isAlive = true;
	private boolean frozen = false;
	private Stats stats;
	
	public Player(int width, int height, Stats stats) {
		super(width, height);
		image = Load.loadImage(Load.PLAYER_IMAGE);
		x=Game.GAME_WIDTH/2-width/2;
		y = Game.GAME_HEIGHT-heigth;
		healthBar = new HealthBar(this);
		experienceBar = new ExperienceBar(this);
		this.stats = stats;
		speed = (float) (2+(stats.getSpeed()*0.2));
		maxHealth=100+((stats.getHealth()-1)*20);
		weapon = new Weapon(this);
		health = maxHealth;
		currentExperience = 0;

	}
	
	@Override
	public void update() {
		super.update();
		checkAlive();
		checkFrozen();
		healthBar.update();
		experienceBar.update();
		updatePosition();
		weapon.update();
		levelUp();
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		healthBar.render(g);
		experienceBar.render(g);
		weapon.render(g);
	}
	
	public void updatePosition(){
		if(up && y>0) {
			y-=speed;
		}
		if(down && y+heigth<Game.GAME_HEIGHT) {
			y+=speed;
		}
		if(left && x>0) {
			x-=speed;
		}
		if(right && x+width<Game.GAME_WIDTH) {
			x+=speed;
		}
		
	}

	public void levelUp(){
		if(currentExperience>= stats.getLvl()*100){
			stats.setLvl(stats.getLvl()+1);
			stats.setExperiencePoints(stats.getExperiencePoints()+1);
			currentExperience=0;
		}

	}

	private long freezeTime;
	public void checkFrozen(){
		long currentTime = System.currentTimeMillis();
		double elapsedTime = (currentTime-freezeTime)/1000.0;
		if(elapsedTime<=1){
			stop();
		}
	}

	public void stop(){
		up = false;
		down = false;
		left = false;
		right = false;
	}


	public void checkAlive(){
		if(this.health<=0){
			this.health = 0;
			isAlive = false;
		}
	}


	public void setFreezeTime(long freezeTime) {
		this.freezeTime = freezeTime;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isShooting() {
		return isShooting;
	}
	public void setShooting(boolean isShooting) {
		this.isShooting = isShooting;
	}
	public Weapon getWeapon() {
		return weapon;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public int getCurrentExperience() {
		return currentExperience;
	}

	public void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}
}
