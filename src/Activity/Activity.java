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
public interface Activity{
    void executePress(Point2D p);
    void executeDrag(Point2D p);
    public void setModel(Model model);   
}

