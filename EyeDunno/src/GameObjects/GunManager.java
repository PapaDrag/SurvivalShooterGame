package GameObjects;

import Codes.Handler;
import Codes.Timer;

public class GunManager{

    private Handler handler;
    private Player player;
    private Timer timer;
    private boolean isreloading;
    private ReloadThread reloadThread;

    public GunManager(Handler handler, Player player, Timer timer){
        this.handler= handler;
        this.player = player;
        this.timer = timer;
        this.isreloading = false;
    }

    public void fire(double mouseX, double mouseY){
        if (player.hasAmmoInMag()) {
            if (player.getCurrentGun() == Gun.PISTOL) {
                double playerX = player.getX();
                double playerY = player.getY();
                double theta = Math.atan2((mouseY - playerY), (mouseX - playerX));
                double velX = (SmallShot.SMALLSHOT_VELOCITY) * Math.cos(theta);
                double velY = (SmallShot.SMALLSHOT_VELOCITY) * Math.sin(theta);
                Shot shot = new SmallShot((int) playerX + (Player.PLAYER_SIZE / 3), (int) playerY + (Player.PLAYER_SIZE / 3), ID.SMALLSHOT, handler);
                shot.setVelX(velX);
                shot.setVelY(velY);
                handler.objects.add(shot);
                player.fireRound();

            }
        }

        if (!player.hasAmmoInMag()){
            reload();
        }
    }

    public synchronized void reload(){

        if (!isreloading) {  //if not reloading
            isreloading = true;
            reloadThread = new ReloadThread(2, this.timer, this);
            reloadThread.start();
        }
        if (isreloading){
            if (reloadThread.isFinished){
                isreloading = false;

                int initRounds = player.getAmmoInMag();
                int initReserve = player.getAmmoInReserve();
                if (initReserve >= 15) {
                    player.setAmmoInMag(15);
                    player.setAmmoInReserve(initReserve - 15);
                }
            }
        }
    }
}






