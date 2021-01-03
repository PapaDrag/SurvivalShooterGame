package Engine;


import Codes.Game;
import Codes.WaveManager;
import Engine.Entities.GameObject;
import Engine.Entities.Shots.Shot;

import java.awt.*;
import java.util.LinkedList;

/**
 * Goes through data to create a render and stuff idk retard
 */
public class Handler {

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    public Timer timer;
    public WaveManager waveManager;
    public int mouseX,mouseY;
    public Game game;


    public Handler(Timer timer, Game game){
        this.game = game;
        this.timer = timer;
        this.waveManager = new WaveManager(this);
    }

    public void tick() {
        timer.tick();
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
            //Check to remove shots MOVE THIS TO THE SHOT CLASS TICK
            if (tempObject instanceof Shot){
                if (tempObject.getX() < 0 || tempObject.getX() > Game.WIDTH || tempObject.getY() < 0 || tempObject.getY() > Game.HEIGHT) {
                    objects.remove(tempObject);
                }
            }
        }
    }


    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void startGame(){
        waveManager.startWaves();
    }


    public void removeObject(GameObject object){
        this.objects.remove(object);
    }

    public void resetGame(){
        game.initializeGame();
    }
}


