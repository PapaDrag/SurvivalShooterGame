package Codes;

import Engine.*;
import Engine.Entities.ID;
import Engine.Entities.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1500, HEIGHT = WIDTH/16*9;
    private Thread thread;
    private boolean running;
    public Handler handler;
    private int fps;
    private HUD hud;


    public Game(){
        Window window = new Window(WIDTH, HEIGHT, "RETARD", this);
        initializeGame();
        start();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            frames++;
            if (running){
                render();
            }

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                fps = frames;
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){

        handler.tick();
        hud.tick();

    }


    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.BLACK);
        g.drawString("FPS: " + Integer.toString(fps), 10, 20);

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public void initializeGame(){
        handler = new Handler(new Timer(), this);
        handler.addObject(new Player(600,400,ID.PLAYER,handler));
        hud = new HUD(handler);
        this.addKeyListener(new KeyInput(this.handler,this));
        this.addMouseListener(new MouseInput(this.handler));
        this.addMouseMotionListener(new MouseInput(this.handler));
        this.addMouseWheelListener(new MouseInput(this.handler));
        handler.startGame();
    }


    public void pause(){
        
    }

    public static void main(String[] args){
        new Game();
    }
}
