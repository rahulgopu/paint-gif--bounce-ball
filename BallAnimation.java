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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallAnimation extends JPanel implements ActionListener {

    private JButton startBtn, stopBtn;
    AnimationPanel ballArea;

    public BallAnimation() {
        this.setLayout(new BorderLayout()); //we will add items to north, center, south on main panel
        JPanel btnPanel = new JPanel(new FlowLayout());
        ballArea = new AnimationPanel();
        startBtn = new JButton("Start");
        btnPanel.add(startBtn);
        stopBtn = new JButton("Stop");
        btnPanel.add(stopBtn);

        startBtn.addActionListener(this);
        stopBtn.addActionListener(this);

        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(ballArea, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startBtn) {
            startBtn.setEnabled(false);
            stopBtn.setEnabled(true);
            ballArea.start();
        }
        else if(e.getSource()==stopBtn) {
            startBtn.setEnabled(true);
            stopBtn.setEnabled(false);
            ballArea.stop();
        }
    }
    private Color color = new Color(250, 140, 160);
}
