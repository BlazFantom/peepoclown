/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Controller.State;
import java.awt.Color;
import java.awt.geom.RectangularShape;
import javax.swing.JColorChooser;

/**
 *
 * @author Netbeans
 */
public class SwitchColor implements Command {
    
    State state;
    Color color;

    public SwitchColor(State state, Color color) {
        this.state = state;
        this.color = color;
        
    }

    @Override
    public void execude() {
        this.color = JColorChooser.showDialog(null, "color Chooser", this.color);
        state.setColor(color);
    }

}
