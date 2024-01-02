package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel{
	
	
	Game game;
	MouseInputs mouseInputs;
	public GamePanel(Game game) {
		this.game = game;
		mouseInputs = new MouseInputs(game);
		this.setPreferredSize(new Dimension(Game.GAME_WIDTH,Game.GAME_HEIGHT));
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.addKeyListener(new KeyboardInputs(game));
		this.addMouseListener(mouseInputs);
		this.addMouseMotionListener(mouseInputs);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}
	

}
