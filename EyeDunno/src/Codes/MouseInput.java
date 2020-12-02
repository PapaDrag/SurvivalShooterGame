package Codes;

import GameObjects.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Math;


public class MouseInput extends MouseAdapter {

    private Handler handler;

    public MouseInput(Handler handler){
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){

        Player player = (Player)handler.objects.get(0);

        double mouseX = e.getX();
        double mouseY = e.getY();
        player.attemptShoot(mouseX,mouseY);


        /**
         double playerX = player.getX();
        double playerY = player.getY();

        double mouseX = e.getX();
        double mouseY = e.getY();

        double theta = Math.atan2((mouseY-playerY),(mouseX - playerX));

        double velX = (SmallShot.SMALLSHOT_VELOCITY) * Math.cos(theta);
        double velY = (SmallShot.SMALLSHOT_VELOCITY) * Math.sin(theta);

        Shot shot = new SmallShot((int)playerX + (Player.PLAYER_SIZE/3),(int)playerY + (Player.PLAYER_SIZE/3), ID.SMALLSHOT, handler);

        shot.setVelX(velX);
        shot.setVelY(velY);

        handler.objects.add(shot);
**/
    }

}
