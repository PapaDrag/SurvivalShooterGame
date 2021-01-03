package Engine.Entities.Shots;

import Engine.Entities.Enemies.Enemy;
import Engine.Handler;
import Engine.Entities.GameObject;
import Engine.Entities.ID;

public abstract class Shot extends GameObject {

    public static int velocity;
    public int size;
    public int damage;

    public Shot(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
    }

    public void Collision(){
        try {
            for (GameObject object : handler.objects) {
                if (object.getID() == ID.ENEMY) {
                    if (getBounds().intersects(object.getBounds())) {
                        handler.objects.remove(this);
                        Enemy enemy = (Enemy) object;
                        enemy.takeDamage(damage);
                        break;
                    }
                }
                else if (object.getID() == ID.BLOCK){
                    if (getBounds().intersects(object.getBounds())) {
                        handler.objects.remove(this);
                        break;
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Collision Exception Detected");
        }
    }

}

