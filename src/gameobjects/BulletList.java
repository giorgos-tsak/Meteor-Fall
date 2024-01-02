package gameobjects;

import java.awt.Graphics;
import java.util.ArrayList;

import factories.BulletFactory;
import factories.StandardBulletFactory;
import factories.StrongBulletFactory;
import main.Game;

public class BulletList {
	
	private ArrayList<Bullet> bullets;
	private BulletFactory bulletFactory;
	public BulletList(Weapon weapon) {
		bullets = new ArrayList<>();
		bulletFactory = new StrongBulletFactory(weapon);
	}
	
	public void update() {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update();
		}
		removeBullet();
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
	
	public void addBullet() {
		Bullet bullet = (Bullet)bulletFactory.create();
		if(bullet!=null) {
			bullets.add(bullet);
		}
	}
	
	public void removeBullet() {
		for (int i = 0; i < bullets.size(); i++) {
			if(bullets.get(i).y+bullets.get(i).getHeigth()<0) {
				bullets.remove(i);
			}
		}
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	

}
