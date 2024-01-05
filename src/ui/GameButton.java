package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import utilz.Load;

public class GameButton extends GameUiComponent{

	protected Rectangle bounds;
	protected int width,height;
	private int rowIndex,columnIndex;
	private BufferedImage[] animations;

	
	public GameButton(int x,int y,int width,int height,int columnIndex) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.columnIndex = columnIndex;
		bounds = new Rectangle(x,y,width,height);
		loadAnimation();
	}
	
	
	public void update() {
		rowIndex=0;
		if(mouseOver) {
			rowIndex=1;
		}
		if(mousePressed) {
			rowIndex=2;
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[rowIndex],x,y,width,height,null);
	}
	
	private void loadAnimation() {
		BufferedImage image = Load.loadImage(Load.PAUSE_BUTTONS_IMAGE);
		animations = new BufferedImage[3];
		for (int i = 0; i < animations.length; i++) {
			animations[i] = image.getSubimage(45*i, 43*columnIndex, 45, 43);
		}
		
	}
	
	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}
	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}
	public Rectangle getBounds() {
		return bounds;
	}

}
