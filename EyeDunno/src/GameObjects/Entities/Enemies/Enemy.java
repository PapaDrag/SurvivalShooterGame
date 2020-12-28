package GameObjects.Entities.Enemies;

import Codes.Handler;
import GameObjects.Entities.Block;
import GameObjects.Entities.GameObject;
import GameObjects.Entities.ID;
import GameObjects.Entities.Player;

import java.util.Collection;

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
        Player player = (Player)handler.objects.getFirst();
        if (getBounds().intersects(player.getBounds())){
            player.takeDamage(2);
        }

        //for (GameObject object : handler.objects){



            /**if (object.getID() == ID.BLOCK) {
                if (getBounds().intersects(object.getBounds())) {
                    Block block = (Block)object;
                    if (x > block.getX() - size || x < block.getX() + block.getxSize()) //FINISH THIS LATER
                        x = oldX;
                    if (y > block.getY() - size || y < block.getY() + block.getySize())
                        y = oldY;
                }
            }
             **/
        //}
    }

    public void takeDamage(int damage){
        health -= damage;
        if (health <= 0){
            handler.objects.remove(this);
            givePlayerScore();
        }
    }

    public abstract void givePlayerScore();

    public int getSize(){
        return size;
    }

    @Override
    public void tick() {
        Player player = (Player)handler.objects.getFirst();
        double playerX = player.getX();
        double playerY = player.getY();
        double enemyX = getX();
        double enemyY = getY();
        double theta = Math.atan2((enemyY-playerY),(enemyX - playerX));
        velX = -(speed) * Math.cos(theta);
        velY = -(speed) * Math.sin(theta);
        oldX = (int)x;
        oldY = (int)y;
        x += velX;
        y += velY;
        Collision();
    }
}
