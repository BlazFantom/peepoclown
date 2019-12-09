/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import Activity.DrawActivity;
import Activity.MoveActivity;
import Controller.State;
import Menu.InputActivity;
import Menu.OutputActivity;
import Menu.SwitchActivity;
import Menu.SwitchColor;
import Menu.SwitchFill;
import Menu.SwitchRedo;
import Menu.SwitchShape;
import Menu.SwitchState;
import Menu.SwitchUndo;
import MyShape.Filling;
import MyShape.NoFilling;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Observer;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import undoMachine.UndoMachine;

/**
 *
 * @author avbrodovschuk
 */
public class MyFrame extends JFrame {

    MyPanel myPanel;
    State state;
    UndoMachine undoMachine;
    public MyFrame(MyPanel my, State s, UndoMachine undoMachine) {
        state = s;
        this.myPanel = my;
        add(myPanel);
        this.undoMachine = undoMachine;
        //////////////////////////////////////
        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);
        JToolBar toolBar = new JToolBar();
        add(toolBar, BorderLayout.NORTH);

        ArrayList<JMenu> menu = new ArrayList<>();
        menu.add(new JMenu("File"));              
        menu.add(new JMenu("Shape"));
        menu.add(new JMenu("Color"));
        menu.add(new JMenu("Filler"));
        menu.add(new JMenu("Activity"));
        menu.add(new JMenu("UndoRedo"));
        ArrayList<ArrayList<Action>> bigList = new ArrayList<>();
        ArrayList<Action> IoFile = new ArrayList<>();
        IoFile.add(new SwitchState("Open", new ImageIcon("13.png"), new InputActivity(state)));
        IoFile.add(new SwitchState("Save", new ImageIcon("14.png"), new OutputActivity(state)));
        bigList.add(IoFile);
        ArrayList<Action> shapeList = new ArrayList<>();
        shapeList.add(new SwitchState("rectangle", new ImageIcon("02.png"), new SwitchShape(state, new Rectangle2D.Double())));
        shapeList.add(new SwitchState("ellipse", new ImageIcon("03.png"), new SwitchShape(state, new Ellipse2D.Double())));
        bigList.add(shapeList);
        ArrayList<Action> colorList = new ArrayList<>();
        colorList.add(new SwitchState("color", new ImageIcon("06.png"), new SwitchColor(state, Color.BLUE))); 
        bigList.add(colorList);
        ArrayList<Action> fillingList = new ArrayList<>();
        fillingList.add(new SwitchState("filling", new ImageIcon("01.png"), new SwitchFill(state, new Filling()))); 
        fillingList.add(new SwitchState("no filling", new ImageIcon("05.png"), new SwitchFill(state, new NoFilling()))); 
        bigList.add(fillingList);
        ArrayList<Action> activityList = new ArrayList<>();
        activityList.add(new SwitchState("Draw", new ImageIcon("10.png"), new SwitchActivity(state, new DrawActivity()))); 
        activityList.add(new SwitchState("Move", new ImageIcon("09.png"), new SwitchActivity(state, new  MoveActivity()))); 
        bigList.add(activityList);
        
        
       
        ArrayList<Action> undoredo = new ArrayList<>();
        undoredo.add(new SwitchState("Undo", new ImageIcon("11.png"), new SwitchUndo(undoMachine)));
        undoredo.add(new SwitchState("Redo", new ImageIcon("12.png"), new SwitchRedo(undoMachine)));
        for(Action x: undoredo) {
            undoMachine.addObserver((Observer) x);
        }
        bigList.add(undoredo);
        
        for (int i = 0; i < menu.size(); i++) {
            bar.add(menu.get(i));
            for (Action x : bigList.get(i)) {
                menu.get(i).add(x);
                toolBar.add(x);
            }
        }
        
        /////////////////////////////////////
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // pane.add(myPanel2, BorderLayout.SOUTH);
        this.setVisible(true);

    }

}
