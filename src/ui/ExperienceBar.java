package ui;

import gameobjects.Player;
import main.Game;

import java.awt.*;

public class ExperienceBar {

    private int experienceWidth;
    private int maxWidth;
    private int experienceBarWidth, experienceBarHeight;
    private int experienceBarX, experienceBarY;
    private Player player;
    public ExperienceBar(Player player) {
        this.player = player;
        experienceBarWidth = 200;
        experienceBarHeight = 30;
        experienceBarX = Game.GAME_WIDTH-400;
        experienceBarY = 0;
        maxWidth = 200;

    }


    public void render(Graphics g) {
        Graphics graphics = g.create();

        graphics.setColor(Color.white);
        graphics.drawRect( experienceBarX+experienceBarWidth,experienceBarY,maxWidth,experienceBarHeight);
//        graphics.setColor(Color.blue);
//        graphics.fillRect(experienceBarWidth /4+ experienceBarX, (int)(experienceBarHeight /3.3)+ experienceBarY, experienceWidth, (int)(experienceBarHeight /2.5));

        graphics.setColor(Color.blue);
        graphics.fillRect(experienceBarX+experienceBarWidth,experienceBarY,experienceWidth,experienceBarHeight);

        graphics.setColor(Color.white);
        graphics.setFont(new Font("Arial", Font.BOLD, 16));

        String experienceText = player.getCurrentExperience()+"/ "+player.getStats().getLvl()*100;
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(experienceText);
        int textX = (experienceBarWidth - textWidth) / 2;
        int textY = experienceBarHeight / 2 + fontMetrics.getAscent();

        graphics.drawString(experienceText, experienceBarX+experienceBarWidth + textX, experienceBarY + textY);

        String lvlText = "Level " +player.getStats().getLvl();
        textWidth = fontMetrics.stringWidth(lvlText);
        textX = (experienceBarWidth - textWidth) / 2;
        textY = experienceBarHeight  + fontMetrics.getAscent();

        graphics.drawString(lvlText, experienceBarX+experienceBarWidth + textX, experienceBarY + textY);

    }

    public void update() {
        updateExperienceWidth();
    }

    public void updateExperienceWidth() {
        experienceWidth = maxWidth*player.getCurrentExperience()/(player.getStats().getLvl()*100);
    }

}
