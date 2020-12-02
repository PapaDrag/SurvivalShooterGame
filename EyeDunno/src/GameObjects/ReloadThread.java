package GameObjects;

import Codes.Timer;

import java.sql.Time;

public class ReloadThread extends Thread {

    public boolean isFinished;
    public int seconds;
    public Timer timer;
    private GunManager gunManager;

    public ReloadThread(int seconds, Timer timer, GunManager gunManager){
        isFinished = false;
        this.seconds = seconds;
        this.timer = timer;
        this.gunManager = gunManager;

    }

    public void setReloadTime(int seconds){
        this.seconds = seconds;
    }

    @Override
    public void run(){
        isFinished = false;
        double starTime = timer.getCurrentTimeSeconds();
        double nowTime;
        do{
            nowTime = timer.getCurrentTimeSeconds();
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (nowTime - starTime < 2);
        isFinished = true;
        gunManager.reload();


    }


}
