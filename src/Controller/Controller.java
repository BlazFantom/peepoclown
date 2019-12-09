/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import grafika.Model.Model;
import grafika.MyFrame;
import grafika.MyPanel;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import undoMachine.UndoMachine;

public class Controller {
   
    MyPanel panel;
    MyFrame frame;
    Model model;
    State state;
    UndoMachine undoMichine;
    public Controller() {
        undoMichine = new UndoMachine();
        panel = new MyPanel(this);
        model = new Model();
        model.addObserver(panel);
        state = new State(model);
        frame = new MyFrame(panel, state, undoMichine);
       
    }
    
    public void draw(Graphics2D g2) {
        model.draw(g2);
    }

    public void pressed(Point2D point2D) {
        state.getActivity().executePress(point2D);
        undoMichine.add(state.getActivity().clone());
    }

    public void dragged(Point2D point2D) {
         state.getActivity().executeDrag(point2D);
    }
    
    
  
   
}
