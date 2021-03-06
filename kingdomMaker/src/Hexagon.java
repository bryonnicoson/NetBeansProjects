
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
public class Hexagon extends Polygon {
    
    public static final int EDGES = 6;
    
    private Point[] corners = new Point[EDGES];
    private Point center = new Point(0, 0);
    private int radius;
    private int rotation = 90;
    
    public Hexagon (Point center, int radius){
        npoints = EDGES;
        xpoints = new int[EDGES];
        ypoints = new int[EDGES];
        
        this.center = center;
        this.radius = radius;
        
        updateCorners();
    }
    
    public Hexagon (int x, int y, int radius){
        this(new Point(x, y), radius);
    }
    
    public Point getCenter(){
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
    }
    
    public int getRotation(){
        return rotation;
    }
    
    public void setRotation(int rotation){
        this.rotation = rotation;
    }
    
    private double findAngle(double fraction){
        return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
    }
    
    private Point findPoint(double angle){
        int x = (int) (center.x + Math.cos(angle) * radius);
        int y = (int) (center.y + Math.sin(angle) * radius);
        return new Point(x, y);
    }
    
    protected void updateCorners() {
        for (int c = 0; c < EDGES; c++) {
            double angle = findAngle((double) c / EDGES);
            Point point = findPoint(angle);
            xpoints[c] = point.x;
            ypoints[c] = point.y;
            corners[c] = point;
        }
    }
    
    public void drawHexagon(Graphics2D g, int x, int y, int lineThickness, int colorValue, boolean filled){
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();
        
        g.setColor(new Color(colorValue));
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        
        if(filled)
            g.fillPolygon(xpoints, ypoints, npoints);
        else
            g.drawPolygon(xpoints, ypoints, npoints);
        
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }
}
