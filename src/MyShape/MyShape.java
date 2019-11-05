/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyShape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.Observable;

/**
 *
 * @author Netbeans
 */
public class MyShape {
    RectangularShape rd;
    Filler filler;
    Color color;
    public MyShape(RectangularShape rd) {
        this.rd = rd;
        filler=new NoFilling();
        
    }

    public RectangularShape getRd() {
        return rd;
    }
    
    public void setFrame(Point2D[] pd) {
        rd.setFrameFromDiagonal(pd[0],pd[1]);
        
    }

    public MyShape(RectangularShape rd, Filler filler) {
        this.rd = rd;
        this.filler = filler;
        color = color.red;
    }
    
    public MyShape(RectangularShape rd, Filler filler, Color color) {
        this.rd = rd;
        this.filler = filler;
        this.color = color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public MyShape clone(){
        MyShape shape = new MyShape((RectangularShape)rd.clone());
        shape.color = color;
        shape.filler = filler.clone();
        return shape;
    }
    
   

    public void draw(Graphics2D g2) {
       
            filler.Filling(g2,this);
           
    }

    public boolean contains(Point2D p) {
        
        return rd.contains(p);
        
    }

  
    
}
