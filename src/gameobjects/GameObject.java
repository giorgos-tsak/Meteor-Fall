package gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;

public class GameObject {
	
	protected float x,y;
	protected float speed;
	protected int width,heigth;
	protected BufferedImage image;
	protected Rectangle hitbox;
	
	public GameObject(int width, int height) {
		this.width = width;
		this.heigth = height;
		initHitbox();
	}
	
	public void render(Graphics g) {
		g.drawImage(image,(int)x,(int)y,width,heigth,null);

	}
	
	public void update() {
		updateHitbox();
	}
	
	public void updateHitbox() {
		hitbox.x = (int)x;
		hitbox.y = (int)y;
	}
	
	public void initHitbox() {
		hitbox = new Rectangle((int)x, (int)y, width, heigth);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	
	

}
