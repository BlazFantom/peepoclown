/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import Controller.Controller;
import MyShape.*;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author avbrodovschuk
 */
public class Main {
    public static void main(String [] s){
        
       new Controller(new MyShape(new Rectangle2D.Double(),new NoFilling(), Color.RED));
    }
}
