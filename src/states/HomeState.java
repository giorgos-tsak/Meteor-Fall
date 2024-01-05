package states;

import main.Game;
import ui.GameText;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class HomeState extends State implements GameState{

    GameText startGameText = new GameText("START GAME", (int) (Game.GAME_WIDTH*0.3)-100,200,100,50,null,true);
    GameText statsText = new GameText("STATS",(int) (Game.GAME_WIDTH*0.6)-100,200,100,50,null,true);
    GameText  leaderBoardText = new GameText("LEADERBOARD",(int) (Game.GAME_WIDTH*0.9)-100,200,100,50,null,true);
    public HomeState(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        startGameText.render(g);
        statsText.render(g);
        leaderBoardText.render(g);
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
        if(isIn(e,startGameText)){
            startGameText.setMousePressed(true);
            game.setCurrentState(new PlayingState(game));
        }
        else if(isIn(e,statsText)){
            statsText.setMousePressed(true);
            game.setCurrentState(new StatsState(game));
        }
        else if(isIn(e,leaderBoardText)){
            leaderBoardText.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        startGameText.setMousePressed(false);
        statsText.setMousePressed(false);
        leaderBoardText.setMousePressed(false);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        startGameText.setMouseOver(false);
        statsText.setMouseOver(false);
        leaderBoardText.setMouseOver(false);
        if(isIn(e,startGameText)){
            startGameText.setMouseOver(true);
        }
        else if(isIn(e,statsText)){
            statsText.setMouseOver(true);
        }
        else if(isIn(e,leaderBoardText)){
            leaderBoardText.setMouseOver(true);
        }

    }
}
