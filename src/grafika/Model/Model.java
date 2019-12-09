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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Netbeans
 */
public class Model extends Observable implements Serializable{

    ArrayList<MyShape> array;
    MyShape current;
    MyShape movedShape;

    public Model(MyShape s) {
        current = s;
        array = new ArrayList<>();
    }

    public Model() {
        array = new ArrayList<>();
    }

    public MyShape addShape() {
        current = current.clone();
        array.add(current);
        return current;
    }

    public void setFrame(Point2D[] pd) {
        current.setFrame(pd);
        setChanged();
        notifyObservers();
    }

    public void draw(Graphics2D g2) {
        if (array != null) {
            for (MyShape x : array) {
                x.draw(g2);
            }
        }
    }

    public MyShape findShape(Point2D p) {
        movedShape = null;
        for (MyShape x : array) {
            if (x.contains(p)) {
                movedShape = x;
                return movedShape;
            }
        }
        return null;
    }

    public void moveShape(Point2D[] p) {
        
        double deltaX = p[0].getX() - p[1].getX();

        double deltaY = p[0].getY() - p[1].getY();

        if (movedShape != null) {

            double xMin = movedShape.getShape().getMinX() - deltaX;
 
            double yMin = movedShape.getShape().getMinY() - deltaY;

            double xMax = movedShape.getShape().getMaxX() - deltaX;

            double yMax = movedShape.getShape().getMaxY() - deltaY;

            movedShape.setShapeSize(xMin, yMin, xMax, yMax);

            p[0] = p[1];

            setChanged();
            notifyObservers();
        }
    }

    public void setShape(MyShape shape) {
        current = shape;
    }

    public void reseverMove(MyShape shapeNew, Point2D[] oldP) {
        shapeNew.getShape().setFrameFromDiagonal(oldP[0],oldP[1]);
        movedShape = shapeNew;
        setChanged();
        notifyObservers();
    }

    public MyShape deleteShape() {
        MyShape s = array.get(array.size()-1);
        array.remove(s);
        setChanged();
        notifyObservers();
        return s;
       }

    public void add(MyShape shape) {
        array.add(shape);
        current = shape;
        setChanged();
        notifyObservers();
    }
     public void save(File file) throws IOException {
       // FileWriter w = new FileWriter(file); 
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(array);
        out.close();
    }
     public void open(File file) throws IOException {
        
        try {
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream(file));
            try {
                array=(ArrayList<MyShape>)fin.readObject();
                current =array.get(array.size()-1);
                setChanged();
        notifyObservers();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}
