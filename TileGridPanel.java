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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class TileGridPanel extends JPanel implements MouseListener {
    int selectedTile = -1; //this is set to 0-4 when user clicks on a button in toolbar
    private static final int squareSide = 25;
    private int GridRow = 5, GridCol = 5;
    private Image[][] gif2dArray = new Image[GridRow][GridCol];

    public void ResetGridTile() {
        for (int row = 0; row < gif2dArray.length; row++) {
            for (int col = 0; col < gif2dArray.length; col++) {
                gif2dArray[row][col] = null;
            }
        }
        this.repaint(); //draw empty grid
    }

    public void CreateMouseListener() { //Adds mouse listener to Center panel..need mouse methods at bottom
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent arg0) {
        //**Loop to fill the gif2darray with the selected image out of MainPanel.imagaA[]
        for (int row = 0; row < gif2dArray.length; row++) {
            for (int col = 0; col < gif2dArray.length; col++) {
                gif2dArray[row][col] = MainPanel.imageA[selectedTile];
            }
        }
        this.repaint();  //show new grid with your images from 2d array
    } //user has clicked a tile on panel, now has clicked in the center panel

    @Override
    public void paintComponent(Graphics g)    //paints the center panel with elements in 2darray
    {
        super.paintComponent(g);
        int gridWidth = GridCol * squareSide;  //need to find center area of the center panel
        int gridHeight = GridRow * squareSide;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int startX = (panelWidth - gridWidth) / 2; //get starting point to draw grid based
        int startY = (panelHeight - gridHeight) / 2;

        //copy gif image array over to the drawing grid with inner outer loop
        for (int row = 0; row < gif2dArray.length; row++) {
            for (int col = 0; col < gif2dArray.length; col++) {
                g.drawImage(gif2dArray[row][col], startX + (squareSide * row), startY + (squareSide * col), this);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}