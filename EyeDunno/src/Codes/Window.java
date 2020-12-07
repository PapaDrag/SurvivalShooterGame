package Codes;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{

    private static final long serialVersionUID = 123456789;

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        Dimension dimension = new Dimension(width,height);

        frame.setPreferredSize(dimension);
        frame.setMaximumSize(dimension);
        frame.setMinimumSize(dimension);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(game);

    }

}
