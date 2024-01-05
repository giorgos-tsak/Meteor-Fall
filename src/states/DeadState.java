package states;

import main.Game;
import ui.GameText;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class DeadState extends State implements GameState{

    private GameText deadText = new GameText("YOU ARE DEAD", (int) (Game.GAME_WIDTH*0.5)-100,100,200,100,
            new Font("Arial", Font.BOLD, 32),false);
    private GameText homeText = new GameText("HOME", (int) (Game.GAME_WIDTH*0.3)-100,300,200,100,
            new Font("Arial", Font.BOLD, 32),true);
    private GameText restartText = new GameText("RESTART", (int) (Game.GAME_WIDTH*0.6),300,200,100,
            new Font("Arial", Font.BOLD, 32),true);
    public DeadState(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        deadText.render(g);
        restartText.render(g);
        homeText.render(g);
    }

    @Override
    public void update() {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(isIn(e,homeText)){
            homeText.setMousePressed(true);
            game.setCurrentState(new HomeState(game));
        }
        else if(isIn(e,restartText)){
            restartText.setMousePressed(true);
            game.setCurrentState(new PlayingState(game));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        homeText.setMousePressed(false);
        restartText.setMousePressed(false);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        homeText.setMouseOver(false);
        restartText.setMouseOver(false);
        if(isIn(e,homeText)){
            homeText.setMouseOver(true);
        }
        else if(isIn(e,restartText)){
            restartText.setMouseOver(true);
        }
    }
}
