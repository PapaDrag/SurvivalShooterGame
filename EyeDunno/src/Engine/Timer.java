package Engine;

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


}
