package GameObjects.Entities.Enemies;

import Codes.Handler;
import GameObjects.Entities.ID;
import GameObjects.Entities.Player;

import java.awt.*;

public class FastEnemy extends Enemy {

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        maxHealth = 60;
        size = 10;
        speed = 4;
        health = maxHealth;
    }

    @Override
    public void givePlayerScore() {
        Player player = (Player)handler.objects.getFirst();
        player.addScore(30);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)x,(int)y,size,size);
        g.setColor(Color.RED);
        g.fillRect((int)(x-10),(int)(y-10),(int)((size+20)*((double)health/(double)maxHealth)),7);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x-1,(int)y-1,size+2,size+2);
    }
}
