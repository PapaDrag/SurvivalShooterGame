package Engine.Entities;

import Engine.Handler;
import Engine.GunUtil.*;

import java.awt.*;
import java.util.Random;


enum Type{
    PISTOL,
    SUBMACHINEGUN,
    SHOTGUN,
    AMMO,
    HEALTH
}

public class GunPickup extends GameObject {

    public static final int healthGain = 20;
    private int width;
    private int height;
    private Gun gun;
    private Player player;
    private Type type;

    public GunPickup(int x, int y, ID id, Handler handler) {


        super(x, y, id, handler);
        player = (Player)handler.objects.getFirst();
        width = 100;
        height = 30;
        Random rand = new Random();
        int whatGun = rand.nextInt(5);
        switch (whatGun){
            case 0:
                type = Type.PISTOL;
                gun = new Pistol(handler,player);
                break;
            case 1:
                type = Type.SUBMACHINEGUN;
                gun = new SubMachineGun(handler,player);
                width += 90;
                break;
            case 2:
                type = Type.SHOTGUN;
                gun = new Shotgun(handler,player);
                break;
            case 3:
                type = Type.AMMO;
                gun = null;
                width += 30;
                break;
            case 4:
                type = Type.HEALTH;
                gun = null;
                break;
        }
    }

    @Override
    public void tick() {
        Collision();
    }

    @Override
    public void render(Graphics g) {
        String gunStr = "";
        if (type == Type.AMMO) {
            gunStr = "LottaAmmo";
        }
        else if (type == Type.HEALTH)
            gunStr = "Health";
        else if (type == Type.PISTOL) {
            gunStr = "Pistol";
        }
        else if (type == Type.SHOTGUN) {
            gunStr = "Shotgun";
        }
        else if (type == Type.SUBMACHINEGUN) {
            gunStr = "Submachinegun";
        }
        g.setColor(Color.BLACK);
        g.drawRect((int)x,(int)y,width,height);
        g.setFont(new Font("font", Font.BOLD,20));
        g.drawString(gunStr,(int)x+12,(int)y+20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,width,height);
    }

    @Override
    public void Collision() {
        if (player.getBounds().intersects(getBounds())){
            if (type == Type.AMMO){
                player.maxAmmo();
                handler.objects.remove(this);
                return;
            }
            if (type == Type.HEALTH){
                player.addHealth(healthGain);
                handler.objects.remove(this);
                return;
            }
            player.addGun(gun);
            handler.objects.remove(this);
        }

    }
}
