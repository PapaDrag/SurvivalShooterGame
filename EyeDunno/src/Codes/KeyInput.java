package Codes;

import GameObjects.GameObject;
import GameObjects.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;


public class KeyInput extends KeyAdapter {


    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        System.out.println(key);

        for (int i = 0; i<handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);

            //PLAYER MOVES
            if (tempObject.getID() == ID.PLAYER){
                switch (key){
                    case 87:
                        tempObject.setVelY(-5);
                        tempObject.setVelX(0);
                    case 65:
                        tempObject.setVelX(-5);
                        tempObject.setVelY(0);
                    case 83:
                        tempObject.setVelY(5);
                        tempObject.setVelX(0);
                    case 68:
                        tempObject.setVelX(5);
                        tempObject.setVelY(0);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e){

    }


}
