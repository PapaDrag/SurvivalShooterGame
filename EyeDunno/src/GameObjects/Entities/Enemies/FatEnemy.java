package GameObjects.Entities.Enemies;

import Codes.Game;
import Codes.Handler;
import GameObjects.Entities.Enemies.Enemy;
import GameObjects.Entities.GunPickup;
import GameObjects.Entities.ID;
import GameObjects.Entities.Player;

import java.awt.*;
import java.util.Random;

public class FatEnemy extends Enemy {

    public FatEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        maxHealth = 600;
        size = 80;
        speed = 1;
        health = maxHealth;

    }

    @Override
    public void givePlayerScore() {
        Player player = (Player)handler.objects.getFirst();
        player.addScore(80);
    }


    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)x,(int)y,size,size);
        g.setColor(Color.RED);
        g.fillRect((int)(x-10),(int)(y-10),(int)((size+20)*((double)health/(double)maxHealth)),7);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x-1,(int)y-1,size+2,size+2);
    }


    @Override
    public void takeDamage(int damage){
        health -= damage;
        if (health <= 0){
            handler.objects.remove(this);
            givePlayerScore();
            Random random = new Random();
            int rand = random.nextInt(10);
            if (rand < 4) {
                int x = 100 + random.nextInt(Game.WIDTH - 200);
                int y = 100 + random.nextInt(Game.HEIGHT - 200);
                handler.addObject(new GunPickup(x, y, ID.GUNPICKUP, handler));
            }
        }
    }
}
