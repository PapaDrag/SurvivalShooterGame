package GameObjects.Entities;

import Codes.Handler;
import GameObjects.Entities.Enemy;
import GameObjects.Entities.ID;
import GameObjects.Entities.Player;

import java.awt.*;

public class RegularEnemy extends Enemy {

    private static final int maxHealth = 100;
    private static final int size = 30;
    private static final int speed = 2;


    public RegularEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.health = maxHealth;
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect((int)x,(int)y,size,size);
        g.setColor(Color.BLACK);
        g.fillRect((int)(x-10),(int)(y-10),(int)((size+20)*((double)health/(double)maxHealth)),7);
    }

    @Override
    public void tick(){
        Player player = (Player)handler.objects.get(0);
        double playerX = player.getX();
        double playerY = player.getY();

        double enemyX = getX();
        double enemyY = getY();

        double theta = Math.atan2((enemyY-playerY),(enemyX - playerX));

        velX = -(speed) * Math.cos(theta);
        velY = -(speed) * Math.sin(theta);
        x += velX;
        y += velY;
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,size,size);
    }

}
