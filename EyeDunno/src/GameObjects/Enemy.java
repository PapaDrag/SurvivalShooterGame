package GameObjects;

import Codes.Handler;

import java.awt.*;

public class Enemy extends GameObject {

    private int size;

    public Enemy(int x, int y, ID id, Handler handler, int size) {
        super(x, y, id, handler);
        this.size = size;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x,(int)y,size,size);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,size,size);
    }

    @Override
    public void Collision() {

    }
}
