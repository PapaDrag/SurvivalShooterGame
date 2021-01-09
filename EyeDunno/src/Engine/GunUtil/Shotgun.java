package Engine.GunUtil;

import Engine.Handler;
import Engine.Entities.*;
import Engine.Entities.Shots.BuckShot;
import Engine.Entities.Shots.HandGunRound;
import Engine.Entities.Shots.Shot;

public class Shotgun extends Gun {

    private int pellets;

    public Shotgun(Handler handler, Player player) {
        super(handler, player);
        magazineSize = 7;
        gunType = GunType.SHOTGUN;
        ammoInMag = magazineSize;
        ammoInReserve = magazineSize * reserveMultiplier;
        reloadTime = 4;
        accuracy = 20;
        pellets = 12;
    }

    @Override
    public void pullTrigger(double mouseX, double mouseY) {
        if (isReloading)
            return;
        if (ammoInMag > 0) {
            for (int i = 0; i < pellets; i++) {
                int randX = random.nextInt(accuracy);
                int randY = random.nextInt(accuracy);
                if (random.nextInt(2) == 1)
                    randX = (-1) * randX;
                if (random.nextInt(2) == 1)
                    randY = (-1) * randY;
                mouseX += randX;
                mouseY += randY;
                double playerX = player.getX();
                double playerY = player.getY();
                double theta = Math.atan2((mouseY - playerY), (mouseX - playerX));
                double velX = (HandGunRound.velocity) * Math.cos(theta);
                double velY = (HandGunRound.velocity) * Math.sin(theta);
                Shot shot = new BuckShot((int) playerX + (Player.PLAYER_SIZE / 3), (int) playerY + (Player.PLAYER_SIZE / 3), ID.BUCKSHOT, handler);
                shot.setVelX(velX);
                shot.setVelY(velY);
                handler.objects.add(shot);
            }
            ammoInMag--;
        }
    }

    @Override
    public void releaseTrigger() {

    }
}
