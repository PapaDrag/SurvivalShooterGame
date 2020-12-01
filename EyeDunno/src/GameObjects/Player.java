package GameObjects;

import Codes.Game;
import Codes.Handler;

import java.awt.*;

public class Player extends GameObject {

    public static final int PLAYER_VELOCITY = 5;
    public static final int PLAYER_SIZE = 20;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
    }

    /**
     * Update the current status of this object
     */
    @Override
    public void tick() {
        x += velX;
        y += velY;
        Collision();

    }

    /**
     * Renders the object based off the status made in tick()
     * @param g
     */
    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x,(int)y,PLAYER_SIZE,PLAYER_SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,PLAYER_SIZE,PLAYER_SIZE);
    }

    @Override
    public void Collision() {
        if (x < 0)
            x = 0;
        if (y < 0)
            y = 0;
        if (x > Game.WIDTH - PLAYER_SIZE)
            x = Game.WIDTH - (PLAYER_SIZE);
        if (y > Game.HEIGHT - (2*PLAYER_SIZE))
            y = Game.HEIGHT - (2*PLAYER_SIZE);
    }
}
