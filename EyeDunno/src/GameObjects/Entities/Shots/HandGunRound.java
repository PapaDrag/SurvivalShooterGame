package GameObjects.Entities.Shots;

import Codes.Handler;
import GameObjects.Entities.Enemies.Enemy;
import GameObjects.Entities.GameObject;
import GameObjects.Entities.ID;
import GameObjects.Entities.Player;

import java.awt.*;

public class HandGunRound extends Shot {



    public HandGunRound(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        velocity = 20;
        size = 10;
        damage = 20;

    }

    @Override
    public void tick() {
        if (velX == 0 && velY == 0) {
            handler.objects.remove(this);
            Player player = (Player)handler.objects.getFirst();
            player.getCurrentGun().addOneRound();
        }
        x += velX;
        y += velY;
        Collision();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int)x,(int)y, size, size);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, size, size);
    }

    public void Collision(){
        try {
            for (GameObject object : handler.objects) {
                if (object.getID() == ID.ENEMY) {
                    if (getBounds().intersects(object.getBounds())) {
                        handler.objects.remove(this);
                        Enemy enemy = (Enemy) object;
                        enemy.takeDamage(damage);
                        break;
                    }
                }
                else if (object.getID() == ID.BLOCK){
                    if (getBounds().intersects(object.getBounds())) {
                        handler.objects.remove(this);
                        break;
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Collision Exception Detected");
        }
    }
}
