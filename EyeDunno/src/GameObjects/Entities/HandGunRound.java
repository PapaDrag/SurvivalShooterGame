package GameObjects.Entities;

import Codes.Handler;

import java.awt.*;

public class HandGunRound extends Shot {

    public static final int SMALLSHOT_VELOCITY = 20;
    public static final int SMALLSHOT_SIZE = 8;
    public static final int DAMAGE = 20;

    public HandGunRound(int x, int y, ID id, Handler handler) {
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
        try {
            for (GameObject object : handler.objects) {
                if (object.getID() == ID.ENEMY) {
                    if (getBounds().intersects(object.getBounds())) {
                        handler.objects.remove(this);
                        RegularEnemy enemy = (RegularEnemy) object;
                        enemy.takeDamage(DAMAGE);
                        break;
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Collision Exception Detected");
        }
    }
}
