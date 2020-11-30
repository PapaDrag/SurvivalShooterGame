package Codes;

import GameObjects.GameObject;
import GameObjects.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.TreeMap;


public class KeyInput extends KeyAdapter {

    private Handler handler;
    private static Boolean W,A,S,D; //true if held down

    public KeyInput(Handler handler){
        this.handler = handler;
        W = false;
        A = false;
        S = false;
        D = false;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i<handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);

            //PLAYER MOVES
            if (tempObject.getID() == ID.PLAYER){
                switch (key){
                    case 87://W
                        W = true;
                        if (S)
                            tempObject.setVelY(0);
                        else
                            tempObject.setVelY(-2);
                        break;

                    case 65://A
                        A = true;
                        if (D)
                            tempObject.setVelX(0);
                        else
                            tempObject.setVelX(-2);
                        break;

                    case 83://S
                        S = true;
                        if (W)
                            tempObject.setVelY(0);
                        else
                            tempObject.setVelY(2);
                        break;

                    case 68://D
                        D = true;
                        if (A)
                            tempObject.setVelX(0);
                        else
                            tempObject.setVelX(2);
                        break;
                }
            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i<handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);

            //PLAYER MOVES
            if (tempObject.getID() == ID.PLAYER){
                switch (key){
                    case 87://W
                        W = false;
                        if (S)
                            tempObject.setVelY(2);
                        else
                            tempObject.setVelY(0);
                        break;

                    case 65://A
                        A = false;
                        if (D)
                            tempObject.setVelX(2);
                        else
                            tempObject.setVelX(0);
                        break;

                    case 83://S
                        S = false;
                        if (W)
                            tempObject.setVelY(-2);
                        else
                            tempObject.setVelY(0);
                        break;

                    case 68://D
                        D = false;
                        if (A)
                            tempObject.setVelX(-2);
                        else
                            tempObject.setVelX(0);
                        break;
                }
            }
        }
    }

}
