/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexit;

import java.awt.*;
/**
 *
 * @author bryon
 */
public class Hexagon extends Polygon {
    
    public static final int SIDES = 6;
    private Point[] corners = new Point[SIDES];
    private Point center = new Point(0, 0);
    private int radius;
    private int rotation = 90;
    
    public Hexagon(Point center, int radius) {
        npoints = SIDES;
        xpoints = new int[SIDES];
        ypoints = new int[SIDES];
        
        this.center = center;
        this.radius = radius;
        
    }
    
    public Hexagon(int x, int y, int radius){
        this(new Point(x, y), radius);
    }
    
    public Point getCenter() {
        return center;
    }
    
    public void setCenter(Point center){
        this.center = center;
    }
    
    public void setCenter(int x, int y){
        setCenter(new Point(x, y));
    }
    
    public int getRadius(){
        return radius;
    }
        
    public void setRadius(int radius){
        this.radius = radius;
        updateCorners();
    }
    
    public int getRotation(){
        return rotation;
    }
    
    public void setRotation(int rotation){
        this.rotation = rotation;
        updateCorners();
    }
    
    private double findAngle(double fraction){
        return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
    }
    
    private Point findPoint(double angle){
        int x = (int) (center.x + Math.cos(angle) * radius);
        int y = (int) (center.y + Math.sin(angle) * radius);                
        return new Point(x, y);
    }
    
    protected void updateCorners(){
        for (int c = 0; c < SIDES; c++){
            double angle = findAngle((double) c / SIDES);
            Point corner = findPoint(angle);
            xpoints[c] = corner.x;
            ypoints[c] = corner.y;
            corners[c] = corner;
        }
    }
    
    public void draw(Graphics2D g, int x, int y, int lineThickness, int colorValue, boolean filled){
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();
        
        g.setColor(new Color(colorValue));
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
    
        //
        g.setColor(Color.GREEN);
        
        
        if(filled){
            g.fillPolygon(xpoints, ypoints, npoints);
        } else {
            g.drawPolygon(xpoints, ypoints, npoints);
        }
        
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }
}
