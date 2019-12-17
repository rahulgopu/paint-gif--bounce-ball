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

public class GraphicsTilesPgm extends JFrame {
    public static void main(String[] args) throws Exception {
        createAndShowGUI();
    }
    private static void createAndShowGUI() throws Exception {
        GraphicsTilesPgm frame = new GraphicsTilesPgm(); //create the master frame
        frame.pack();
        frame.setVisible(true);
    }

    public GraphicsTilesPgm() { //constructor
        super();

        MainPanel mainPanelPtr = new MainPanel();//creates main panel that overwrites the frame
        this.add(mainPanelPtr, BorderLayout.WEST); //main panel covers West side of frame

        BallAnimation ballAnimation = new BallAnimation();
        this.add(ballAnimation, BorderLayout.EAST);
    }

}
