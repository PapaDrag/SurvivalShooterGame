package GameObjects;

import Codes.Handler;

public abstract class Shot extends GameObject {

    public Shot(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
    }

}

