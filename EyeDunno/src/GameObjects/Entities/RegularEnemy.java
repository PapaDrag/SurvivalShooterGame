package GameObjects.Entities;

import Codes.Handler;
import GameObjects.Entities.Enemy;
import GameObjects.Entities.ID;
import GameObjects.Entities.Player;

import java.awt.*;

public class RegularEnemy extends Enemy {


    public RegularEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        maxHealth = 100;
        this.health = maxHealth;
        size = 30;
        speed = 2;
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect((int)x,(int)y,size,size);
        g.setColor(Color.RED);
        g.fillRect((int)(x-10),(int)(y-10),(int)((size+20)*((double)health/(double)maxHealth)),7);
    }

    @Override
    public void tick(){
        Player player = (Player)handler.objects.getFirst();
        double playerX = player.getX();
        double playerY = player.getY();
        double enemyX = getX();
        double enemyY = getY();
        double theta = Math.atan2((enemyY-playerY),(enemyX - playerX));
        velX = -(speed) * Math.cos(theta);
        velY = -(speed) * Math.sin(theta);
        oldX = (int)x;
        oldY = (int)y;
        x += velX;
        y += velY;
        //Collision(); work in progress
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x-1,(int)y-1,size+2,size+2);
    }

}
