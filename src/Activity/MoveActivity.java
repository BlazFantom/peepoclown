/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activity;

import MyShape.MyShape;
import grafika.Model.Model;
import java.awt.geom.Point2D;

/**
 *
 * @author Netbeans
 */
public class MoveActivity implements Activity{

    Point2D[] p = new Point2D[2];
    Model model;
    MyShape shapeOld;
    MyShape shapeNew;

    @Override
    public void executePress(Point2D point) {
        p[0] = point;
       shapeNew = model.findShape(point);
       shapeOld = shapeNew.clone();
    }

    @Override
    public void executeDrag(Point2D point) {
        p[1] = point;
        model.moveShape(this.p);
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void execute() {
         Point2D oldP[] = new Point2D[2];

        oldP[0] = new Point2D.Double(shapeOld.getShape().getMinX(), shapeOld.getShape().getMinY());

        oldP[1] = new Point2D.Double(shapeOld.getShape().getMaxX(), shapeOld.getShape().getMaxY());

        shapeOld = shapeNew.clone();

        model.reseverMove(shapeNew, oldP);
    }

    @Override
    public void unexecute() {
        Point2D oldP[] = new Point2D[2];

        oldP[0] = new Point2D.Double(shapeOld.getShape().getMinX(), shapeOld.getShape().getMinY());

        oldP[1] =new Point2D.Double(shapeOld.getShape().getMaxX(), shapeOld.getShape().getMaxY());

        shapeOld = shapeNew.clone();

        model.reseverMove(shapeNew, oldP);
    }

    @Override
    public Activity clone() {
       
        
        MoveActivity a = new MoveActivity();
        a.setModel(model);
        a.shapeOld = shapeOld;
       a.shapeNew = shapeNew;
        return a;
    }

}
