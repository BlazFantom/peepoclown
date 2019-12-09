/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Activity.Activity;
import Activity.DrawActivity;
import MyShape.MyShape;
import MyShape.Filler;
import MyShape.Filling;
import MyShape.NoFilling;
import grafika.Model.Model;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Netbeans
 */
public class State {
    MyShape shape;
    Activity activity;
    Color color;
    Model model;
    Filler filler;
    
    public State(Model model) {
        this.model = model;
        shape = new MyShape(new Rectangle2D.Double(), new Filling(), null);
        model.setShape(shape);
        activity = new DrawActivity();
        activity.setModel(model);
    }

    public void setShape(RectangularShape shape) {
       this.shape.setShape(shape);
        model.setShape(this.shape);
    }
    
    public void setColor(Color color) {
        this.color = color;
        this.shape.setColor(color);
        model.setShape(this.shape);
    }
    
    public void setFiller(Filler filler) {
        this.filler = filler;
        this.shape = new MyShape(this.shape.getRd(), filler, this.shape.getColor());
        model.setShape(this.shape);
    }
    
    Activity getActivity() {
        return activity;
    }
    
    public void setActivity (Activity action) {
        activity = action;
        activity.setModel(model);
    }
    public void save(File file) throws IOException {
                    model.save(file);
        
    }
    public void open(File file) throws IOException {
        
            model.open(file);
       
    }
    
}
