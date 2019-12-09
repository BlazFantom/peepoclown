/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activity;

import MyShape.MyShape;
import grafika.Model.Model;
import java.awt.geom.Point2D;


public class DrawActivity implements Activity{
Point2D[] p= new Point2D[2];
Model model;
MyShape shape;
    @Override
    public void executePress(Point2D point) {
        p[0] = point;
       shape = model.addShape();
    }

    @Override
    public void executeDrag(Point2D p) {
        this.p[1]= p;
        model.setFrame(this.p);
    }

    @Override
    public void setModel(Model model) {
        this.model  = model;
    }

    @Override
    public void execute() {
             model.add(shape);
    }

    @Override
    public void unexecute() {
         shape = model.deleteShape();
    }

    @Override
    public Activity clone() {
        Activity a = new DrawActivity();
        a.setModel(model);
        ((DrawActivity)a).shape = shape.clone();
        return a;
    }
    
  
    
}
