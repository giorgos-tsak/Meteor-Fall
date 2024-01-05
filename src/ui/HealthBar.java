package ui;

import java.awt.*;
import java.awt.image.BufferedImage;

import gameobjects.Player;
import utilz.Load;

public class HealthBar {
	
	BufferedImage image;
	private int healthWidth;
	private int maxWidth;
	private int healthBarWidth,healthBarHeight;
	private int healthBarX,healthBarY;
	private Player player;
	public HealthBar(Player player) {
		this.player = player;
		image = Load.loadImage(Load.HEALTH_BAR_IMAGE);
		healthBarWidth = 200;
		healthBarHeight = 50;
		healthBarX = 0;
		healthBarY = 0;
		maxWidth=healthBarWidth-(int)(healthBarWidth/3.6);

	}
	
	
	public void render(Graphics g) {
		Graphics graphics = g.create();
		
		graphics.setColor(Color.red);
		graphics.fillRect(healthBarWidth/4+healthBarX, (int)(healthBarHeight/3.3)+healthBarY, healthWidth, (int)(healthBarHeight/2.5));
		graphics.drawImage(image,healthBarX,healthBarY,healthBarWidth,healthBarHeight,null);

		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial", Font.BOLD, 16));

		String healthText = player.getHealth()+"/ "+player.getMaxHealth();
		FontMetrics fontMetrics = graphics.getFontMetrics();
		int textWidth = fontMetrics.stringWidth(healthText);
		int textX = (healthBarWidth - textWidth) / 2;
		int textY = healthBarHeight / 2 + fontMetrics.getAscent();

		graphics.drawString(healthText, healthBarX + textX, healthBarY + textY);

	}
	
	public void update() {
		updateHealthWidth();
	}
	
	public void updateHealthWidth() {
		healthWidth = maxWidth*player.getHealth()/player.getMaxHealth();
	}

}
