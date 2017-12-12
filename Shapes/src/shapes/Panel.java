/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryon
 */
public class Panel extends JPanel {
    
    public Panel(){
        this.setFocusable(true);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.ORANGE);
        g.setColor(Color.decode("#123fff"));
        g.fillRect(0,0,Shapes.WIN_WIDTH,Shapes.WIN_HEIGHT);
        
        g.setColor(Color.BLUE);
        g.drawRect(100, 100, 150, 100);
        g.drawOval(200, 400, 100, 100);
        
    }
    
}
