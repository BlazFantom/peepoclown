/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import undoMachine.StateUndo;

/**
 *
 * @author Netbeans
 */
public class SwitchState extends AbstractAction implements Observer{

    Command command;

    public SwitchState(String name, Icon icon, Command command) {
        super(name, icon);
        this.command = command;
          if (command.getClass() == SwitchUndo.class ||command.getClass() == SwitchRedo.class  ) {
              this.setEnabled(false);
          }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        command.execude();
    }
    
    @Override
    public void update(Observable o, Object arg) {
         StateUndo stateUndo = (StateUndo) arg;

        if (command.getClass() == SwitchUndo.class) {

            this.setEnabled(stateUndo.undo);

        } else {

            this.setEnabled(stateUndo.redo);

        }

    }    
}
