package Codes;

import GameObjects.Entities.GameObject;
import GameObjects.Entities.ID;
import GameObjects.Entities.RegularEnemy;

public class WaveManager implements Runnable {

    public Handler handler;
    private int currentWave;
    private Thread thread;

    public WaveManager(Handler handler){
        this.handler = handler;
    }

    public void startWaves(){
        thread = new Thread(this);
        thread.start();
    }

    public void startWave1(){
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(2);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(1);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        waitForWaveCompletion();
    }

    public void startWave2(){
        wait(2);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(1);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(2);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(1);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(2);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(1);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(2);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));
        wait(1);
        handler.addObject(new RegularEnemy(600,50, ID.ENEMY,handler));

    }

    @Override
    public void run() {
        currentWave = 1;
        startWave1();
        currentWave++;
        startWave2();


    }

    public boolean hasEnemies(){
        for (GameObject object: handler.objects){
            if (object.getID() == ID.ENEMY)
                return true;
        }
        return false;
    }

    public void waitForWaveCompletion(){
        while(hasEnemies()){
            wait(1);
        }
    }

    public void wait(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch (Exception ignored){
        }
    }

    public int getCurrentWave(){
        return currentWave;
    }
}
