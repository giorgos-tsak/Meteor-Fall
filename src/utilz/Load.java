package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Load {

	public static final String PLAYER_IMAGE = "spaceship.png";
	public static final String STANDARD_BULLET_IMAGE = "bullet.png";
	public static final String STRONG_BULLET_IMAGE = "strongBullet.png";
	public static final String METEOR_IMAGE = "meteor.png";
	public static final String ICE_METEOR_IMAGE = "iceMeteor.png";
	public static final String TRACKING_METEOR_IMAGE = "trackingMeteor.png";
	public static final String HEAL_IMAGE = "heal.png";
	public static final String PIERCE_IMAGE = "pierce.png";
	public static final String HEALTH_BAR_IMAGE = "healthBar.png";
	public static final String PAUSE_BUTTONS_IMAGE = "pauseButtons.png";
	
	public static BufferedImage loadImage(String fileName) {
		
		BufferedImage image = null;
		InputStream inputStream  = Load.class.getResourceAsStream("/"+fileName);
		
		try {
			image = ImageIO.read(inputStream);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				inputStream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return image;
	}
	
}
