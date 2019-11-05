/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Activity.Activity;
import Activity.DrawActivity;
import MyShape.MyShape;
import grafika.Model.Model;
import grafika.MyFrame;
import grafika.MyPanel;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;


/**
 *
 * @author Netbeans
 */
public class Controller {
    MyShape shape;
    MyPanel panel;
    MyFrame frame;
    Model model;
    Activity activity;
    public Controller(MyShape shape) {
        this.shape = shape;
        panel = new MyPanel(this);
        model = new Model(shape);
        model.addObserver(panel);
        frame = new MyFrame(panel);
        activity = new DrawActivity();
        activity.setModel(model);
    }

   

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }

    public void pressed(Point2D point2D) {
        activity.executePress(point2D);
    }

    public void dragged(Point2D point2D) {
        activity.executeDrag(point2D);
    }
    
    
  
   
}
