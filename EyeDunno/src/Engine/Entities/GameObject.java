package Engine.Entities;

import Engine.Handler;

import java.awt.*;

public abstract class GameObject {

    protected double x,y;
    protected ID id;
    protected double velX, velY;
    protected Handler handler;

    public GameObject(int x, int y, ID id, Handler handler){
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
        velX = 0;
        velY = 0;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public abstract void Collision();

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setID(ID id){
        this.id = id;
    }

    public ID getID(){
        return id;
    }

    public void setVelX(double vel){
        this.velX = vel;
    }

    public void setVelY(double vel) {
        this.velY = vel;
    }

    public double getVelX(){
        return velX;
    }

    public double getVelY() {
        return velY;
    }

}
