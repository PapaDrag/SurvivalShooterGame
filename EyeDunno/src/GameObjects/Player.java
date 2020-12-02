package GameObjects;

import Codes.Game;
import Codes.Handler;

import java.awt.*;

public class Player extends GameObject {

    private int health;
    public static final int PLAYER_VELOCITY = 3;
    public static final int PLAYER_SIZE = 20;
    protected Gun currentGun;
    private int ammoInMag;
    private int ammoInReserve;
    private GunManager gunmanager;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        health = 100;
        currentGun = Gun.PISTOL;
        ammoInMag = 15;
        ammoInReserve = 60;
        gunmanager = new GunManager(handler,this,handler.timer);

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

    public int getAmmoInMag(){
        return ammoInMag;
    }

    public int getAmmoInReserve(){
        return ammoInReserve;
    }

    public void setAmmoInMag(int ammo){
        ammoInMag = ammo;
    }

    public void setAmmoInReserve(int ammo){
        ammoInReserve = ammo;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public int getHealth(){
        return health;
    }

    public void attemptShoot(double mouseX, double mouseY){
        gunmanager.fire(mouseX,mouseY);
    }

    public void fireRound(){
        ammoInMag--;
    }

    public boolean hasAmmoInMag(){
        return ammoInMag > 0;
    }

}
