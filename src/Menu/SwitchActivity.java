/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Activity.Activity;
import Controller.State;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Netbeans
 */
public class SwitchActivity  implements Command {
     State state;
    Activity action;

    public SwitchActivity(State state, Activity action) {
        this.state = state;
        this.action = action;
    }

    @Override
    public void execude() {
        state.setActivity(action);
    }

}
