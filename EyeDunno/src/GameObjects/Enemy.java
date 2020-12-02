package GameObjects;

import Codes.Handler;

import java.awt.*;

public abstract class Enemy extends GameObject {

    protected int health;

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }


    @Override
    public void Collision() {

    }

    public void takeDamage(int damage){
        health -= damage;
        if (health <= 0){
            handler.objects.remove(this);
        }
    }
}
