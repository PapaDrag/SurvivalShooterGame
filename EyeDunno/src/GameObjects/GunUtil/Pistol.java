package GameObjects.GunUtil;

import Codes.Handler;
import GameObjects.Entities.ID;
import GameObjects.Entities.Player;
import GameObjects.Entities.Shot;
import GameObjects.Entities.HandGunRound;

public class Pistol extends Gun {


    public Pistol(Handler handler, Player player) {
        super(handler, player);
        magazineSize = 15;
        gunType = GunType.PISTOL;
        ammoInMag = magazineSize;
        ammoInReserve = magazineSize * 4;
        reloadTime = 2;
        accuracy = 30;
    }

    @Override
    public void pullTrigger(double mouseX, double mouseY) {
        if (isReloading)
            return;
        if (ammoInMag > 0) {
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

        }
    }



    @Override
    public void releaseTrigger() {

    }


}
