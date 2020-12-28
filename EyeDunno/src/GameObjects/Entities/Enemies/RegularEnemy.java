package GameObjects.Entities.Enemies;

import Codes.Handler;
import GameObjects.Entities.Enemies.Enemy;
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
    public void givePlayerScore() {
        Player player = (Player)handler.objects.getFirst();
        player.addScore(10);
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect((int)x,(int)y,size,size);
        g.setColor(Color.RED);
        g.fillRect((int)(x-10),(int)(y-10),(int)((size+20)*((double)health/(double)maxHealth)),7);
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x-1,(int)y-1,size+2,size+2);
    }

}
