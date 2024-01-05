package main;

import java.awt.Graphics;

import states.*;

public class Game implements Runnable {

	private GamePanel gamePanel;
	private Frame frame;

	private Thread gameThread;
	private final int FPS = 120;
	private final int UPS = 200;

	public static final int GAME_WIDTH = 700;
	public static final int GAME_HEIGHT = 800;

	private GameState currentState;
	private Stats stats;

	public Game() {
		stats = new Stats();
		currentState = new HomeState(this);
		gamePanel = new GamePanel(this);
		frame = new Frame(gamePanel);
		startGameLoop();
	}

	public void render(Graphics g) {
		currentState.render(g);
	}

	public void update() {
		currentState.update();
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS;
		double timePerUpdate = 1000000000.0 / UPS;

		long previousTime = System.nanoTime();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {

			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;
			if (deltaU >= 1) {
				update();
				deltaU--;
			}
			if (deltaF >= 1) {
				deltaF--;
				gamePanel.repaint();
			}


		}

	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();

	}

	public GameState getCurrentState() {
		return currentState;
	}
	public void setCurrentState(GameState currentState) {
		this.currentState = currentState;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
}
