package Codes;

public class Timer extends Thread{

    private double currentTime;
    private double startTime;
    private int seconds;

    public Timer(){
        startTime = (double)System.currentTimeMillis();
    }

    public void tick(){
        currentTime = System.currentTimeMillis() - startTime;
    }

    public double getCurrentTimeSeconds(){
        return currentTime/1000;
    }

    public synchronized void wait(int seconds){
        this.seconds = seconds;
        start();

    }

    public void run(){
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
