/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import undoMachine.UndoMachine;

/**
 *
 * @author Netbeans
 */
public class SwitchUndo implements Command{

    UndoMachine machine;

    public SwitchUndo(UndoMachine machine) {
        this.machine = machine;
    }
    
    @Override
    public void execude() {
        machine.unexecute();
    }
    
}
