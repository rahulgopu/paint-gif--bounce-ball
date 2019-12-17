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
import java.util.stream.IntStream;

public class MainPanel extends JPanel implements ActionListener {
    private String[] imageStringNameA = {"pat1.gif", "pat2.gif", "pat3.gif", "pat4.gif", "pat5.gif"};

    final static Image[] imageA = new Image[5];//image arr holds 5 images we load using toolkit code

    JToolBar MainPanelToolBar = new JToolBar(); //pointer to toolbar for main panel
    TileGridPanel tileGridPanelPtr = new TileGridPanel(); //pointer to area where we will paint items on a tile Grid

    private JButton patch1btn, patch2btn, patch3btn, patch4btn, patch5btn, resetBtn; //need to declare 5 buttons….and a reset button


    public MainPanel() {

        //code the toolkit code that I have shown earlier that loads the images into the one dimensional imageA
        IntStream.range(0, 5)
                .forEach(i -> imageA[i] = Toolkit.getDefaultToolkit().getImage(imageStringNameA[i]));


        this.setLayout(new BorderLayout()); //we will add items to north, center, south on main panel
        this.setPreferredSize(new Dimension(500,500));

        JPanel panelSouth = new JPanel(new FlowLayout());

        tileGridPanelPtr.setBackground(c1);
        panelSouth.setBackground(c3);

        //prepare north area of main panel
        patch1btn = new JButton(new ImageIcon(imageA[0]));
        patch2btn = new JButton(new ImageIcon(imageA[1]));
        patch3btn = new JButton(new ImageIcon(imageA[2]));
        patch4btn = new JButton(new ImageIcon(imageA[3]));
        patch5btn = new JButton(new ImageIcon(imageA[4]));
        resetBtn = new JButton("RESET");

        MainPanelToolBar.add(patch1btn);
        MainPanelToolBar.add(patch2btn);
        MainPanelToolBar.add(patch3btn);
        MainPanelToolBar.add(patch4btn);
        MainPanelToolBar.add(patch5btn);

        panelSouth.add(resetBtn);

        patch1btn.addActionListener(this);
        patch2btn.addActionListener(this);
        patch3btn.addActionListener(this);
        patch4btn.addActionListener(this);
        patch5btn.addActionListener(this);
        resetBtn.addActionListener(this);

        tileGridPanelPtr.CreateMouseListener();

        MainPanelToolBar.setSize(20, 10);
        MainPanelToolBar.setBackground(c2);
        this.add(MainPanelToolBar, BorderLayout.NORTH);
        add(tileGridPanelPtr, BorderLayout.CENTER); //Adding centerPanel to mainPanel.
        add(panelSouth, BorderLayout.SOUTH);

    }//end constructor

    @Override
    public void actionPerformed(ActionEvent e) { //put in listener method for button clicks on toolbar
        if(e.getSource()==patch1btn) { //was  button A  clicked in toolbar?
            tileGridPanelPtr.selectedTile = 0; //this sets the variable in tileGridPanel object, need to check for the 5 button clicks
        }
        else if(e.getSource()==patch2btn) {
            tileGridPanelPtr.selectedTile = 1;
        }
        else if(e.getSource()==patch3btn) {
            tileGridPanelPtr.selectedTile = 2;
        }
        else if(e.getSource()==patch4btn) {
            tileGridPanelPtr.selectedTile = 3;
        }
        else if(e.getSource()==patch5btn) {
            tileGridPanelPtr.selectedTile = 4;
        }
        else if(e.getSource()==resetBtn) {
            tileGridPanelPtr.ResetGridTile(); //reset grid and and paint empty center area
        }
    }

    private Color c1 = new Color(255, 255, 0);  //higher numbers means lighter colors
    private Color c2 = new Color(249, 166, 2);
    private Color c3 = new Color(255, 145, 164);
}
