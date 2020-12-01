package Codes;

import GameObjects.GameObject;
import GameObjects.ID;
import GameObjects.Player;
import GameObjects.SmallShot;
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
        System.out.println("cunt");
        GameObject player = handler.objects.get(1);
        double playerX = player.getX();
        double playerY = player.getY();

        double mouseX = e.getX();
        double mouseY = e.getY();

        double theta = Math.atan2((mouseY-playerY),(mouseX - playerX));

        double velX = (SmallShot.SMALLSHOT_VELOCITY) * Math.cos(theta);
        double velY = (SmallShot.SMALLSHOT_VELOCITY) * Math.sin(theta);

        SmallShot shot = new SmallShot((int)playerX + (Player.PLAYER_SIZE/3),(int)playerY + (Player.PLAYER_SIZE/3), ID.SMALLSHOT, handler);
        //System.out.println("Player X and Y: " + playerX + " " + playerY + " mouse X and Y: " + mouseX+ " " + mouseY + " Theta: " + theta);
        //System.out.println("X and Y velocities: " + velX + " " + velY);
        shot.setVelX(velX);
        shot.setVelY(velY);
        handler.objects.add(shot);
    }
}
