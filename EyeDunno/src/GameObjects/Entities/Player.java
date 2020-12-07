package GameObjects.Entities;

import Codes.Game;
import Codes.Handler;
import GameObjects.GunUtil.Gun;
import GameObjects.GunUtil.Pistol;
import GameObjects.GunUtil.SubMachineGun;

import java.awt.*;
import java.util.LinkedList;

public class Player extends GameObject {

    private int health;
    public static final int PLAYER_VELOCITY = 3;
    public static final int PLAYER_SIZE = 20;
    private Gun currentGun;
    private LinkedList<Gun> guns = new LinkedList<Gun>();

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        health = 100;
        guns.add(new SubMachineGun(handler,this));
        guns.add(new Pistol(handler,this));
        currentGun = guns.getFirst();
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
        if (y > Game.HEIGHT - (2.5*PLAYER_SIZE))
            y = Game.HEIGHT - (2.5*PLAYER_SIZE);
    }

    public Gun getCurrentGun(){
        return this.currentGun;
    }


    public void takeDamage(int damage){
        health -= damage;
    }

    public int getHealth(){
        return health;
    }

    public void pullTrigger(double mouseX, double mouseY){
        currentGun.pullTrigger(mouseX,mouseY);
    }

    public void reload(){
        currentGun.reload();
    }

    public void nextGun(int delta){
        if (currentGun.isReloading)
            return;

        int index = guns.indexOf(currentGun) + delta;
        if (index > guns.size()-1) {
            currentGun = guns.get(0);
            return;
        }
        if (index < 0){
            currentGun = guns.get(guns.size()-1);
            return;
        }

        currentGun = guns.get(index);
    }

    public void releaseTrigger(){
        currentGun.releaseTrigger();
    }

}
