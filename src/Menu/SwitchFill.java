/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Controller.State;
import MyShape.Filler;
import java.awt.Color;


/**
 *
 * @author Netbeans
 */
public class SwitchFill implements Command {
    
    State state;
    Filler filler;

    public SwitchFill(State state, Filler filler) {
        this.state = state;
        this.filler = filler;
    }

    @Override
    public void execude() {
        state.setFiller(this.filler);
    }
    
} 
