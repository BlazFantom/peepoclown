/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import Controller.Controller;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author avbrodovschuk
 */
public class MyPanel extends JPanel implements Observer{

MyPanel pan;

   Controller controller;

    public MyPanel(Controller c) {
        controller=c;
       
       
       
        this.addMouseListener(new MouseAdapter() {
           
            @Override
            public void mousePressed(MouseEvent e) {
               controller.pressed((Point2D)e.getPoint());
            }

           
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
               controller.dragged((Point2D)e.getPoint());
               
            }

           
        
        });
        
    }
       @Override
        protected void paintComponent(Graphics g){
         super.paintComponent(g);
            Graphics2D g2=(Graphics2D)g;
             controller.draw(g2);
        
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
    
    
    
}
