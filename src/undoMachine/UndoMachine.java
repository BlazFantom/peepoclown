/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undoMachine;

import Activity.Activity;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Netbeans
 */
public class UndoMachine extends Observable{

     ArrayList<Activity> activityList;

     StateUndo stateUndo;

     Undoable stateDUndoDRedo;

     Undoable stateEUndoERedo;

     Undoable stateDUndoERedo;

     Undoable stateEUndoDRedo;

     Undoable state;

     int  undoIterator;

   

   public UndoMachine(){

        activityList = new  ArrayList<Activity>();

        this.stateUndo = StateUndo.DUndoDRedo;

        stateDUndoDRedo = new StateDUndoDRedo();

        stateEUndoERedo = new StateEUndoERedo();

        stateDUndoERedo = new StateDUndoERedo();

        stateEUndoDRedo = new StateEUndoDRedo();

        state = stateDUndoDRedo;

        undoIterator =-1;

    }

    public void add(Activity action){        state.add(action);    }

    public void execute(){        state.redo();    }

    public  void unexecute(){        state.undo();    }

    public int getUndoIterator() {        return undoIterator;    }

    void notifyMenu(){

       setChanged();

       notifyObservers(stateUndo);

    }
    
    
    public class Undoable {

        void undo() {

            activityList.get(undoIterator).unexecute();

            undoIterator--;

            if (undoIterator == -1) {

                state = stateDUndoERedo;

                stateUndo = StateUndo.DUndoERedo;

                notifyMenu();

            } else {

                goToEUndoERedo();

            }

        }

        void redo() {

            undoIterator++;

            activityList.get(undoIterator).execute();

            if (undoIterator == activityList.size() - 1) {

                state = stateEUndoDRedo;

                stateUndo = StateUndo.EUndoDRedo;
                notifyMenu();


            } else {

                goToEUndoERedo();

            }

        }

        final void add(Activity action) {

            deleteHistory();

            activityList.add(action);

            undoIterator++;

            stateUndo = StateUndo.EUndoDRedo;

            state = stateEUndoDRedo;

            notifyMenu();

        }

        void goToEUndoERedo() {

            state = stateEUndoERedo;

            stateUndo = StateUndo.EUndoERedo;

            notifyMenu();

        }

        void deleteHistory() {

            if (!activityList.isEmpty()) {

                for (int i = undoIterator; i < activityList.size(); i++) {

                    activityList.remove(i);

                }

            }

        }

    }
    
    
    
    
    class StateDUndoDRedo extends Undoable {

        @Override

        public void undo() {

            throw new UnsupportedOperationException("Not supported yet.");

        }

        @Override

        public void redo() {

            throw new UnsupportedOperationException("Not supported yet.");

        }

        @Override

        void goToEUndoERedo() {   }

        @Override

        void deleteHistory() {    }

    }

 

    class StateDUndoERedo extends Undoable {

        public void undo() {

            throw new UnsupportedOperationException("Not supported yet.");

        }

    }

 

    class StateEUndoDRedo extends Undoable {

        @Override

        public void redo() {

            throw new UnsupportedOperationException("Not supported yet.");

        }

        @Override

        void deleteHistory() {  }

    }

 

    class StateEUndoERedo extends Undoable {

        @Override

        void goToEUndoERedo() {  }

    }
}