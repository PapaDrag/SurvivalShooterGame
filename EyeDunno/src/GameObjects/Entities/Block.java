package GameObjects.Entities;

import Codes.Handler;

import java.awt.*;

public class Block extends GameObject{

    private int xSize;
    private int ySize;
    private Color color;

    public Block(int x, int y, ID id, Handler handler, int xSize, int ySize, Color color) {
        super(x, y, id, handler);
        this.xSize = xSize;
        this.ySize = ySize;
        this.color = color;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int)x,(int)y,xSize,ySize);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,xSize,ySize);
    }

    @Override
    public void Collision() {

    }

    public int getxSize(){
        return xSize;

    }
    public int getySize() {
        return ySize;
    }

}
