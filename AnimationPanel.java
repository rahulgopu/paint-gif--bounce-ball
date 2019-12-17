/***********************************************************
 CSCI 502 - Assignment 6 – Fall 2019

 Programmers: Rahul Reddy Gopu (Z1839171)
 Saran Kumar Reddy Padala (Z1840816)

 Section: 1
 TA: Sindhusha Parimi
 Date Due: December 09, 2019
 ************************************************************/

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AnimationPanel extends JPanel implements Runnable {

    List<Ball> balls = new ArrayList<>();
    private Dimension dimen = null;
    private Dimension dimension;
    private Thread threadObjPtr = null;

    public AnimationPanel() {
        dimension = new Dimension(350, 350);
        this.setPreferredSize(dimension);
        this.setBackground(Color.WHITE);
    }

    public void start() {
        if (threadObjPtr == null) {
            threadObjPtr = new Thread(this);
            threadObjPtr.start();
        }
    }

    public void stop() {
        threadObjPtr = null;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (dimen == null) {
            dimen = this.getSize();
            balls.add(new Ball(Color.GRAY, 10, (dimen.width * 2 / 3), (dimen.height - 40), -10,-4));
            balls.add(new Ball(Color.PINK, 15, (dimen.width * 4 / 3), (dimen.height - 20), -6,-20));
            balls.add(new Ball(Color.BLACK, 40, (dimen.width * 2 / 3), (dimen.height - 10), -4,-35));
            balls.add(new Ball(Color.YELLOW, 35, (dimen.width * 8 / 3), (dimen.height - 15), -2,4));
            balls.add(new Ball(Color.ORANGE, 30, (dimen.width * 9 / 3), (dimen.height - 15), -2,8));
        }
        for (Ball ball: balls) {
            ball.move(dimension);
            ball.draw(graphics);
        }
    }

    @Override
    public void run() {
        while(threadObjPtr != null) {

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

            repaint();
        }
    }

    @Override
    public Dimension getSize() {
        dimen = new Dimension(75,75);
        return dimen;
    }
}
