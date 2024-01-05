package states;

import main.Game;
import ui.GameText;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StatsState extends State implements GameState{

    private GameText backText = new GameText("BACK",0,30,100,50,
            new Font("Arial", Font.BOLD, 32),true);
    private GameText statsText = new GameText("STATS",Game.GAME_WIDTH/4-100,100,200,50,
            new Font("Arial", Font.BOLD, 32),false);
    private GameText pointsText = new GameText("POINTS: ",Game.GAME_WIDTH/4+100,100,100,50,
            new Font("Arial", Font.BOLD, 32),false);
    private GameText currentPoints = new GameText(String.valueOf(game.getStats().getExperiencePoints()),Game.GAME_WIDTH/4+200,100,50,50,
            new Font("Arial", Font.BOLD, 32),false);
    private GameText damageText = new GameText("DAMAGE",Game.GAME_WIDTH/4-100,200,200,50,
            new Font("Ariatext", Font.BOLD, 32),false);
    private GameText healthText = new GameText("HEALTH",Game.GAME_WIDTH/4-100,300,200,50,
            new Font("Ariatext", Font.BOLD, 32),false);
    private GameText speedText= new GameText("SPEED",Game.GAME_WIDTH/4-100,400,200,50,
            new Font("Arial", Font.BOLD, 32),false);
    private GameText currentDamageText = new GameText(String.valueOf(game.getStats().getDamage()),Game.GAME_WIDTH/4+50,200,200,50,
            new Font("Ariatext", Font.BOLD, 32),false);
    private GameText currentHealthText = new GameText(String.valueOf(game.getStats().getHealth()),Game.GAME_WIDTH/4+50,300,200,50,
            new Font("Ariatext", Font.BOLD, 32),false);
    private GameText currentSpeedText= new GameText(String.valueOf(game.getStats().getSpeed()),Game.GAME_WIDTH/4+50,400,200,50,
            new Font("Arial", Font.BOLD, 32),false);
    private GameText damagePlus = new GameText("+",Game.GAME_WIDTH/4+200,200,50,50,
            new Font("Arial", Font.BOLD, 48),false);
    private GameText healthPlus = new GameText("+",Game.GAME_WIDTH/4+200,300,50,50,
            new Font("Arial", Font.BOLD, 48),false);
    private GameText speedPlus = new GameText("+",Game.GAME_WIDTH/4+200,400,50,50,
            new Font("Arial", Font.BOLD, 48),false);

    public StatsState(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {

        backText.render(g);
        statsText.render(g);
        pointsText.render(g);
        currentPoints.render(g);

        damageText.render(g);
        healthText.render(g);
        speedText.render(g);

        currentDamageText.render(g);
        currentHealthText.render(g);
        currentSpeedText.render(g);

        damagePlus.render(g);
        healthPlus.render(g);
        speedPlus.render(g);

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
        if(isIn(e,backText)){
            backText.setMousePressed(true);
            game.setCurrentState(new HomeState(game));
        }

        int point = Integer.parseInt(currentPoints.getText());
        if(point>0){

            if(isIn(e,damagePlus) && game.getStats().getDamage()<10){
                damagePlus.setMousePressed(true);
                game.getStats().setDamage(game.getStats().getDamage()+1);
                currentDamageText.setText(String.valueOf(game.getStats().getDamage()));

            }
            else if(isIn(e,healthPlus) && game.getStats().getHealth()<10){
                healthPlus.setMousePressed(true);
                game.getStats().setHealth(game.getStats().getHealth()+1);
                currentHealthText.setText(String.valueOf(game.getStats().getHealth()));

            }
            else if(isIn(e,speedPlus) && game.getStats().getSpeed()<10){
                speedPlus.setMousePressed(true);
                game.getStats().setSpeed(game.getStats().getSpeed()+1);
                currentSpeedText.setText(String.valueOf(game.getStats().getSpeed()));
            }

            point--;
            game.getStats().setExperiencePoints(game.getStats().getExperiencePoints()-1);
            currentPoints.setText(String.valueOf(point));
        }



    }

    @Override
    public void mouseReleased(MouseEvent e) {
        backText.setMousePressed(false);
        damagePlus.setMousePressed(false);
        healthPlus.setMousePressed(false);
        speedPlus.setMousePressed(false);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        backText.setMouseOver(false);
        damagePlus.setMouseOver(false);
        healthPlus.setMouseOver(false);
        speedPlus.setMouseOver(false);
        if(isIn(e,backText)){
            backText.setMouseOver(true);
        }
        else if(isIn(e,damagePlus)){
            damagePlus.setMouseOver(true);
        }
        else if(isIn(e,healthPlus)){
            healthPlus.setMouseOver(true);
        }
        else if(isIn(e,speedPlus)){
            speedPlus.setMouseOver(true);
        }
    }
}
