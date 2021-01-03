package Engine.Entities.Shots;

import Engine.Handler;
import Engine.Entities.Enemies.Enemy;
import Engine.Entities.GameObject;
import Engine.Entities.ID;
import Engine.Entities.Player;

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


}
