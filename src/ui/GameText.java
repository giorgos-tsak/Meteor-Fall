package ui;

import utilz.Load;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameText extends GameUiComponent{

    private String text;
    private Font font;
    private boolean border;
    public GameText(String text, int x,int y,int width,int height,Font font,boolean border) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.font = font;
        this.border = border;
        bounds = new Rectangle(x,y,width,height);
    }
    public void update() {


    }

    public void render(Graphics g) {
        if(mousePressed){
            g.setColor(Color.BLUE);
        }
        else if(mouseOver){
            g.setColor(Color.RED);
        }
        else{
            g.setColor(Color.GREEN);
        }

        if(border){
            g.drawRect(x, y, width, height);
        }
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(this.text);
        int textHeight = fontMetrics.getHeight();

        // Calculate x-coordinate to center text horizontally
        int centerX = x + (width - textWidth) / 2;

        // Calculate y-coordinate to center text vertically
        int centerY = y + (height - textHeight) / 2 + fontMetrics.getAscent();

        g.drawString(this.text, centerX, centerY);
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

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
