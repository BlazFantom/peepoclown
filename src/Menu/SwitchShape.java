/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Controller.State;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Netbeans
 */
public class SwitchShape implements Command {

    State state;
    RectangularShape shape;

    public SwitchShape(State state, RectangularShape shape) {
        this.state = state;
        this.shape = shape;
    }

    @Override
    public void execude() {
        state.setShape(shape);
    }

}
