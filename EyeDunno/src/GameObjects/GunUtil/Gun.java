package GameObjects.GunUtil;

import Codes.Handler;
import GameObjects.Entities.Player;
import java.util.Random;

public abstract class Gun {

    protected Random random;
    protected int ammoInMag;
    protected int ammoInReserve;
    protected GunType gunType;
    protected int reloadTime;
    protected boolean hasAmmoInMag;
    public boolean isReloading;
    protected Player player;
    protected int magazineSize;
    public Handler handler;
    protected int accuracy;


    public Gun(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        random = new Random();

    }

    public abstract void pullTrigger(double mouseX, double mouseY);

    public abstract void releaseTrigger();

    public void reload(){
        if (ammoInReserve == 0)
            return;
        isReloading = true;
        ReloadThread reloadThread = new ReloadThread(reloadTime,this);
        reloadThread.start();
    };



    public GunType getGunType(){
        return gunType;
    }

    public int getAmmoInMag(){
        return ammoInMag;
    }

    public int getAmmoInReserve(){
        return ammoInReserve;
    }

    @Override
    public String toString(){
        switch (gunType){
            case PISTOL:
                return "Pistol";
            case SUBMACHINEGUN:
                return "Submachinegun";
            case SHOTGUN:
                return "Shotgun";
        }
        return null;
    }



}
