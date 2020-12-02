package Codes;

import GameObjects.Entities.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseInput extends MouseAdapter {

    private Handler handler;

    public MouseInput(Handler handler){
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent e){

        Player player = (Player)handler.objects.getFirst();
        double mouseX = e.getX();
        double mouseY = e.getY();
        player.pullTrigger(mouseX,mouseY);

    }

    @Override
    public void mouseReleased(MouseEvent e){
        Player player = (Player)handler.objects.getFirst();
        player.releaseTrigger();
    }

    @Override
    public void mouseDragged(MouseEvent e){
        double mouseX = e.getX();
        double mouseY = e.getY();
        handler.mouseX = (int)mouseX;
        handler.mouseY = (int)mouseY;
    }

    @Override
    public void mouseMoved(MouseEvent e){
        double mouseX = e.getX();
        double mouseY = e.getY();
        handler.mouseX = (int)mouseX;
        handler.mouseY = (int)mouseY;
    }

}
