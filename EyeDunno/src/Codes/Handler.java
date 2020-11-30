package Codes;


import GameObjects.GameObject;

import java.awt.*;
import java.util.LinkedList;

/**
 * Goes through data to create a render and stuff idk retard
 */
public class Handler {

    LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
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

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
}


