package Codes;


import GameObjects.Entities.GameObject;
import GameObjects.Entities.ID;

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


    public Handler(Timer timer){

        this.timer = timer;
        this.waveManager = new WaveManager(this);
    }

    public void tick() {
        timer.tick();
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
            //Check to remove shots
            if (tempObject.getID() == ID.SMALLSHOT){
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
}


