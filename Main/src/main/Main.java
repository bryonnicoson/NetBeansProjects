/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import static java.lang.ProcessBuilder.Redirect.to;
import javafx.scene.input.MouseEvent;
import javax.swing.*;

public class Main extends JPanel {
    private static final long serialVersionUID = 1L;
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;

    private Font font = new Font("Arial", Font.PLAIN, 18);
    FontMetrics metrics;

    public Main() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Shape s: shapes)  ---- think i have to add hexagons to array
        }
    });

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point origin = new Point(50, 50);
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        g2d.setFont(font);
        metrics = g.getFontMetrics();

       drawHexGrid(g2d, origin, 40, 7, 11, 0);
    }

    private void drawHexGrid(Graphics g, Point origin, int radius, int cols, int rows, int padding){
                
        int y = (int) origin.y;
        
        for (int row = 0; row < rows; row++){
            int x = (int) origin.x;
            if (row % 2 == 1) 
                x += Math.sqrt(3)/2 * radius;
            
            for (int col = 0; col < cols; col++){    
                x += (int) ((Math.sqrt(3)/2) * (radius * 2));
                drawHex(g, col, row, x, y, radius);
            }
            y += radius + (radius / 2);
            
        }
    }
    
    private void drawHex(Graphics g, int posX, int posY, int x, int y, int r) {
        Graphics2D g2d = (Graphics2D) g;

        Hexagon hex = new Hexagon(x, y, r);
        String text = String.format("%s : %s", coord(posY), coord(posX));
        int w = metrics.stringWidth(text);
        int h = metrics.getHeight();

        hex.draw(g2d, x, y, 0, 0x009933, true);
        hex.draw(g2d, x, y, 1, 0xdddddd, false);

        g.setColor(new Color(0xFFFFFF));
        g.drawString(text, x - w/2, y + h/2);
    }

    private String coord(int value) {
        return Integer.toString(value);
    }

    public void drawCircle(Graphics2D g, Point origin, int radius,
            boolean centered, boolean filled, int colorValue, int lineThickness) {
        // Store before changing.
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();

        g.setColor(new Color(colorValue));
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        int diameter = radius * 2;
        int x2 = centered ? origin.x - radius : origin.x;
        int y2 = centered ? origin.y - radius : origin.y;

        if (filled)
            g.fillOval(x2, y2, diameter, diameter);
        else
            g.drawOval(x2, y2, diameter, diameter);

        // Set values to previous when done.
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Main p = new Main();

        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        
    }
}
