package GameObjects.GunUtil;

import Codes.Handler;
import GameObjects.Entities.*;

public class Shotgun extends Gun {

    private int pellets;

    public Shotgun(Handler handler, Player player) {
        super(handler, player);
        magazineSize = 8;
        gunType = GunType.SHOTGUN;
        ammoInMag = magazineSize;
        ammoInReserve = magazineSize * 4;
        reloadTime = 3;
        accuracy = 40;
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
