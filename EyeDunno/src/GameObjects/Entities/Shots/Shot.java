package GameObjects.Entities.Shots;

import Codes.Handler;
import GameObjects.Entities.GameObject;
import GameObjects.Entities.ID;

public abstract class Shot extends GameObject {

    public static int velocity;
    public int size;
    public int damage;

    public Shot(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
    }

}

