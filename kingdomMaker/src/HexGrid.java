
import javax.swing.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bryon
 */
public class HexGrid extends JPanel{
    
    public void draw() {
        repaint();
    }   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
    }   
        private void drawHexGridLoop(Graphics g, Point origin, int size, int radius, int padding) {
    double ang30 = Math.toRadians(30);
    double xOff = Math.cos(ang30) * (radius + padding);
    double yOff = Math.sin(ang30) * (radius + padding);
    int half = size / 2;

    for (int row = 0; row < size; row++) {
        int cols = size - java.lang.Math.abs(row - half);

        for (int col = 0; col < cols; col++) {
            int xLbl = row < half ? col - row : col - half;
            int yLbl = row - half;
            int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
            int y = (int) (origin.y + yOff * (row - half) * 3);

            drawHex(g, xLbl, yLbl, x, y, radius);
        }
    }
}
        
        //Hexagon hexagon = new Hexagon(20, 20, 10);
        
        
        
        /**  
        g.setColor(Color.DARK_GRAY);
        
        int[] xPoints = {};
        int[] yPoints = {};
        int WIDTH = 5;
        
        g.drawPolygon(xPoints, yPoints, WIDTH);
        **/
        
        
    }
}
