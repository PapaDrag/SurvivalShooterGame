package Codes;

import Engine.Entities.Enemies.*;
import Engine.Entities.GameObject;
import Engine.Entities.GunPickup;
import Engine.Entities.ID;
import Engine.Handler;

import java.util.Random;

public class WaveManager implements Runnable {

    public Handler handler;
    private int currentWave;
    private Thread thread;
    private Random random;

    public WaveManager(Handler handler){
    this.handler = handler;
    thread = new Thread(this);
    random = new Random();
    }

    public void startWaves(){
        thread.start();
    }

    public void startWave1(){
        for (int i = 0; i < 4; i++) {
            int[] cords = getRandomSpawn();
            handler.addObject(new RegularEnemy(cords[0], cords[1], ID.ENEMY, handler));
            wait(1);
        }
        waitForWaveCompletion();
    }

    public void startWave2(){
        for (int i = 0; i < 7; i++) {
            int[] cords = getRandomSpawn();
            handler.addObject(new RegularEnemy(cords[0], cords[1], ID.ENEMY, handler));
            wait(1.1);
        }
        waitForWaveCompletion();
    }

    public void startWave3(){
        for (int i = 0; i < 4; i++) {
            int[] cords = getRandomSpawn();
            handler.addObject(new RegularEnemy(cords[0], cords[1], ID.ENEMY, handler));
            wait(1);
        }
        for (int i = 0; i < 4; i++) {
            int[] cords = getRandomSpawn();
            addRandomEnemy();
            wait(1.4);
        }
        waitForWaveCompletion();
    }

    public void startWave4(){
        for (int i = 0; i < 6; i++) {
            int[] cords = getRandomSpawn();
            handler.addObject(new RegularEnemy(cords[0], cords[1], ID.ENEMY, handler));
            wait(.8);
        }
        for (int i = 0; i < 8; i++) {
            int[] cords = getRandomSpawn();
            addRandomEnemy();
            wait(1.5);
        }
        waitForWaveCompletion();
    }

    public void startWave5(){
        for (int i = 0; i <15 ; i++) {
            int[] cords = getRandomSpawn();
            addRandomEnemy();
            wait(1.5);
        }
        waitForWaveCompletion();
    }

    public void startWaveX(){
        while (true){
            int enemies = currentWave*4;
            for (int i = 0; i<=enemies; i++){
                addRandomEnemy();
                wait(1);
            }
            waitForWaveCompletion();
            currentWave++;
        }
    }



    @Override
    public void run() {
        currentWave = 1;
        startWave1();
        currentWave++;
        startWave2();
        currentWave++;
        startWave3();
        currentWave++;
        startWave4();
        currentWave++;
        startWave5();
        startWaveX();



    }

    public boolean hasEnemies() {
        try {
            for (GameObject object : handler.objects) {
                if (object.getID() == ID.ENEMY)
                    return true;
            }

        }catch (Exception ignored){}
        return false;
    }

    public void waitForWaveCompletion(){
        while(hasEnemies()){
            wait(1);
        }
        addDrop();
        wait(4);
    }

    public void wait(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch (Exception ignored){
        }
    }

    public void wait(double seconds){
        try{
            Thread.sleep((int)(seconds * 1000));
        }catch (Exception ignored){
        }
    }


    public int getCurrentWave(){ //returns x,y
        return currentWave;
    }

    public void addRandomEnemy(){
        int[] cords = getRandomSpawn();
        Random random = new Random();
        int rand = random.nextInt(3);
        switch (rand){
            case 0:
                handler.addObject(new RegularEnemy(cords[0], cords[1], ID.ENEMY, handler));
                break;
            case 1:
                handler.addObject(new FatEnemy(cords[0], cords[1], ID.ENEMY, handler));
                break;
            case 2:
                handler.addObject(new FastEnemy(cords[0], cords[1], ID.ENEMY, handler));
                break;
        }
    }

    public void addDrop(){
        Random random = new Random();
        int x = 100 + random.nextInt(Game.WIDTH - 200);
        int y = 100 + random.nextInt(Game.HEIGHT - 200);
        handler.addObject(new GunPickup(x,y,ID.GUNPICKUP,handler));
    }



    public int[] getRandomSpawn() {
        int finalX = 0;
        int finalY = 0;
        int rand = random.nextInt(2);
        switch (rand) {
            case 0:
                int rand2 = random.nextInt(2);
                if (rand2 == 0){
                    finalX = 0;
                    finalY = random.nextInt(Game.HEIGHT);
                }
                if (rand2 == 1){
                    finalX = Game.WIDTH-25;
                    finalY = random.nextInt(Game.HEIGHT);
                }
                break;
            case 1:
                int rand3 = random.nextInt(2);
                if (rand3 == 0){
                    finalY = 0;
                    finalX = random.nextInt(Game.WIDTH);
                }
                if (rand3 == 1){
                    finalY = Game.HEIGHT-20;
                    finalX = random.nextInt(Game.WIDTH);
                }
                break;
        }
        return new int[]{finalX,finalY};
    }
}

