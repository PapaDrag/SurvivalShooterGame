package GameObjects;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    /**
     * Update the current status of this object
     */
    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    /**
     * Renders the object based off the status made in tick()
     * @param g
     */
    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
    }
}
