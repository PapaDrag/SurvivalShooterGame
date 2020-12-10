package GameObjects.Entities;

import Codes.Handler;

public abstract class Enemy extends GameObject {

    protected int health;
    protected int maxHealth;
    protected int size;
    protected int speed;
    protected int oldX;
    protected int oldY;

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);

    }



    @Override // WORK IN PROGRESS
    public void Collision() {
        for (GameObject object : handler.objects){
            if (object.getID() == ID.BLOCK) {
                if (getBounds().intersects(object.getBounds())) {
                    Block block = (Block)object;
                    if (x > block.getX() - size || x < block.getX() + block.getxSize())
                        x = oldX;
                    if (y > block.getY() - size || y < block.getY() + block.getySize())
                        y = oldY;
                }
            }
        }
    }

    public void takeDamage(int damage){
        health -= damage;
        if (health <= 0){
            handler.objects.remove(this);
        }
    }

    public int getSize(){
        return size;
    }
}
