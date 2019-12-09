/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Controller.State;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Netbeans
 */
public class InputActivity implements Command{
    State state;

    public InputActivity(State state) {
        this.state = state;
    }
    
    @Override
    public void execude() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = fc.getSelectedFile();
                    try {
                        state.open(file);
                    
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }

                }

        }



    }
    

