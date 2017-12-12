/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;
import javax.swing.*;
/**
 *
 * @author bryon
 */
public class Shapes extends JFrame {
    
    final static int WIN_WIDTH = 800;
    final static int WIN_HEIGHT = 600;

    public Shapes(){
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel panel = new Panel();
        add(panel);
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new Shapes();
    }
    
}
