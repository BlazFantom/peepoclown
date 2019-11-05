/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author avbrodovschuk
 */
public class MyFrame extends JFrame{
    MyPanel myPanel;
    MyPanel myPanel2;

    public MyFrame(MyPanel my) {
       
        this.myPanel = my;
       Container pane = getContentPane();
        this.myPanel2 =my;
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pane.add(myPanel);
      // pane.add(myPanel2, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
        
    }

   
    
}
