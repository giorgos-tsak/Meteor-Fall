package main;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	public Frame(GamePanel gamePanel) {
		
		this.add(gamePanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
