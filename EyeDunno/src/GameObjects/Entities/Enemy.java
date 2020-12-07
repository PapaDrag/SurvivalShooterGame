package GameObjects.Entities;

import Codes.Handler;

public abstract class Enemy extends GameObject {

    protected int health;

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);

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
