package GameObjects.Entities;

import Codes.Handler;

import java.awt.*;

public class FatEnemy extends Enemy {

    public FatEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        maxHealth = 600;
        size = 80;
        speed = 1;
        health = maxHealth;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
