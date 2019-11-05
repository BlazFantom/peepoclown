/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activity;

import grafika.Model.Model;
import java.awt.geom.Point2D;

/**
 *
 * @author Netbeans
 */
public class MoveActivity implements Activity{
Point2D[] p = new Point2D[2];
 Model model;
    @Override
    public void executePress(Point2D point) {
        p[0]= point;
        model.findShape(point);
    }

    @Override
    public void executeDrag(Point2D p) {
        model.moveShape(p);
    }

    @Override
    public void setModel(Model model) {
        this.model= model;
    }
    
}
