package Engine.Entities.Shots;

import Engine.Handler;
import Engine.Entities.Enemies.Enemy;
import Engine.Entities.GameObject;
import Engine.Entities.ID;

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


}

