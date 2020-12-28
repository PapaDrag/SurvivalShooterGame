package Codes;

import GameObjects.GunUtil.Gun;
import GameObjects.GunUtil.GunType;
import GameObjects.Entities.Player;

import java.awt.*;

public class HUD {

    private int health;
    public Handler handler;
    private int ammoInMag;
    private int ammoInReserve;
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
        drawScore(g);
        if (player.getCurrentGun() != null)
            drawCurrentGun(g);

    }

    public void tick(){
        health = player.getHealth();
        ammoInMag = player.getCurrentGun().getAmmoInMag();
        ammoInReserve = player.getCurrentGun().getAmmoInReserve();
        currentWave = handler.waveManager.getCurrentWave();
        isReloading = player.getCurrentGun().isReloading;
    }

    public void drawHealth(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(0,35,196, 40);
        g.fillRect(0,35, (int)(player.getPercentHealth()*196),40);


        g.setColor(Color.BLACK);
        g.setFont(new Font("font", Font.BOLD,30));
        g.drawString("HEALTH: " + health,1,65);
    }

    public void drawAmmo(Graphics g){
        g.setColor(Color.BLACK);
        if (ammoInReserve < player.getCurrentGun().getMagazineSize())
            g.setColor(Color.RED);
        g.setFont(new Font("font", Font.BOLD,60));
        g.drawString( "/" + Integer.toString(ammoInReserve),Game.WIDTH - 132,Game.HEIGHT - 55);
        for (int i = 1; i <= ammoInMag; i++){
            g.setColor(Color.BLACK);
            if (ammoInMag < player.getCurrentGun().getMagazineSize()/3)
                g.setColor(Color.RED);
            g.fillRect(Game.WIDTH - 135 + -(5*i),Game.HEIGHT-85,4,30);
        }
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

    public void drawCurrentGun(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("font", Font.BOLD,25));
        String gunStr = player.getCurrentGun().toString();
        g.drawString(gunStr,Game.WIDTH - 170,Game.HEIGHT - 110);
    }

    public void drawScore(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("font", Font.BOLD,45));
        String str = Integer.toString(player.getScore());
        g.drawString("Score: " + str,Game.WIDTH - Game.WIDTH*3/5,50);
    }


}
