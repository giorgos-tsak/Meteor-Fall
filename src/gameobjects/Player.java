package gameobjects;



import java.awt.Graphics;
import main.Game;
import ui.HealthBar;
import utilz.Load;

public class Player extends GameObject{
	
	private float speed;
	private boolean up,down,left,right;
	private boolean isShooting;
	private Weapon weapon;
	private int health;
	private HealthBar healthBar;
	
	public Player(int width, int height) {
		super(width, height);
		image = Load.loadImage(Load.PLAYER_IMAGE);
		x=Game.GAME_WIDTH/2-width/2;
		y = Game.GAME_HEIGHT-heigth;
		speed = 2f;
		weapon = new Weapon(this);
		healthBar = new HealthBar(this);
		health=100;

	}
	
	@Override
	public void update() {
		super.update();
		healthBar.update();
		updatePosition();
		weapon.update();
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		healthBar.render(g);
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
	
	

}
