package GameObjects.GunUtil;

import Codes.Handler;
import GameObjects.Entities.HandGunRound;
import GameObjects.Entities.ID;
import GameObjects.Entities.Player;
import GameObjects.Entities.Shot;

public class SubMachineGun extends Gun implements Runnable {

    private boolean isTriggerDown;
    private int rateOfFire;

    public SubMachineGun(Handler handler, Player player) {
        super(handler, player);
        magazineSize = 35;
        gunType = GunType.SUBMACHINEGUN;
        ammoInMag = magazineSize;
        ammoInReserve = magazineSize * 4;
        reloadTime = 3;
        accuracy = 60;
        isTriggerDown = false;
        rateOfFire = 50;

    }

    @Override
    public void pullTrigger(double mouseX, double mouseY) {
        if (isReloading)
            return;
        if (isTriggerDown)
            return;
        if (ammoInMag > 0) {
            isTriggerDown = true;
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void releaseTrigger() {
        isTriggerDown = false;
    }

    @Override
    public void run() {
        while(isTriggerDown && (ammoInMag > 0)){
            int mouseX = handler.mouseX;
            int mouseY = handler.mouseY;
            int randX = random.nextInt(accuracy);
            int randY = random.nextInt(accuracy);
            if (random.nextInt(2)==1)
                randX = (-1)*randX;
            if (random.nextInt(2)==1)
                randY = (-1)*randY;
            mouseX += randX;
            mouseY += randY;
            double playerX = player.getX();
            double playerY = player.getY();
            double theta = Math.atan2((mouseY - playerY), (mouseX - playerX));
            double velX = (HandGunRound.velocity) * Math.cos(theta);
            double velY = (HandGunRound.velocity) * Math.sin(theta);
            Shot shot = new HandGunRound((int) playerX + (Player.PLAYER_SIZE / 3), (int) playerY + (Player.PLAYER_SIZE / 3), ID.SMALLSHOT, handler);
            shot.setVelX(velX);
            shot.setVelY(velY);
            handler.objects.add(shot);
            ammoInMag--;
            try {
                Thread.sleep(rateOfFire);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
