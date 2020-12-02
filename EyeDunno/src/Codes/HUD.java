package Codes;

import GameObjects.Gun;
import GameObjects.Player;

import java.awt.*;

public class HUD {

    private int health;
    public Handler handler;
    private int ammoInMag;
    private int ammoInReserve;
    private Gun gun;
    private Player player;


    public HUD(Handler handler){
        health = 100;
        this.handler = handler;
        this.player = (Player)handler.objects.getFirst();
        ammoInMag = player.getAmmoInMag();
        ammoInReserve = player.getAmmoInReserve();

    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("font", Font.BOLD,20));
        g.drawString("HEALTH: " + Integer.toString(health),1,40);
        g.setFont(new Font("font", Font.BOLD,35));
        g.drawString(Integer.toString(ammoInMag) + "/" + Integer.toString(ammoInReserve),1,80);

    }

    public void tick(){
        health = player.getHealth();
        ammoInMag = player.getAmmoInMag();
        ammoInReserve = player.getAmmoInReserve();
    }


}
