/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika.Model;

import MyShape.Filling;
import MyShape.MyShape;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Netbeans
 */
public class Model extends Observable{
    ArrayList<MyShape> array;
    MyShape current;

    public Model(MyShape s) {
        current = s;
        array = new ArrayList<>();
    }
    public void addShape(){
       current = current.clone();
       array.add(current);
        
    }

    public void setFrame(Point2D[] pd) {
        current.setFrame(pd);
        setChanged();
        notifyObservers();
    }

    public void draw(Graphics2D g2) {
        if(array != null)
            for (MyShape x: array){
            x.draw(g2);
            }
    }
     public boolean findShape(Point2D p){
         for(MyShape x: array)
             if(x.contains(p))
        return true;
        return false;
    }
     void moveShape(Point2D[]p){

        double deltaX = p[0].getX()-p[1].getX();

        double deltaY = p[0].getY()-p[1].getY();

        if(current!=null){

            double xMin = current.getMinX()-deltaX;

            double yMin = current.getMinY()-deltaY;

            double xMax = current.getMaxX()-deltaX;

            double yMax = current.getMaxY()-deltaY;

            current.setShapeSize(xMin, yMin, xMax, yMax);

            p[0]=p[1];

            notifyPanel();

        }

    }
}
