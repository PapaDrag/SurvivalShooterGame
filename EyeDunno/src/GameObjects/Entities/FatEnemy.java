package GameObjects.Entities;

import Codes.Handler;

import java.awt.*;

public class FatEnemy extends Enemy {

    private static final int maxHealth = 600;
    private static final int size = 80;
    private static final int speed = 1;

    public FatEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
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
