package Engine;

import Codes.Game;
import Engine.Entities.GameObject;
import Engine.Entities.ID;
import Engine.Entities.Player;
import Engine.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

    private Handler handler;
    private static Boolean W,A,S,D; //true if held down
    private Game game;

    public KeyInput(Handler handler, Game game){
        this.game = game;
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
                            tempObject.setVelY(Player.PLAYER_VELOCITY * -1);
                        break;

                    case 65://A
                        A = true;
                        if (D)
                            tempObject.setVelX(0);
                        else
                            tempObject.setVelX(Player.PLAYER_VELOCITY * -1);
                        break;

                    case 83://S
                        S = true;
                        if (W)
                            tempObject.setVelY(0);
                        else
                            tempObject.setVelY(Player.PLAYER_VELOCITY);
                        break;

                    case 68://D
                        D = true;
                        if (A)
                            tempObject.setVelX(0);
                        else
                            tempObject.setVelX(Player.PLAYER_VELOCITY);
                        break;

                    case KeyEvent.VK_R: //R
                        Player player = (Player)tempObject;
                        player.reload();
                        break;

                    case KeyEvent.VK_P: //P
                        System.out.println("cunt");
                        game.pause();
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
                            tempObject.setVelY(Player.PLAYER_VELOCITY);
                        else
                            tempObject.setVelY(0);
                        break;

                    case 65://A
                        A = false;
                        if (D)
                            tempObject.setVelX(Player.PLAYER_VELOCITY);
                        else
                            tempObject.setVelX(0);
                        break;

                    case 83://S
                        S = false;
                        if (W)
                            tempObject.setVelY(Player.PLAYER_VELOCITY * -1);
                        else
                            tempObject.setVelY(0);
                        break;

                    case 68://D
                        D = false;
                        if (A)
                            tempObject.setVelX(Player.PLAYER_VELOCITY * -1);
                        else
                            tempObject.setVelX(0);
                        break;

                }
            }
        }
    }

}
