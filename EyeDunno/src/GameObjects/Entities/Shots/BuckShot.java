package GameObjects.Entities.Shots;

import Codes.Handler;
import GameObjects.Entities.Enemies.Enemy;
import GameObjects.Entities.Enemies.RegularEnemy;
import GameObjects.Entities.GameObject;
import GameObjects.Entities.ID;

import java.awt.*;

public class BuckShot extends Shot {

    public BuckShot(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        velocity = 15;
        size = 7;
        damage = 6;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        Collision();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE.darker());
        g.fillRect((int)x,(int)y, size, size);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, size, size);
    }

    @Override
    public void Collision() {
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

