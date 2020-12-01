package GameObjects;

import Codes.Game;
import Codes.Handler;

import java.awt.*;
import java.util.Collection;

public class SmallShot extends GameObject {

    public static final int SMALLSHOT_VELOCITY = 10;
    public static final int SMALLSHOT_SIZE = 8;

    public SmallShot(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        Collision();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int)x,(int)y,SMALLSHOT_SIZE,SMALLSHOT_SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,SMALLSHOT_SIZE,SMALLSHOT_SIZE);
    }

    public void Collision(){
        for (GameObject object : handler.objects){
            if (object.getID() == ID.ENEMY){
                if (getBounds().intersects(object.getBounds())){
                    handler.objects.remove(this);
                    break;
                }
            }
        }
    }
}
