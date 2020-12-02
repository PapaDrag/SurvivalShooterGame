package Codes;

import GameObjects.GunUtil.GunType;
import GameObjects.Entities.Player;

import java.awt.*;

public class HUD {

    private int health;
    public Handler handler;
    private int ammoInMag;
    private int ammoInReserve;
    private GunType gunType;
    private Player player;
    private int currentWave;
    private boolean isReloading;


    public HUD(Handler handler){
        health = 100;
        this.handler = handler;
        this.player = (Player)handler.objects.getFirst();
        ammoInMag = player.getCurrentGun().getAmmoInMag();
        ammoInReserve = player.getCurrentGun().getAmmoInReserve();
        isReloading = false;

    }

    public void render(Graphics g){
        drawHealth(g);
        drawAmmo(g);
        drawWave(g);
        drawReloading(g);

    }

    public void tick(){
        health = player.getHealth();
        ammoInMag = player.getCurrentGun().getAmmoInMag();
        ammoInReserve = player.getCurrentGun().getAmmoInReserve();
        currentWave = handler.waveManager.getCurrentWave();
        isReloading = player.getCurrentGun().isReloading;
    }

    public void drawHealth(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("font", Font.BOLD,20));
        g.drawString("HEALTH: " + Integer.toString(health),1,40);
    }

    public void drawAmmo(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("font", Font.BOLD,35));
        g.drawString(Integer.toString(ammoInMag) + "/" + Integer.toString(ammoInReserve),1,80);
    }

    public void drawWave(Graphics g){

        g.setColor(Color.BLACK);
        g.setFont(new Font("font", Font.BOLD | Font.ITALIC,35));
        g.drawString("WAVE: " + Integer.toString(currentWave),Game.WIDTH - 200,40);
    }

    public void drawReloading(Graphics g){
        if (isReloading) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("font", Font.BOLD | Font.ITALIC, 15));
            g.drawString("RELOADING", (int)player.getX() - 36, (int)player.getY() + 34);
        }
    }


}
