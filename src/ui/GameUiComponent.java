package ui;

import java.awt.*;

public class GameUiComponent {

    protected Rectangle bounds;
    protected int width,height;
    protected boolean mouseOver,mousePressed;
    protected int x,y;
    public Rectangle getBounds() {
        return bounds;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
}
